package learning.designpattern.FactoryPattern;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static learning.designpattern.FactoryPattern.GoogleLanguageSites.*;

public class GoogleFactory {

    private static final Function<WebDriver,GooglePage> ENG = (d)-> new GoogleEnglish(d);
    private static final Function<WebDriver,GooglePage> FR = (d)-> new GoogleFrench(d);
    private static final Function<WebDriver,GooglePage> SA = (d)-> new GoogleArabic(d);

    private static final Map<GoogleLanguageSites,Function<WebDriver,GooglePage>> MAP = new HashMap<>();

    static {
        MAP.put(ENGLISH,ENG);
        MAP.put(FRENCH,FR);
        MAP.put(ARABIC,SA);
    }

    public static GooglePage get(GoogleLanguageSites languageSites, WebDriver driver){
        return MAP.get(languageSites).apply(driver);
    }

}
