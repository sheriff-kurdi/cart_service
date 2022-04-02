package com.kurdi.cartservice.repositories;

import com.kurdi.cartservice.entities.Cart;
import com.kurdi.cartservice.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CartsRepository extends JpaRepository<Cart, Integer> {

}
