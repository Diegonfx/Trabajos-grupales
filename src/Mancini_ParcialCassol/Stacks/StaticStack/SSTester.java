package Mancini_ParcialCassol.Stacks.StaticStack;


/**
 * Created by DiegoMancini on 25/3/17.
 */
public class SSTester {

    public static void main(String[] args) {

        Integer numero1 = 1;
        Integer numero2 = 2;
        Integer numero3 = 3;
        Integer numero4 = 4;
        Integer numero5 = 5;

        StaticStack<Integer> test = new StaticStack<Integer>(10);

        test.push(numero1);
        test.push(numero2);
        test.push(numero3);
        test.push(numero4);
        test.push(numero5);

        System.out.println("Static stack funcionality\n");

        System.out.println("Stack is empty: " + test.isEmpty());

        System.out.println("First peek: " + test.peek() + " ---> pop");
        test.pop();
        System.out.println("Second peek: " + test.peek() + " ---> pop");
        test.pop();
        System.out.println("Third peek: " + test.peek()+ " ---> pop");
        test.pop();
        System.out.println("Fourth peek: " + test.peek()+ " ---> pop");
        test.pop();
        System.out.println("Fifth peek: " + test.peek());

        System.out.println("Size of stack: " + test.size());

        System.out.println("Empty stack!");
        test.empty();

        System.out.println("Size of stack: " + test.size()) ;
        System.out.println("Stack is empty: " + test.isEmpty());

    }

}
