package CommandPattern.SerenityExample;

public class Officer {
    private String name;

    public Officer(String name){
        this.name = name;
    }

    public void OrdersSubOrdinate(Order... orders) {
        for(Order order : orders){
            order.performOrderAs(this);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
