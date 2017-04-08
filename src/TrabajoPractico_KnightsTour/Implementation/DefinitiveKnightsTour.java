package TrabajoPractico_KnightsTour.Implementation;

import TrabajoPractico1.Sort.Sort;
import TrabajoPractico3.Stacks.DynamicStack.DynamicStack;

import java.util.ArrayList;
import java.util.List;

/**
 * It represents the knight's tour theory with its first possible jumps
 * @author Tomas Iturralde
 * @author Diego Mancini
 */
public class DefinitiveKnightsTour {

    /**
     * MOVES_ALLOWED_IN_BOARD is an array of possible spots that you can go to, from an initial spot.
     * SIZE is the amount of spots in an ROW x COLUMN way
     * board represents the board
     * currentSpot is the initial spot of the board at row 0 and column 0
     * listOfStacksWithMovements is a list that contains all the potential stacks needed to complete an n based knight's tour
     * spotsToIterate is a list that contains all the possible moves the knight can make from an initial position
     * initialStack, firstStack, secondStack, thirdStack and fourthStack represent the number of jumps, with initialStack only containing the first spot
     */
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

    /**
     * It checks if the spot's row and column value are between 0 and SIZE, and if that position was already used (it can't go throught it again in the same path)
     * @param anySpot is the initial spot
     * @param board the board we are trying to put the 'anySpot'
     * @return true if that spot can be placed in the board
     */
    private boolean moveIsAllowed(Spot anySpot, Spot[][] board) {
        if (anySpot.getPositionInRow() >= 0 && anySpot.getPositionInRow() < SIZE) {
            if (anySpot.getPositionInColumn() >= 0 && anySpot.getPositionInColumn() < SIZE) {
                if (!board[anySpot.getPositionInRow()][anySpot.getPositionInColumn()].wasUsed()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * It gets the current position's row and column value, and tries all the possible combinations with MOVES_ALLOWED_IN_BOARD, and checks
     * if that move is possible within the defined parameters.
     * @param movement the number of the jump, it represents in which stack it will be stored
     * @return a Dynamic stack with the spots it can go to from the current position.
     */
    private DynamicStack<Spot> getNextStackOfMoves(int movement) {
        DynamicStack<Spot> nextStack = new DynamicStack<>();
        int nextSpotsRow, nextSpotsColumn;
        Spot nextSpotInStack;
        for (int possibleSpot = 0; possibleSpot < SIZE; possibleSpot++) {
            nextSpotsRow = currentSpot.getPositionInRow() + MOVES_ALLOWED_IN_BOARD[possibleSpot].getPositionInRow();
            nextSpotsColumn = currentSpot.getPositionInColumn() + MOVES_ALLOWED_IN_BOARD[possibleSpot].getPositionInColumn();
            nextSpotInStack = new Spot(nextSpotsRow, nextSpotsColumn);
            if (moveIsAllowed(nextSpotInStack, board)) {
                nextSpotInStack.setWasUsed(true);
                nextSpotInStack.setValue(movement);
                board[nextSpotsRow][nextSpotsColumn] = nextSpotInStack;
                spotsToIterate.add(nextSpotInStack);
                nextStack.push(nextSpotInStack);
            }
        }
        return nextStack;
    }

    /**
     * This method gathers information from the spotsToIterate list, and the current position. With that information, it specifies
     * which position will be used by the currentSpot Spot. It then shows the information stored in the currentSpot,
     * and the loop through the stacks defined by the value stored in that spot. It then stores that position in an auxiliary list
     * that serves the purpose of checking which spot should be considered from the previous stack, as to define the next possible moves (FUNCTIONALITY DEBT)
     * It then removes that spot from the original list, and defines the next position as the currentSpot.
     */
    public void next() {
        List<Spot> wentThrough = new ArrayList<>();
        int i = 0;
        currentSpot = spotsToIterate.get(i);
        if (currentSpot.getValue() == 0) {
            System.out.println("Stack 0 --> VALUE: " + currentSpot.getValue() + " ||  SPOT: " + currentSpot.getName());
        } if (currentSpot.getValue() == 1 ) {
            System.out.println("Stack 1 --> VALUE: " + currentSpot.getValue() + " ||  SPOT: " + currentSpot.getName());
        } if (currentSpot.getValue() == 2) {
            System.out.println("Stack2 --> VALUE: " + currentSpot.getValue() + " ||  SPOT: " + currentSpot.getName()) ;
        } if (currentSpot.getValue() == 3) {
            System.out.println("Stack 3 --> VALUE: " + currentSpot.getValue() + " ||  SPOT: " + currentSpot.getName());
        } if (currentSpot.getValue() == 4) {
            System.out.println("Stack 4 --> VALUE: " + currentSpot.getValue() + " ||  SPOT: " + currentSpot.getName());
        }
        if (spotsToIterate.get(i+1) == null) {
            System.out.println("ENDGAME");
        }
        if (currentSpot.getValue() == 0 && spotsToIterate.get(i+1).getValue() == 1 ) {
            System.out.println("Salgo de stack 0");
        } else if (currentSpot.getValue() == 1 && spotsToIterate.get(i+1).getValue() == 2) {
            System.out.println("Salgo de stack 1");
        } else if (currentSpot.getValue() == 2 && spotsToIterate.get(i+1).getValue() == 3) {
            System.out.println("Salgo de stack 2");
        } else if (currentSpot.getValue() == 3 && spotsToIterate.get(i+1).getValue() == 4) {
            System.out.println("Salgo de stack 3");
        } else if (currentSpot.getValue() == 4 && spotsToIterate.get(i+1).getValue() < 4) {
            System.out.println("Salgo de stack 4");
            for (int j = 0 ; j < wentThrough.size() ; j++) {
                if (wentThrough.get(j).getValue() < 4) {
                    System.out.println("Stack 3 --> VALUE: " + wentThrough.get(j).getValue() + " ||  SPOT: " + wentThrough.get(j).getName());
                    wentThrough.remove(j);
                    break;
                }
            }
        } else if (currentSpot.getValue() == 1 && spotsToIterate.get(i+1).getValue() == 0) {
            System.out.println("Salgo de stack 1 y entro en stack 0");
            for (int j = wentThrough.size() ; j > 0 ; j--) {
                if (wentThrough.get(j).getValue() == 0) {
                    System.out.println("Stack 0 --> VALUE: " + wentThrough.get(j).getValue() + " ||  SPOT: " + wentThrough.get(j).getName());
                    wentThrough.remove(j);
                    break;
                }
            }
        } else if (currentSpot.getValue() == 2 && spotsToIterate.get(i+1).getValue() == 1) {
            System.out.println("Salgo de stack 2 y entro en stack 1");
            for (int j = wentThrough.size() ; j > 0 ; j--) {
                if (wentThrough.get(j).getValue() == 1) {
                    System.out.println("Stack 1 --> VALUE: " + wentThrough.get(j).getValue() + " ||  SPOT: " + wentThrough.get(j).getName());
                    wentThrough.remove(j);
                    break;
                }
            }
        } else if (currentSpot.getValue() == 3 && spotsToIterate.get(i+1).getValue() == 2) {
            System.out.println("Salgo de stack 3 y entro en stack 2");
            for (int j = wentThrough.size() ; j > 0 ; j--) {
                if (wentThrough.get(j).getValue() == 2) {
                    System.out.println("Stack 2--> VALUE: " + wentThrough.get(j).getValue() + " ||  SPOT: " + wentThrough.get(j).getName());
                    wentThrough.remove(j);
                    break;
                }
            }
        } else if (currentSpot.getValue() == 4 && spotsToIterate.get(i+1).getValue() == 3) {
            System.out.println("Salgo de stack 4 y entro en stack 3");
            for (int j = 0 ; j < wentThrough.size() ; j++) {
                if (wentThrough.get(j).getValue() == 3) {
                    System.out.println("Stack 3 --> VALUE: " + wentThrough.get(j).getValue() + " ||  SPOT: " + wentThrough.get(j).getName());
                    wentThrough.remove(j);
                    break;
                }
            }
        }
        wentThrough.add(spotsToIterate.get(i));
        spotsToIterate.remove(i);
        currentSpot = spotsToIterate.get(i);
    }

    /**
     * This method's purpose is to go through all the possible moves the knight can make from the initial spot, and fill the list 'spotsToIterate' with these spots.
     * This will be accomplishd with the use of the method 'getNextStackOfMoves(assigning which stack it is with the index number)'
     * Whenever the new stack is filled, the currentSpot is defined as the top (stack.peek) of that stack. Whenever the stack n+1 is empty by the continious popping,
     * the stack n is popped and the currentSpot is assigned to its new peek. It will then get that currentSpot's new possible moves. The process will go on by checking
     * which paths have already been used by the boolean status of the Spot, which determine its usability.
     * It uses the private methods xStackOp(for operation) which determines if that stack is empty or not, and regarding that it will assign the new value of currentSpot.
     * @throws NullPointerException when the last stack, 'initialStack' has been emptied and therefore no more spots to analyze.
     */
    public void fillArrayList() throws NullPointerException {
        try {
            initialStack.push(currentSpot);
            currentSpot = initialStack.peek();
            while (!initialStack.isEmpty()) {
                currentSpot = initialStack.peek();
                firstStack = getNextStackOfMoves(1);
                while (!firstStack.isEmpty()) {
                    currentSpot = firstStack.peek();
                    secondStack = getNextStackOfMoves(2);
                    while (!secondStack.isEmpty()) {
                        currentSpot = secondStack.peek();
                        thirdStack = getNextStackOfMoves(3);
                        while (!thirdStack.isEmpty()) {
                            currentSpot = thirdStack.peek();
                            fourthStack = getNextStackOfMoves(4);
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
            System.out.println("FINISHED");
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
    public List<Spot> getSpotsToIterate() {
        return spotsToIterate;
    }
    public Spot getCurrentSpot() {
        return currentSpot;
    }
}
