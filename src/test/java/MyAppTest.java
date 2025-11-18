import org.testng.annotations.Test;

public class MyAppTest {
    @Test
    public void checkMessage(){
        MyApp myApp = new MyApp();
        myApp.printInfo();
    }
}
