package learning.designpattern.CommandPattern.SerenityExample;

public class MarchBackward implements Order {

    @Override
    public void performOrderAs(Officer officer) {
            System.out.println(officer + " Marching Backward");
    }
}
