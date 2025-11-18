package api.apiRequests;

import api.base.BaseApi;
import api.entity.PetOrder;
import io.restassured.response.Response;

public class PetStoreApi extends BaseApi {
    private static final String ORDER_ENDPOINT = "/order";


    public  Response createOrder(PetOrder order) {
        return requestSpecification
                .body(order)
                .when()
                .post(ORDER_ENDPOINT);
    }

    public  Response getOrderById(int id) {
        return requestSpecification
                .when()
                .get(ORDER_ENDPOINT + "/" + id);
    }
}
