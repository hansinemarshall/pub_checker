import java.util.ArrayList;

public class Server {

    private Guest guest;
    private ArrayList<String> drinksRepertoire;



    Server(){
        this.drinksRepertoire = new ArrayList<>();
    }

    public void addToRepertoire(String drink){
        this.drinksRepertoire.add(drink);
    }

    public boolean isInDrinksRepertoire(String drink){
        if(this.drinksRepertoire.contains(drink)){
            return true;
        } else {
            return false;
        }
    }


    public boolean canServeGuest(Guest guest){
        if(guest.is18OrOver()){
            return true;
        } else {
            return false;
        }
    }
}
