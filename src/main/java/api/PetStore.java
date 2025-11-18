package api;

import api.entity.PetOrder;
import com.google.gson.Gson;

import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PetStore {
    private static RequestBody requestBody;
    private static Request request;
    private static final OkHttpClient client = new OkHttpClient();
    private static Call call;
    private static Gson gson = new Gson();
    private static Response response;
    private static final String BASE_URL = "https://petstore.swagger.io/v2/store";

    public static Response getInventory() {
        request = new Request.Builder().get().url(BASE_URL + "/inventory")
                .build();
        call = client.newCall(request);
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Request was sent: " + request);
        System.out.println("Responce: " + response);
        return response;
    }

    public static PetOrder createPetOrder(PetOrder petOrder) {
        PetOrder actualOrder;
        String jsonObject = gson.toJson(petOrder);
        System.out.println("To post " + jsonObject);

        requestBody = RequestBody.create(jsonObject.getBytes(StandardCharsets.UTF_8));

        request = new Request.Builder().header("Content-type", "Application/json")
                .post(requestBody)
                .url(BASE_URL + "/order")
                .build();
        call = client.newCall(request);
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            String responseBodyString = response.body().string();
            actualOrder = gson.fromJson(responseBodyString, PetOrder.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return actualOrder;
    }

    public static PetOrder getOrderById(int orderId) {
        PetOrder actualOrder;
        request = new Request.Builder().url(BASE_URL + "/order/" + orderId).get().build();
        call = client.newCall(request);
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            String responseBodyString = response.body().string();
            actualOrder = gson.fromJson(responseBodyString, PetOrder.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return actualOrder;
    }

    public static int deleteOrderById(int orderId) {
        request = new Request.Builder().delete().url(BASE_URL + "/order/" + orderId).build();
        call = client.newCall(request);
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response.code();
    }
}
