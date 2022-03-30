package com.kurdi.cartservice.entities.compositeKeys;

public final class CartItemId {
    //TODO: can be repeated(so if it repeated add the quantty rather than create new cart item)
    final Integer identity;
    final String SKU;

    public CartItemId(Integer identity, String SKU) {
        this.identity = identity;
        this.SKU = SKU;
    }
}
