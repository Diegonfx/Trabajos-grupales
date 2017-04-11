package TrabajoPractico_BinaryTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DiegoMancini on 8/4/17.
 */
public class TP04_Methods {

    public <T> void inOrden(BinaryTree<T>  a){
        if(!a.isEmpty()){
            inOrden(a.getLeft());
            System.out.println(a.getRootElement());
            inOrden(a.getRight());
        }
    }

    private <T> ArrayList inOrdenS(BinaryTree<T> a, ArrayList<T> list){
        if (!a.isEmpty()){
            inOrdenS(a.getLeft(), list);
            list.add(a.getRootElement());
            inOrdenS(a.getRight(), list);
        }
        return list;
    }

    public <T> ArrayList inOrdenS(BinaryTree<T> a){
      ArrayList list = new ArrayList();
      inOrdenS(a,list);
      return list;
    }

    public <T> void preOrden (BinaryTree<T> a){
        if (!a.isEmpty()) {
            System.out.print(a.getRootElement());
            preOrden(a.getLeft());
            preOrden(a.getRight());
        }
    }

    public <T> void postOrden (BinaryTree<T> a){
        if (!a.isEmpty()) {
            postOrden(a.getLeft());
            postOrden(a.getRight());
            System.out.print(a.getRootElement());
        }
    }

    private <T> void byLevel(BinaryTree<T> a,ArrayList<T> level){
        for(int i = 1; i <= a.height(); i++){
            if(!a.getLeft().isEmpty()){
                level.add(a.getLeft().getRootElement());
                System.out.println(a.getLeft().getRootElement());
            }
            if(!a.getRight().isEmpty()){
                level.add(a.getRight().getRootElement());
                System.out.println(a.getRight().getRootElement());
            }
        }

        byLevel(a,level);
    }

    public <T> void byLevel (BinaryTree<T> a) {
        ArrayList<T> list = new ArrayList<>();
        byLevel(a, list);
    }

    public <T> void serializeBinary(BinaryTree<T> a,String fileName){
        try {
            File file = new File(fileName);
            if (!file.exists())
                file.createNewFile();

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(a);
            System.out.println("Serialized");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public <T> BinaryTree<T> deserializeBinary(String fileName){
        ObjectInputStream ois;
        try{
            ois = new ObjectInputStream(new FileInputStream(fileName));
            Object obj = ois.readObject();
            if(obj instanceof BinaryTree){
                System.out.println("Deserialized");
                return (BinaryTree<T>) obj;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        throw new RuntimeException();
    }
}
