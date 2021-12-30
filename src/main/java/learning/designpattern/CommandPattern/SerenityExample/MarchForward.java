package learning.designpattern.CommandPattern.SerenityExample;

public class MarchForward implements Order {

    @Override
    public void performOrderAs(Officer officer) {
            System.out.println(officer + " Marching Forward");
    }
}
