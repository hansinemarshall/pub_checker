import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ServerTest {

    Server server;
    Guest Hansine;
    Guest Child;
    final int DRINK = 5;//this is a constant
    final char POUND = '£';

    @BeforeEach
    public void setUp(){
        server = new Server();
        server.addToRepertoire("Martini");
        server.addToRepertoire("Pint");
        server.addToRepertoire("GnT");
        Hansine = new Guest("Hansine", 23);
        Child = new Guest("Child", 11);
    }

    // TODO: test that guest can only get served if over 18

    @Test
    void checkAge(){
        // check age
        assertThat(Hansine.getAge()).isEqualTo(23);
    }

    @Test
    void is18OrOver(){
        boolean result = Hansine.is18OrOver();
        assertThat(result).isEqualTo(true);
    }

    @Test
    void isUnder(){
        boolean result = Child.is18OrOver();
        assertThat(result).isEqualTo(false);
    }

    @Test
    void canServeGuest(){
        boolean result1 = server.canServeGuest(Hansine);
        assertThat(result1).isEqualTo(true);
        boolean result2 = server.canServeGuest(Child);
        assertThat(result2).isEqualTo(false);
    }

    // TODO: test that guest can only get served if has enough money to buy a drink (every drink is £5)

    @Test
    void canGuestBuyDrinkIfWealthy(){
        Guest customer = new Guest("Jimmy", 50);
        customer.setWallet(50);
        boolean result = customer.getWallet() > DRINK;
        assertThat(result).isEqualTo(true);
    }

    @Test
    void canGuestBuyDrinkIfPoor(){
        Guest customer = new Guest("Jimmy", 50);
        customer.setWallet(1);
        boolean result = customer.getWallet() > DRINK;
        assertThat(result).isEqualTo(false);
    }

    // TODO: test that guest can only get served if sober enough (set sobriety level on guest)

    @Test
    void canGuestBeServedIfSober(){
        Guest customer = new Guest("Jimmy", 50);
        customer.setSobriety(75);
        boolean result = customer.isSober();
        assertThat(result).isEqualTo(true);
    }

    @Test
    void canGuestBeServedIfDrunk(){
        Guest customer = new Guest("Jimmy", 50);
        customer.setSobriety(25);
        boolean result = customer.isSober();
        assertThat(result).isEqualTo(false);
    }

    // TODO: test that guest can only get served if guest is not banned from the pub

    @Test
    void canGuestBeServedIfBanned(){
        Guest customer = new Guest("Jimmy", 50);
        customer.setBannedStatus(true);
        boolean result = customer.isBanned();
        assertThat(result).isEqualTo(true);
    }

    @Test
    void canGuestBeServedIfNotBanned(){
        Guest customer = new Guest("Jimmy", 50);
        customer.setBannedStatus(false);
        boolean result = customer.isBanned();
        assertThat(result).isEqualTo(false);
    }
    // TODO: test that guest can only get served if guest can pay in local currency (add £ char as currency)


    @Test
    void canGuestBeServedInLocalCurrency(){
        Guest customer = new Guest("Jimmy", 50);
        customer.setCurrency('£');
        char result = customer.getCurrency();
        assertThat(result).isEqualTo(POUND);
    }

    @Test
    void canGuestBeServedInForeignCurrency(){
        Guest customer = new Guest("Jimmy", 50);
        customer.setCurrency('x');
        char result = customer.getCurrency();
        assertThat(result).isNotEqualTo(POUND);
    }

    // EXTENSIONS

    // TODO: test that guest can only get served if server can make favourite drink
    //  (give server a list of drinks (strings) it can make)

    @Test
    void canServerMakeKnownFavouriteDrink(){
        Guest customer = new Guest("Jimmy", 50);
        customer.setFavouriteDrink("Pint");
        String drink = customer.getFavouriteDrink();
        boolean result = server.isInDrinksRepertoire(drink);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void canServerMakeUnknownFavouriteDrink(){
        Guest customer = new Guest("Jimmy", 50);
        customer.setFavouriteDrink("Porn Star");
        String drink = customer.getFavouriteDrink();
        boolean result = server.isInDrinksRepertoire(drink);
        assertThat(result).isEqualTo(false);
    }


}
