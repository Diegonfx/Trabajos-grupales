package TP_ArchivosTexto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Tomas on 13/6/2017.
 */
public class Ejercicio2 {
    public int charCounter(char charToCount, String fileName){
        int counter = 0;
        try{
            FileReader fr = new FileReader(fileName);
            int a = fr.read();
            while (a != -1){
                if (charToCount == (char) a)
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

    public static void main(String[] args) {
        String fileName = "prueba2";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("blabla\nblabla");
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        Ejercicio2 ej = new Ejercicio2();
        System.out.println(ej.charCounter('a', fileName));
    }
}
