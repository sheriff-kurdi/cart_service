package com.kurdi.cartservice.repositories;

import com.kurdi.cartservice.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartsRepository extends JpaRepository<Cart, Integer> {
}
