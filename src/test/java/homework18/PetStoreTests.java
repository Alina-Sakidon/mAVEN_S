package homework18;

import api.PetStore;
import api.entity.PetOrder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static api.PetStore.*;

public class PetStoreTests {

    @Test(description = "Check inventory link with successfull status")
    public void checkInventory() {
        Assert.assertEquals(PetStore.getInventory().code(), 200);
    }

    @Test(description =  "Check pet order creation")
    public void checkOrder(){
        int orderId = 8;
        PetOrder expectedOrder, actualOrderViaPost, actualOrderViaGetById;
        expectedOrder = new PetOrder(orderId, 3, 10, LocalDateTime.now().toString(),"placed",true);
        actualOrderViaPost = createPetOrder(expectedOrder);
        Assert.assertEquals(expectedOrder.getPetId(), actualOrderViaPost.getPetId());
        actualOrderViaGetById = getOrderById(orderId);
        Assert.assertEquals(actualOrderViaPost.getId(), actualOrderViaGetById.getId());
        Assert.assertEquals(200, deleteOrderById(orderId));

    }
}
