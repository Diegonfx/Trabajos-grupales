package darkRoom;

import java.util.Date;

/**
 * Created by Tomas on 25/4/2017.
 */
public class Voter {
    private Date initialTime;
    private Boletas boletaElegida;

    public Voter(Date initialTime){
        this.initialTime = initialTime;
        boletaElegida = null;
    }

    public Date getInitialTime() {
        return initialTime;
    }
    public Boletas getBoletaElegida() {
        return boletaElegida;
    }
    public void setBoletaElegida(Boletas boletaElegida) {
        this.boletaElegida = boletaElegida;
    }
}
