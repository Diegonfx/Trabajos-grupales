package TP_ArchivosTexto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Tomas on 13/6/2017.
 */
public class Ejercicio3 {
    public void typeChanger(String convert, String fileNameFrom, String fileNameTo){
        String str = "";
        if (convert.equals("mayus")){
            try {
                FileReader fr = new FileReader(fileNameFrom);
                int a = fr.read();
                while (a != -1){
                    str = str + (char) a;
                    str = str.toUpperCase();
                    a = fr.read();
                }
                fr.close();
                FileWriter fr2 = new FileWriter(fileNameTo);
                fr2.write(str);
                fr2.close();
            }catch (IOException e){
                System.out.println("ERROR!");
            }
        }
        else if (convert.equals("minus")){
            try {
                FileReader fr = new FileReader(fileNameFrom);
                int a = fr.read();
                while (a != -1){
                    str = str + (char) a;
                    str = str.toLowerCase();
                    a = fr.read();
                }
                fr.close();
                FileWriter fr2 = new FileWriter(fileNameTo);
                fr2.write(str);
                fr2.close();
            }catch (IOException e){
                System.out.println("ERROR!");
            }
        }
        else
            throw new RuntimeException("Converter must be called mayus or minus");
    }

    public static void main(String[] args) {
        String fileNameFrom = "Desde";
        /*try {
            FileWriter fileWriter = new FileWriter(fileNameFrom);
            fileWriter.write("bLaBlAbLaBlA");
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }*/

        //Primero correrlo una vez solo con el try para crear el archivo, despues correrlo solo con el ejercicio para recorrerlo

        Ejercicio3 ej = new Ejercicio3();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tipo de operacion a realizar: ");
        String type = scanner.next();
        if (type.equals("mayus"))
            ej.typeChanger(type, fileNameFrom, "Mayus");
        else
            ej.typeChanger(type, fileNameFrom, "Minus");

    }
}
