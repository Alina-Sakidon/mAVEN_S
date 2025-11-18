package homework18;

import api.apiRequests.PetStoreApi;
import api.entity.PetOrder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class PetOrderApiTests {
    private PetOrder petOrderToPost = new PetOrder(8, 10, 3, "2023-03-27", "placed", true);

    @Test(description = "Create order vai api. Check status and fields", priority = 1)
    public void createOrder() {
        PetStoreApi petStoreApi = new PetStoreApi();
        Response response = petStoreApi.createOrder(petOrderToPost);

        response
                .then().statusCode(200)
                .body("id", equalTo(petOrderToPost.getId()))
                .body("status", equalTo("placed"));
    }

    @Test(description = "Check get order by id", priority = 2)
    public void getOrderById() {
        PetStoreApi petStoreApi = new PetStoreApi();
        Response response = petStoreApi.getOrderById(petOrderToPost.getId());

        response
                .then().statusCode(200)
                .body("id", equalTo(petOrderToPost.getId()))
                .body("quantity", equalTo(petOrderToPost.getQuantity()));
    }
}
