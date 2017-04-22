package TP_Lists;

import TP_Lists.Listas.StaticList;

/**
 * Created by Tomas on 19/4/2017.
 */
public class Metrovias {
    StaticList<Window> windowsOpen;

    public Metrovias(int numWindowsOpen){
        windowsOpen = new StaticList<>(numWindowsOpen);
    }

    public StaticList<Window> getWindowsOpen() {
        return windowsOpen;
    }

    public void simulation(){
        int i = 0;
        while(i != 57600){



            i += 10;
        }
    }
}
