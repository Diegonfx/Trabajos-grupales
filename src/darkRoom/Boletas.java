package darkRoom;

/**
 * Created by Tomas on 25/4/2017.
 */
public class Boletas {
    private int id;
    private String partidoPolitico;

    public Boletas(String partidoPolitico, int id) {
        this.partidoPolitico = partidoPolitico;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getPartidoPolitico() {
        return partidoPolitico;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPartidoPolitico(String partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }
}
