package orderOfService.entities;

import org.junit.Test;

import java.util.List;

public class OrderTest {
    @Test
    public void testTotal(){
        List<OrderItem> list = List.of();
        System.out.println(list.stream().mapToDouble(x -> x.subTotal()).sum());
    }

}