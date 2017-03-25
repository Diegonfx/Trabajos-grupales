package TrabajoPractico3.Stacks.DynamicStack;

/**
 * Created by DiegoMancini on 25/3/17.
 */
public class DSTester {

    public static void main(String[] args) {

        Integer numero1 = 1;
        Integer numero2 = 2;
        Integer numero3 = 3;
        Integer numero4 = 4;

        DynamicStack<Integer> test = new DynamicStack<>();

        test.push(numero1);
        test.push(numero2);
        test.push(numero3);
        test.push(numero4);

        System.out.println("Dynamic stack funcionality\n");

        System.out.println("Stack is empty: " + test.isEmpty());

        System.out.println("First peek: " + test.peek() + " ---> pop");
        test.pop();
        System.out.println("Second peek: " + test.peek() + " ---> pop");
        test.pop();
        System.out.println("Third peek: " + test.peek()+ " ---> pop");
        test.pop();
        System.out.println("Fourth peek: " + test.peek()+ " ---> pop");

        System.out.println("Size of stack: " + test.size() + " ---> EMPTY") ;

        test.empty();

        System.out.println("Size of stack: " + test.size()) ;

        System.out.println("Stack is empty: " + test.isEmpty());
    }

}
