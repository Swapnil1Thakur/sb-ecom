package com.ecommerce.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "cart_items")
@NoArgsConstructor
@AllArgsConstructor

public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;


    //Many cart items belong to one cart (ek cart ke andar multiple items)
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    // Many cart items can refer to one product (same product multiple carts me ho sakta hai)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;  // kitne quantity me product add hua hai
    private double discount;   // product par applied discount
    private double productPrice;  // price of the product at the time of adding to cart
}
