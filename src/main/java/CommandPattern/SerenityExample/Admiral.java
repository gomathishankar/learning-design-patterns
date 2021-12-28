package CommandPattern.SerenityExample;

import java.util.ArrayList;
import java.util.List;

public class Admiral {
    private List<Officer> listOfOfficers = new ArrayList<>();
    private final String name;

    public Admiral(String name){
        this.name = name;
    }

    public void commandsOfficers(Officer... officers) {
        for (Officer officer : officers) {
            listOfOfficers.add(officer);
        }
    }

    public void OrdersOfficers(Order... orders){
        for (Officer officer : this.listOfOfficers) {
            officer.OrdersSubOrdinate(orders);
        }
    }
}
