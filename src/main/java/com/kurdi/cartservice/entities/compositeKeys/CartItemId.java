package com.kurdi.cartservice.entities.compositeKeys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;


public final class CartItemId implements Serializable {
    // CartItem can be repeated(so if it repeated add the quantty rather than create new cart item)
     Integer identity;
     String SKU;

    public CartItemId() {
    }

    public CartItemId(Integer identity, String SKU) {
        this.identity = identity;
        this.SKU = SKU;
    }
}
