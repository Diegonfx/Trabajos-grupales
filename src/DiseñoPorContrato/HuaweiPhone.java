package DiseñoPorContrato;

import java.util.ArrayList;

//Simplifications:
    /*@        ; @*/
    //@   ;

/**
 * Created by DiegoMancini on 10/3/17.
 * This class is a prototype for a mobile phone sold by Huawei.
 * It's utility is to have apps(represented as Strings) and storage to manage.
 */
public class HuaweiPhone {

    private String name;
    private int yearModel;
    private ArrayList<String> appsInstalled;
    final static double MAX_STORAGE_SIZE = 1024;
    private boolean isUnlocked;
    final static double HEIGHT = 10;
    final static double WIDTH = 4.5;
    private double currentStorage = 1024;

    /*@
    invariant ( \forall (int i = 0 ; i < appsInstalled.size() ; i++) ;
    appsInstalled.get(i).charAt(i) < appsInstalled.get(i+1).charAt(i)) ) ;
     @*/

    /**
     * @param name refers to the mobilephone's name
     * @param yearModel refers to the year the phone was made available to the market
     */

    public HuaweiPhone(String name, int yearModel) {
        this.name = name;
        this.yearModel = yearModel;
        appsInstalled = new ArrayList<>();
        isUnlocked = false;
    }

    public /*@ pure @*/ String getName() {
        return name;
    }

    public /*@ pure @*/ int getYearModel() {
        return yearModel;
    }

    /*@  ensures \result != null @*/
    public /*@ pure @*/ ArrayList<String> getAppsInstalled() {
        return appsInstalled;
    }

    /*@  requires appsInstalled.size() >= index ; @*/
    public /*@ non_null @*/ String getStringAtExactPositionOfAppsInstalled(int index) {
        return appsInstalled.get(index);
    }

    public /*@ pure @*/ boolean isUnlocked() {

        return isUnlocked;
    }

    public static /*@ pure @*/ double getMaxStorageSize() {
        return MAX_STORAGE_SIZE;
    }

    public static /*@ pure @*/ double getHEIGHT() {
        return HEIGHT;
    }

    public static /*@ pure @*/ double getWIDTH() {
        return WIDTH;
    }

    /*@ ensures \old(name) != name;   @*/
    public void setName(/*@  non_null @*/ String name) {
        this.name = name;
    }

    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }

    public void setAppsInstalled(/*@  non_null @*/ ArrayList<String> appsInstalled) {
        this.appsInstalled = appsInstalled;
    }

    //@assignable isUnlocked;
    public void setUnlocked(boolean unlocked) {
        isUnlocked = unlocked;
    }

    /*@ signals (PhoneAlreadyLocked e) isUnlocked == false; @*/
    public void goLocked() throws PhoneAlreadyLocked  {
        if (isUnlocked == true) {
            setUnlocked(false);
        } else {
            throw new PhoneAlreadyLocked();
        }
    }

    /*@ signals (PhoneAlreadyUnlocked e) isUnlocked == true; @*/
    public void goUnLocked() throws PhoneAlreadyUnlocked{
        if (isUnlocked == false) {
            setUnlocked(true);
        } else {
            throw new PhoneAlreadyUnlocked();
        }
    }

    /*@ requires appsInstalled.size() >= position && appsInstalled.get(position) == null ; @*/
    public void addAppToInstalledAppsList( /*@ non_null @*/ String appName, int position) {
        appsInstalled.add(position , appName);
    }

}
