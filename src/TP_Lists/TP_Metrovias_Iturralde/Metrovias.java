package TP_Lists.TP_Metrovias_Iturralde;

import TP_Lists.Listas.StaticList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Tomas on 19/4/2017.
 */
public class Metrovias {
    StaticList<Window> windowsOpen;

    public Metrovias(int numWindowsOpen){
        windowsOpen = new StaticList<>(numWindowsOpen);
        for (int i = 0; i < numWindowsOpen; i++) {
            Window newWindow = new Window();
            windowsOpen.insertNext(newWindow);
        }
    }

    public StaticList<Window> getWindowsOpen() {
        return windowsOpen;
    }

    public void simulation(){
        for (int i = 0; i < 57570; i += 10){
            StaticList<Client> clients = createCustomers(i);
            accommodateCustomers(clients);
            for (int j = 0; j < windowsOpen.size(); j++) {
                windowsOpen.goTo(j);
                windowsOpen.getActual().serveCustomers(i);
            }
        }
        for (int i = 0; i < 30; i+= 10) {
            StaticList<Client> clients = createCustomers(i);
            accommodateCustomers(clients);
            for (int j = 0; j < windowsOpen.size(); j++) {
                windowsOpen.goTo(j);
                windowsOpen.getActual().serveCustomersAtEnd(i);
            }
        }
    }

    private StaticList<Client> createCustomers(int initialTime){
        StaticList<Client> newClients = new StaticList<>(5);
        for (int i = 0; i < newClients.size(); i++) {
            Client newClient = new Client(initialTime);
            newClients.insertNext(newClient);
        }
        return newClients;
    }

    private void accommodateCustomers(StaticList<Client> clients){
        for (int i = 0; i < clients.size(); i++) {
            clients.goTo(i);
            int randomWindow = ThreadLocalRandom.current().nextInt(0, windowsOpen.size() + 1);
            windowsOpen.goTo(randomWindow);
            windowsOpen.getActual().getLine().enqueue(clients.getActual());
        }
    }
}
