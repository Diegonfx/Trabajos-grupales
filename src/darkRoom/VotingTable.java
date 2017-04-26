package darkRoom;

import TP_Lists.Listas.StaticList;
import TrabajoPractico4_Queue.DynamicQueue;

import java.util.Date;

/**
 * Created by Tomas on 25/4/2017.
 */
public class VotingTable {
    private DarkRoom darkRoom;
    private DynamicQueue<Voter> voters;
    private VotingUrn votingUrn;
    private long timeSpendOnLine;
    private int votersWhoEntered;
    private int votersWhoGotOut;
    private long timeSpendInside;
    private Date goesInsideDarkRoom;

    public VotingTable(StaticList<PartidoPolitico> partidos){
        darkRoom = new DarkRoom(partidos);
        voters = new DynamicQueue<>();
        votingUrn = new VotingUrn();
        timeSpendOnLine = 0;
        votersWhoEntered = 0;
        votersWhoGotOut = 0;
        timeSpendInside = 0;
    }

    public DarkRoom getDarkRoom() {
        return darkRoom;
    }
    public DynamicQueue<Voter> getVoters() {
        return voters;
    }
    public VotingUrn getVotingUrn() {
        return votingUrn;
    }
    public double getTimeSpendOnLine() {
        return timeSpendOnLine;
    }
    public int getVotersWhoEntered() {
        return votersWhoEntered;
    }
    public int getVotersWhoGotOut() {
        return votersWhoGotOut;
    }
    public long getTimeSpendInside() {
        return timeSpendInside;
    }

    public void addVoterToLine(Date initialDate){
        Voter newVoter = new Voter(initialDate);
        voters.enqueue(newVoter);
    }

    public void addVoterToDarkRoom(Date finalDate){
        if (!voters.isEmpty()) {
            if (darkRoom.roomIsEmpty()) {
                goesInsideDarkRoom = finalDate;
                darkRoom.setVoter(voters.getFront());
                votersWhoEntered++;
                timeSpendOnLine += finalDate.getTime() - voters.getFront().getInitialTime().getTime();
                voters.dequeue();
            }
        }
    }

    public void voterGoesOutOfDarkRoom(Date finalDate){
        if (!darkRoom.roomIsEmpty()) {
            votingUrn.addBoleta(darkRoom.getVoter());
            darkRoom.setVoter(null);
            votersWhoGotOut++;
            timeSpendInside += finalDate.getTime() - goesInsideDarkRoom.getTime();
        }
    }

    public float averageTimeOnLine(){
        if (votersWhoEntered == 0)
            return timeSpendOnLine;
        return (float) (timeSpendOnLine/ votersWhoEntered)/1000;
    }

    public float averageTimeInsideDarkRoom(){
        if (votersWhoGotOut == 0)
            return timeSpendInside;
        return (float) (timeSpendInside/votersWhoGotOut)/1000;
    }

    public void recuentoDeVotos(){
        while (!votingUrn.getVotos().isEmpty()) {
            String partido = votingUrn.getVotos().peek().getPartidoPolitico();
            for (int i = 0; i < darkRoom.getPartidos().size(); i++) {
                darkRoom.getPartidos().goTo(i);
                if (partido.equals(darkRoom.getPartidos().getActual().getName())) {
                    darkRoom.getPartidos().getActual().setVotos(darkRoom.getPartidos().getActual().getVotos() + 1);
                    votingUrn.getVotos().pop();
                }
            }
        }
    }

    public PartidoPolitico winningParty(){
        darkRoom.getPartidos().goTo(0);
        PartidoPolitico winner = darkRoom.getPartidos().getActual();
        for (int i = 0; i < darkRoom.getPartidos().size(); i++) {
            darkRoom.getPartidos().goTo(i);
            if (winner.getVotos() < darkRoom.getPartidos().getActual().getVotos())
                winner = darkRoom.getPartidos().getActual();
        }

        return winner;
    }
}
