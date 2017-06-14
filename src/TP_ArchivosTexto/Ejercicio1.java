package TP_ArchivosTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Tomas on 13/6/2017.
 */
public class Ejercicio1 {
    public int counter(String counterType, String fileName){
        if (counterType.equals("C")){
            int counter = 0;
            try{
                FileReader fr = new FileReader(fileName);
                int a = fr.read();
                while (a != -1){
                    counter++;
                    a = fr.read();
                }
                fr.close();
            }
            catch(IOException e){
                System.out.println("ERROR!");
            }
            return counter;
        }
        else if (counterType.equals("L")){
            int counter = 0;
            try{
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String str = br.readLine();
                while (str !=null){
                    counter++;
                    str=br.readLine();
                }
                br.close();
            }
            catch(IOException e) {
                System.out.println("ERROR!");
            }
            return counter;
        }
        else
            throw new RuntimeException("Operations must be C or L");
    }


    public static void main(String[] args) {
        String fileName = "prueba1";
        /*try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("blablablabla");
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }*/

        //Primero correrlo una vez solo con el try para crear el archivo, despues correrlo solo con el ejercicio para recorrerlo

        Ejercicio1 ej = new Ejercicio1();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tipo de operacion a realizar: ");
        String type = scanner.next();

        System.out.println(ej.counter(type, fileName));
    }
}
