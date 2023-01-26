public class Guest {

    // data members
    private String name;
    private int age;

    private int wallet;

    private int sobriety;

    private boolean isBanned;
    private char currency;
    private String favouriteDrink;



    // constant values
    final int MAX_SOBRIETY = 100; // this is an enforced max value in a Guest instance
    final int SOBRIETY_THRESHOLD = 49; // up to and including SOBRIETY_THRESHOLD means "too drunk"

    final boolean BANNED = true;
    final boolean NOT_BANNED = false;
    final char POUND = '£';


    public Guest(String name, int age){
        this.name = name;
        this.age = age;
        this.wallet = 0; // default value is "no money"
        this.sobriety = 100; // default sobriety is "completely sober"
        this.isBanned = false; // default is "not banned"
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
        return;
    }

    public boolean is18OrOver(){
        if( this.age >= 18){
            return true;
        } else {
            return false;
        }
    }
    public int getWallet(){
        return this.wallet;
    }

    public void setWallet(int money){
        this.wallet = money;
        return;
    }

//    public int getSobriety() {
//        return sobriety;
//    }

    public void setSobriety(int sobriety) {
        if(sobriety > MAX_SOBRIETY){
            sobriety = MAX_SOBRIETY;
        }
        this.sobriety = sobriety;
    }

    public boolean isSober(){
        if(sobriety > SOBRIETY_THRESHOLD){
            return true;
        } else {
            return false;
        }
    }

    public void setBannedStatus(boolean status){
        this.isBanned = status;
    }

    public boolean isBanned(){
        return this.isBanned;
//        if(this.isBanned == BANNED){
//            return true;
//        } else {
//            return false;
//        }
    }

    public char getCurrency() {
        return currency;
    }

    public void setCurrency(char currency) {
        this.currency = currency;
    }

    public String getFavouriteDrink(){
        return this.favouriteDrink;
    }

    public void setFavouriteDrink(String drink){
        this.favouriteDrink = drink;
    }
}
