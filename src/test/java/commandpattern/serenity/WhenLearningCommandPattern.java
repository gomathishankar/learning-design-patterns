package commandpattern.serenity;

import CommandPattern.SerenityExample.*;
import org.junit.jupiter.api.Test;

public class WhenLearningCommandPattern {

    @Test
    public void shouldMarchForwardBasedOnCommandFromGeneral() {
        Admiral general = new Admiral("Gomathi");
        Officer ola = new Officer("ola");
        Officer shankar = new Officer("Shankar");
        general.commandsOfficers(ola, shankar);
        Order marchForward = new MarchForward();
        Order marchBackward = new MarchBackward();
        general.OrdersOfficers(marchBackward,marchForward);
    }
}
