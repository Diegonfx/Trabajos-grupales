package Mancini_ParcialCassol;


import Mancini_ParcialCassol.Listas.DynamicList;
import Mancini_ParcialCassol.Listas.List;
import Mancini_ParcialCassol.Listas.StaticList;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Diego Mancini
 */
public class ThemePark {

    private List<Attraction> attractionsList;
    private int currentTime;
    private int regularTickets;
    private int fastPass;
    private List<Client> hub;
    private int amountOfClients = 1;
    private int amountOfClientsLeft = 0;
    private List<Client> clientsInADay;
    private List<Ticket> tickets;
    private List<Client> clientsLeft;

    public ThemePark() {
        this.attractionsList = new StaticList<>(8);
        attractionsList.insertNext(new Attraction("Chipmunk Treasure" , 8));
        attractionsList.insertNext(new Attraction("Munchkin Island" , 4));
        attractionsList.insertNext(new Attraction("Dinosaur Land" , 6));
        attractionsList.insertNext(new Attraction("Go Go Karts" , 6));
        attractionsList.insertNext(new Attraction("Rock n Roller" , 15));
        attractionsList.insertNext(new Attraction("Princess Castle" , 9));
        attractionsList.insertNext(new Attraction("Splash Mountain" , 12));
        attractionsList.insertNext(new Attraction("Space Xtreme" , 12));
        currentTime = 0;
        regularTickets = 0;
        fastPass = 0;
        hub = new DynamicList<>();
        clientsInADay = new DynamicList<>();
        tickets = new StaticList<>(2);
        tickets.insertNext(new RegularTicket());
        tickets.insertNext(new FastPassTicket());
        clientsLeft = new DynamicList<>();
        clientsEnter();
    }

    public Attraction getMostPopularAttraction() {
        attractionsList.goTo(0);
        return attractionsList.getActual();
    }

    /**
     * Performs the action where the clients enter the park and go to the hub.
     */
    public void clientsEnter() {
        for (int i = 0 ; i < 5 ; i++) {
            Client anyClient = new Client("Client: " + amountOfClients++);
            hub.insertNext(anyClient);
            clientsInADay.insertNext(anyClient);
        }
    }

    /**
     * Performs the action where the clients leave the park from the hub.
     */
    public void clientLeavesPark() {
            hub.goTo(0);
            clientsLeft.insertNext(hub.getActual());
            amountOfClientsLeft--;
            hub.remove();
    }

    /**
     * Performs the action where it defines by probability what the client will do next.
     */
    public void clientTakesAction() {
        for (int i = 0; i < hub.size(); i++) {
            hub.goTo(i);
            int random = ThreadLocalRandom.current().nextInt(0, 10);
            if (random <= 6) {
                clientGoesToAttraction(hub.getActual());
            }
            if (random > 6 && random <= 8) {
                clientLeavesPark();
            }
        }
    }

    /**
     * Performs the action where user defines the amount of attractions to open.
     */
    public void openAttractions(int num) {
        for (int i = 0 ; i < num ; i++) {
            int random = ThreadLocalRandom.current().nextInt(0 , 8);
            this.getAttractionsList().goTo(random);
            this.getAttractionsList().remove();
        }
    }

    /**
     * Performs the action where the client goes from the hub to the attraction, and depending on the ticket it holds, defines the queue.
     */
    public void clientGoesToAttraction(Client anyClient) {
        attractionsList.goTo(0);
        if (anyClient.getTicket().isFastPass() && anyClient.getTicket().getFastPassUses() > 0) {
            attractionsList.getActual().getFastPassLane().enqueue(anyClient);
            anyClient.getTicket().removeUse();
            anyClient.setTimeInRegularQueue(currentTime);
            hub.remove();
        } else {
            attractionsList.getActual().getRegularLane().enqueue(anyClient);
            anyClient.setTimeInRegularQueue(currentTime);
            hub.remove();
        }
    }

    /**
     * Performs the action where the park is emptied, from everywhere. All attractions are emptied and the hub as well.
     */
    public void emptyPark() {
        for (int i = 0 ; i < attractionsList.size() ; i++) {
            attractionsList.goTo(i);
            for (int j = 0 ; j < attractionsList.getActual().getClientsUsingAttraction().size() ; j++) {
                clientsLeft.insertNext(attractionsList.getActual().getClientsUsingAttraction().peek());
                attractionsList.getActual().getClientsUsingAttraction().pop();
                amountOfClientsLeft++;
            }
            for (int j = 0 ; j < attractionsList.getActual().getRegularLane().getSize() ; j++) {
                clientsLeft.insertNext(attractionsList.getActual().getRegularLane().dequeue());
                amountOfClientsLeft++;
            }
            for (int j = 0 ; j < attractionsList.getActual().getClientsUsingAttraction().size() ; j++) {
                clientsLeft.insertNext(attractionsList.getActual().getFastPassLane().dequeue());
                amountOfClientsLeft++;
            }
        }
        for (int j = 0 ; j < hub.size() ; j++) {
            hub.goTo(j);
            clientsLeft.insertNext(hub.getActual());
            amountOfClientsLeft++;
            hub.remove();
        }
    }

    //              GETTERS AND SETTERS
    public List<Attraction> getAttractionsList() {
        return attractionsList;
    }
    public int getCurrentTime() {
        return currentTime;
    }
    public void addCurrent(int i) { currentTime += i;}
    public int getRegularTickets() {
        for (int i = 0 ; i < clientsInADay.size() ; i++) {
            clientsInADay.goTo(i);
            if (!clientsInADay.getActual().getTicket().isFastPass()) {
                regularTickets++;
            }
        }
        return regularTickets;
    }
    public int getFastPass() {
        for (int i = 0 ; i < clientsInADay.size() ; i++) {
            clientsInADay.goTo(i);
            if (clientsInADay.getActual().getTicket().isFastPass()) {
                fastPass++;
            }
        }
        return fastPass;
    }
    public int moneyFromRegularTickets() {
        tickets.goTo(0);
        return getRegularTickets() * tickets.getActual().getPrice();
    }
    public int moneyFromFastPassTickets() {
        tickets.goTo(1);
        return getFastPass() * tickets.getActual().getPrice();
    }
    public List<Client> hub() {
        return hub;
    }
    public int getAmountOfClients() {
        return amountOfClients;
    }
    public List<Client> getClientsInADay() {
        return clientsInADay;
    }
    public List<Ticket> getTickets() {
        return tickets;
    }
    public List<Client> getClientsLeft() {
        return clientsLeft;
    }
    public int getAmountOfClientsLeft() {
        return amountOfClientsLeft;
    }

}
