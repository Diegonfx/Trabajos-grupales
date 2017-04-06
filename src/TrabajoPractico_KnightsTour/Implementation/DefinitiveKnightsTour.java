package TrabajoPractico_KnightsTour.Implementation;

import TrabajoPractico1.Sort.Sort;
import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DiegoMancini on 31/3/17.
 */
public class DefinitiveKnightsTour {


    private final static Spot[] MOVES_ALLOWED_IN_BOARD = {new Spot(2, 1), new Spot(1, 2), new Spot(-1, 2), new Spot(-2, 1),
            new Spot(-2, -1), new Spot(-1, -2), new Spot(1, -2), new Spot(2, -1)};
    private final static int SIZE = 8;
    private Spot[][] board = new Spot[SIZE][SIZE];
    private List<DynamicStack<Spot>> listOfStacksWithMovements;
    private Spot currentSpot = new Spot(0, 0);
    private DynamicStack<Spot> initialStack = new DynamicStack<>();
    private DynamicStack<Spot> firstStack = new DynamicStack<>();
    private DynamicStack<Spot> secondStack = new DynamicStack<>();
    private DynamicStack<Spot> thirdStack = new DynamicStack<>();
    private DynamicStack<Spot> fourthStack = new DynamicStack<>();
    private List<Spot> spotsToIterate;
    private int moves = 0;

    public DefinitiveKnightsTour() {
        for (int j = 0; j < SIZE; j++) {
            for (int k = 0; k < SIZE; k++) {
                board[j][k] = new Spot(j, k);
                board[j][k].setValue(board[j][k].getValue());
            }
        }
        spotsToIterate = new ArrayList<>();
        currentSpot.setValue(0);
        currentSpot.setWasUsed(true);
        board[0][0] = currentSpot;
        listOfStacksWithMovements = new ArrayList<>();
        spotsToIterate.add(currentSpot);
        listOfStacksWithMovements.add(initialStack);
        listOfStacksWithMovements.add(firstStack);
        listOfStacksWithMovements.add(secondStack);
        listOfStacksWithMovements.add(thirdStack);
        listOfStacksWithMovements.add(fourthStack);
    }

    public boolean moveIsAllowed(Spot anySpot, Spot[][] board) {
        if (anySpot.getPositionInRow() >= 0 && anySpot.getPositionInRow() < SIZE) {
            if (anySpot.getPositionInColumn() >= 0 && anySpot.getPositionInColumn() < SIZE) {
                if (!board[anySpot.getPositionInRow()][anySpot.getPositionInColumn()].wasUsed()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasMoves(Spot anySpot) {
        for (int possibleSpot = 0; possibleSpot < SIZE; possibleSpot++) {
            int nextSpotsRow = anySpot.getPositionInRow() + MOVES_ALLOWED_IN_BOARD[possibleSpot].getPositionInRow();
            int nextSpotsColumn = currentSpot.getPositionInColumn() + MOVES_ALLOWED_IN_BOARD[possibleSpot].getPositionInColumn();
            anySpot = new Spot(nextSpotsRow, nextSpotsColumn);
            if (moveIsAllowed(anySpot, board) && !anySpot.wasUsed()) {
                return true;
            }
        }
        return false;
    }

    private DynamicStack<Spot> getNextStackOfMoves() {
        DynamicStack<Spot> nextStack = new DynamicStack<>();
        int nextSpotsRow, nextSpotsColumn;
        Spot nextSpotInStack;
        for (int possibleSpot = 0; possibleSpot < SIZE; possibleSpot++) {
            nextSpotsRow = currentSpot.getPositionInRow() + MOVES_ALLOWED_IN_BOARD[possibleSpot].getPositionInRow();
            nextSpotsColumn = currentSpot.getPositionInColumn() + MOVES_ALLOWED_IN_BOARD[possibleSpot].getPositionInColumn();
            nextSpotInStack = new Spot(nextSpotsRow, nextSpotsColumn);
            if (moveIsAllowed(nextSpotInStack, board) && !nextSpotInStack.wasUsed()) {
                nextSpotInStack.setWasUsed(true);
                nextSpotInStack.setValue(++moves);
                board[nextSpotsRow][nextSpotsColumn] = nextSpotInStack;
                spotsToIterate.add(nextSpotInStack);
                nextStack.push(nextSpotInStack);
//                System.out.println(" || Value of spot: " + nextSpotInStack.getValue() + " || Name of spot in board: " + nextSpotInStack.getName());
            }
        }
        return nextStack;
    }

    public Spot next() {
        currentSpot = spotsToIterate.get(0);
        System.out.println("VALUE: " + currentSpot.getValue() + " ||  SPOT: " + currentSpot.getName() + " ||  ROW: " + currentSpot.getPositionInRow() + " ||  COLUMN: " + currentSpot.getPositionInColumn());
        spotsToIterate.remove(0);
        return currentSpot;
    }

    public void fillArrayList() throws NullPointerException {
        try {
            initialStack.push(currentSpot);
            currentSpot = initialStack.peek();
            while (!initialStack.isEmpty()) {
                currentSpot = initialStack.peek();
                firstStack = getNextStackOfMoves();
                while (!firstStack.isEmpty()) {
                    currentSpot = firstStack.peek();
                    secondStack = getNextStackOfMoves();
                    while (!secondStack.isEmpty()) {
                        currentSpot = secondStack.peek();
                        thirdStack = getNextStackOfMoves();
                        while (!thirdStack.isEmpty()) {
                            currentSpot = thirdStack.peek();
                            fourthStack = getNextStackOfMoves();
                            while (!fourthStack.isEmpty()) {
                                fourthStack.peek().setWasUsed(false);
                                fourthStack.pop();
                            }
                            thirdStackOp();
                        }
                        secondStackOp();
                    }
                    firstStackOp();
                }
                initialStackOp();
            }
        }catch (NullPointerException e) {
            System.out.println("COMPLETE");
        }
    }
    private void initialStackOp() {
        initialStack.pop();
        currentSpot = null;
        if (initialStack.isEmpty()) {
//            System.out.println("\nINITIAL STACK HAS NO MORE REMAINING MOVES");
        }
    }
    private void firstStackOp() {
        firstStack.peek().setWasUsed(false);
        firstStack.pop();
        if (!firstStack.isEmpty()) {
            currentSpot = firstStack.peek();
        }
        else {
//            System.out.println("\nFIRST STACK HAS NO MORE REMAINING MOVES");currentSpot = initialStack.peek();
        }
    }
    private void secondStackOp() {
        secondStack.peek().setWasUsed(false);
        secondStack.pop();
        if (!secondStack.isEmpty()) {
            currentSpot = secondStack.peek();
        }
        else {
//            System.out.println("\nSECOND STACK HAS NO MORE REMAINING MOVES");currentSpot = firstStack.peek();
        }
    }
    private void thirdStackOp() {
//        System.out.println("\nFOURTH STACK HAS NO MORE REMAINING MOVES");
        thirdStack.peek().setWasUsed(false);
        thirdStack.pop();
        if (!thirdStack.isEmpty()) {
            currentSpot = thirdStack.peek();
        }
        else {
//            System.out.println("\nTHIRD STACK HAS NO MORE REMAINING MOVES");currentSpot = secondStack.peek();
        }
    }
    public void printBoard() {
        for (int positionInRow = 0 ; positionInRow < SIZE ; positionInRow++) {
            for (int positionInColumn = 0 ; positionInColumn < SIZE; positionInColumn++) {
                System.out.print(board[positionInRow][positionInColumn].getValue() + " || ");
            }
            System.out.println();
        }
    }
    public List<Spot> getSpotsToIterate() {
        return spotsToIterate;
    }

    public Spot previous(Spot anySpot) {
        Spot previous = new Spot();
        for (int i = 0 ; i < spotsToIterate.size() ; i++) {
            if (spotsToIterate.get(i).equals(anySpot)) {
                previous = spotsToIterate.get(i-1);
            }
        } return previous;
    }

//    public void getMovements() throws NullPointerException {
//        try {
////            printBoard();
//            initialStack.push(currentSpot);
//            currentSpot = initialStack.peek();
//            while (!initialStack.isEmpty()) {
//                currentSpot = initialStack.peek();
////                System.out.println("Entro en stack 0 --> Movimiento: " + initialStack.peek().getName() + " --> Value: " + initialStack.peek().getValue() + " --> Status: " + initialStack.peek().wasUsed());
//                firstStack = getNextStackOfMoves();
////                printBoard();
//                while (!firstStack.isEmpty()) {
//                    currentSpot = firstStack.peek();
////                    System.out.println("Entro en stack 1 --> Movimiento: " + firstStack.peek().getName() + " --> Value: " + firstStack.peek().getValue() + " --> Status: " + firstStack.peek().wasUsed());
//                    secondStack = getNextStackOfMoves();
////                    printBoard();
//                    while (!secondStack.isEmpty()) {
//                        currentSpot = secondStack.peek();
////                        System.out.println("Entro en stack2 --> Movimiento:" + secondStack.peek().getName() + " --> Value: " + secondStack.peek().getValue() + " --> Status: " + firstStack.peek().wasUsed());
//                        thirdStack = getNextStackOfMoves();
////                        printBoard();
//                        while (!thirdStack.isEmpty()) {
//                            currentSpot = thirdStack.peek();
//                            fourthStack = getNextStackOfMoves();
////                            printBoard();
//                            while (!fourthStack.isEmpty()) {
////                                System.out.println("Entro en stack 3 --> Movimiento:" + thirdStack.peek().getName() + " --> Value: " + thirdStack.peek().getValue() + " -->Status: " + firstStack.peek().wasUsed());
////                                System.out.println("Movimientos posibles guardado en stack 4 --> Movimiento:  " + fourthStack.peek().getName() + " --> Value: " + fourthStack.peek().getValue() + " --> Status: " + firstStack.peek().wasUsed());
//                                fourthStack.peek().setWasUsed(false);
//                                fourthStack.pop();
////                                printBoard();
//                            }
//                            thirdStackOp();
////                            printBoard();
//                        }
//                        secondStackOp();
////                        printBoard();
//                    }
//                    firstStackOp();
////                    printBoard();
//                }
//                initialStackOp();
////                printBoard();
//            }
//        }catch (NullPointerException e) {
//            System.out.println("COMPLETE");
//        }
//    }


}
