package darkRoom;

import TP_Lists.Listas.StaticList;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Tomas on 25/4/2017.
 */
public class MainSimulator {
    public static void main(String[] args) {
        StaticList<PartidoPolitico> partidosPoliticos = new StaticList<>(5);
        partidosPoliticos.goTo(0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del primer partido politico: ");
        String firstPartyName = scanner.next();
        PartidoPolitico firstParty = new PartidoPolitico(firstPartyName);
        partidosPoliticos.insertPrev(firstParty);
        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese el nombre del siguiente partido: ");
            String nextPartyName = scanner.next();
            PartidoPolitico nextParty = new PartidoPolitico(nextPartyName);
            partidosPoliticos.insertNext(nextParty);
        }


        VotingTable votingTable = new VotingTable(partidosPoliticos);
        System.out.println("1 - Ingresar nuevo votante a la mesa");
        System.out.println("2 - Ingresar votante al cuarto oscuro");
        System.out.println("3 - Retirar persona del cuarto oscuro");
        System.out.println("4 - Rellenar las boletas");
        System.out.println("5 - Cerrar mesa y hacer recuento");
        System.out.println("Ingrese el numero de la accion a realizar: ");
        int action = scanner.nextInt();
        while (action != 5){
            System.out.println("1 - Ingresar nuevo votante a la mesa");
            System.out.println("2 - Ingresar votante al cuarto oscuro");
            System.out.println("3 - Retirar persona del cuarto oscuro");
            System.out.println("4 - Rellenar las boletas");
            System.out.println("5 - Cerrar mesa y hacer recuento");
            switch (action){
                case 1:
                    votingTable.addVoterToLine(new Date());
                    break;

                case 2:
                    votingTable.addVoterToDarkRoom(new Date());
                    votingTable.getDarkRoom().pickBoleta();
                    break;

                case 3:
                    votingTable.voterGoesOutOfDarkRoom(new Date());
                    break;

                case 4:
                    votingTable.getDarkRoom().refillAllStacks();
                    break;

                default:
                    break;
            }

            System.out.println("Ingrese otra accion: ");
            action = scanner.nextInt();
        }
        if (action == 5){
            System.out.println("El tiempo medio de la mesa fue: " + votingTable.averageTimeOnLine() + " segundos");
            System.out.println("Las ultimas diez boletas fueron: ");
            votingTable.getVotingUrn().ultimas10();
            votingTable.recuentoDeVotos();
            System.out.println("El ganador de la eleccion fue el partido " + votingTable.winningParty().getName() + " con " + votingTable.winningParty().getVotos() + " votos");
            System.out.println("El tiempo medio de espera dentro del cuarto oscuro fue: " + votingTable.averageTimeInsideDarkRoom() + " segundos");
        }
    }

}
