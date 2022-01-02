package tests.designpattern.BuilderPattern.Excercise2;

import learning.designpattern.BuilderPattern.Excercise2.Cat;
import org.junit.jupiter.api.Test;

public class CatBuilderTest {

    @Test
    public void catBuildTest(){
        Cat test = Cat.called("sha").offBreed("H").eatsFavouriteFood("k").andItsAge(1).build();
        System.out.println(test);
    }
}
