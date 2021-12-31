package tests.designpattern.ExecuteAroundMethodPattern;

import learning.designpattern.ExecuteAroundMethodPattern.MainPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import tests.designpattern.BaseTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FramesTest extends BaseTest {

    private MainPage mainPage;

    @BeforeAll
    public void setMainPage(){
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest(){
        this.mainPage.goTo();
        this.mainPage.onFrameA(a -> a.setFirstName("Gomathi"));
        this.mainPage.onFrameB(b->b.setLastName("Shankar"));
        this.mainPage.onFrameC(c->c.setAddress("Bngalore"));
        this.mainPage.onFrameA(a->a.setMessage("Hello"));
        this.mainPage.onFrameC(c->{
            c.setFirstName("Test");
        });
    }
}
