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
            System.out.println(a.getRoot());
            inOrden(a.getRight());
        }
    }

    public <T> void preOrden (BinaryTree<T> a){
        if (!a.isEmpty()) {
            System.out.print(a.getRoot());
            preOrden(a.getLeft());
            preOrden(a.getRight());
        }
    }

    public <T> void postOrden (BinaryTree<T> a){
        if (!a.isEmpty()) {
            postOrden(a.getLeft());
            postOrden(a.getRight());
            System.out.print(a.getRoot());
        }
    }

    private <T> void byLevel(BinaryTree<T> a,List<BinaryTree<T>> level){
        if(level.isEmpty())
            return;

        List<BinaryTree<T>> list = new ArrayList<>();
        for(BinaryTree<T> tree: level){
            if(!tree.getLeft().isEmpty()){
                list.add(tree.getLeft());
                System.out.println(tree.getLeft().getRoot());
            }
            if(!tree.getRight().isEmpty()){
                list.add(tree.getRight());
                System.out.println(tree.getRight().getRoot());
            }
        }

        //byLevel(a,list);
    }

    public <T> void byLevel (BinaryTree<T> a) {
        ArrayList<BinaryTree<T>> list = new ArrayList<>();
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
