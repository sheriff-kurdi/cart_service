package com.kurdi.cartservice.repositories;

import com.kurdi.cartservice.entities.CartItem;
import com.kurdi.cartservice.entities.compositeKeys.CartItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItem, CartItemId> {
}
