package tests.designpattern.BuilderPattern.Excercise1;

import learning.designpattern.BuilderPattern.Excercise1.Dog;
import org.junit.jupiter.api.Test;

public class DogBuilderTest {

    @Test
    public void testDog(){
        Dog fido = Dog.called("Fido").eatsFavouriteFood("fish").ofBreed("bull dog").andItsAge(5).build();
        System.out.println(fido);
    }
}
