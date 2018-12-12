package orderOfService.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderItemTest {

    @Test
    public void validarSubTotal() {
        OrderItem build = OrderItem.builder()
                .quantity(4)
                .price(10D)
                .build();
        assertEquals(Double.valueOf(40), build.subTotal());
    }

}