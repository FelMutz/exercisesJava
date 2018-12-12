package orderOfService.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private Integer quantity;
    private Double price;
    private Product product;

    public Double subTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format(product.getName() + ", $" + price + " Quantity: " + quantity + ", Subtotal: $" + subTotal());
    }
}
