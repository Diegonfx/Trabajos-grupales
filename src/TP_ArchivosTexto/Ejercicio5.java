package TP_ArchivosTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Tomas on 13/6/2017.
 */
public class Ejercicio5 {
    public void divider(String fileNameFrom, String fileNameTo1, String fileNameTo2, int maxDivider, String extraOption){
        try {
            String[] campos;
            FileReader fr = new FileReader(fileNameFrom);
            BufferedReader bf = new BufferedReader(fr);
            String line = bf.readLine();
            FileWriter fr2 = new FileWriter(fileNameTo1);
            FileWriter fr3 = new FileWriter(fileNameTo2);
            while (line != null){
                campos = line.split(";");
                if (Integer.parseInt(campos[1]) > maxDivider){
                    if (extraOption.equals("PBI")){
                        String str = campos[0] + ";" + campos[2];
                        fr2.write(str + "\n");
                    } else if (extraOption.equals("POB")){
                        String str = campos[0] + ";" + campos[1];
                        fr2.write(str + "\n");
                    }
                    else {
                        String str = campos[0] + ";" + campos[1] + ";" + campos[2];
                        fr2.write(str + "\n");
                    }
                } else {
                    if (extraOption.equals("PBI")){
                        String str = campos[0] + ";" + campos[2];
                        fr3.write(str + "\n");
                    } else if (extraOption.equals("POB")){
                        String str = campos[0] + ";" + campos[1];
                        fr3.write(str + "\n");
                    }
                    else {
                        String str = campos[0] + ";" + campos[1] + ";" + campos[2];
                        fr3.write(str + "\n");
                    }
                }
                line = bf.readLine();
            }
            fr.close();
            bf.close();
            fr2.close();
            fr3.close();
        }catch (IOException e){
            System.out.println("ERROR!");
        }
    }

    public static void main(String[] args) {
        String fileName = "prueba1";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("Wakanda;36;123\n");
            fileWriter.write("Kamchatka;26;124\n");
            fileWriter.write("Argentina;15;125\n");
            fileWriter.write("EEUU;58;126\n");
            fileWriter.write("Holanda;32;127\n");
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        Ejercicio5 ej = new Ejercicio5();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el max numero de habitantes para dividir: ");
        int divider = scanner.nextInt();
        System.out.println("Ingrese el tipo de operacion a realizar: ");
        String type = scanner.next();
        ej.divider(fileName, "MayorQDivider", "MenorQDivider", divider, type);
    }
}
