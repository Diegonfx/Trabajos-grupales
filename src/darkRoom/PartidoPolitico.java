package darkRoom;

/**
 * Created by Tomas on 25/4/2017.
 */
public class PartidoPolitico {
    private String name;
    private int votos;

    public PartidoPolitico(String name){
        this.name = name;
        votos = 0;
    }

    public String getName() {
        return name;
    }
    public int getVotos() {
        return votos;
    }
    public void setVotos(int votos) {
        this.votos = votos;
    }
}
