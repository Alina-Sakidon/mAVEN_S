package Login;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    @Test(dataProvider = "data", description = "Login test with valid data", groups = "Authorization")
    public void loginWithValidData(String name, String password, String role) {
        System.out.printf("Login with valid data: name %s, pass: %s, role %s%n", name, password, role);
    }

    @DataProvider(name = "data")
    public Object[][] generateData() {
        return new Object[][]{
                {"Alina", "alinas1548", "admin"},
                {"Slav", "SSS456", "USER"},
                {"IrA", "IW58", "admin"},
                //{"testData1","dsds" ,NullPointerException.class},
        };
    }
}
