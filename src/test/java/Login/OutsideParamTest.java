package Login;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OutsideParamTest {
    @Parameters({"browser", "url"})
    @Test
    public void printMessage(String browser, String url) {
        System.out.printf("Outside method finished with param %s browser and %s url%n", browser, url);
    }
}
