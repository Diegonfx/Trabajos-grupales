package darkRoom;

import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

/**
 * Created by Tomas on 25/4/2017.
 */
public class VotingUrn {
    private DynamicStack<Boletas> votos;
    private DynamicStack<Boletas> votos2;

    public VotingUrn(){
        votos = new DynamicStack<>();
        votos2 = new DynamicStack<>();
    }

    public DynamicStack<Boletas> getVotos() {
        return votos;
    }

    public void addBoleta(Voter voter){
        if (voter.getBoletaElegida() == null)
            throw new RuntimeException("No agarro boleta");
        votos.push(voter.getBoletaElegida());
        votos2.push(voter.getBoletaElegida());
    }

    public void ultimas10(){

        for (int i = 0; i < 10; i++) {
            if (!votos2.isEmpty()){
                System.out.println("Voto para " + votos2.peek().getPartidoPolitico() + ", id de la boleta: " + votos2.peek().getId());
                votos2.pop();
            }
        }
    }
}
