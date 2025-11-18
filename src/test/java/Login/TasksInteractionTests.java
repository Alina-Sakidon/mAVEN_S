package Login;

import org.testng.annotations.Test;

public class TasksInteractionTests {
    @Test(groups = "tasksTests", dependsOnGroups = {"Authorization"})
    public void taskCreationTest(){
        System.out.println("I've created a task");
    }
}
