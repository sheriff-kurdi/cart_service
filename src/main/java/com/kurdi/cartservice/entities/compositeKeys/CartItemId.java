package com.kurdi.cartservice.entities.compositeKeys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


public final class CartItemId {
    // CartItem can be repeated(so if it repeated add the quantty rather than create new cart item)
    final Integer identity;
    final String SKU;

    public CartItemId(Integer identity, String SKU) {
        this.identity = identity;
        this.SKU = SKU;
    }
}
