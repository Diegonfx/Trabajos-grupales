package darkRoom;

import TP_Lists.Listas.StaticList;
import TrabajoPractico3.Stacks.StaticStack.StaticStack;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Tomas on 25/4/2017.
 */
public class DarkRoom {
    private Voter voter;
    private StaticList<StaticStack<Boletas>> boletas;
    private StaticList<PartidoPolitico> partidos;

    public DarkRoom(StaticList<PartidoPolitico> partidos){
        voter = null;
        boletas = new StaticList<>(partidos.size());
        this.partidos = partidos;

        boletas.goTo(0);
        StaticStack<Boletas> boletas1 = new StaticStack<>(200);
        boletas.insertPrev(boletas1);
        for (int i = 0; i < 4; i++){
            boletas.goTo(i);
            StaticStack<Boletas> boletas2 = new StaticStack<>(200);
            boletas.insertNext(boletas2);
        }
        refillAllStacks();
    }

    public Voter getVoter() {
        return voter;
    }
    public void setVoter(Voter voter) {
        this.voter = voter;
    }
    public StaticList<StaticStack<Boletas>> getBoletas() {
        return boletas;
    }
    public StaticList<PartidoPolitico> getPartidos() {
        return partidos;
    }

    public void refillAllStacks(){
        for (int i = 0; i < boletas.size(); i++){
            boletas.goTo(i);
            partidos.goTo(i);
            if (boletas.getActual().size() < 200) {
                for (int j = 0; j < 200; j++) {
                    boletas.getActual().push(new Boletas(partidos.getActual().getName(), ThreadLocalRandom.current().nextInt(0, 1000)));
                }
            }
        }
    }

    public boolean roomIsEmpty(){
        return voter == null;
    }

    public void pickBoleta(){
        if (!roomIsEmpty()) {
            int partidoElegido = ThreadLocalRandom.current().nextInt(0, partidos.size());
            boletas.goTo(partidoElegido);
            if (!boletas.getActual().isEmpty()) {
                voter.setBoletaElegida(boletas.getActual().peek());
                boletas.getActual().pop();
            }
        }
    }
}
