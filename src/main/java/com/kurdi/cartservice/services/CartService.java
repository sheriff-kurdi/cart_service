package com.kurdi.cartservice.services;

import com.kurdi.cartservice.entities.Cart;
import com.kurdi.cartservice.entities.CartItem;
import com.kurdi.cartservice.repositories.CartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CartService {
    @Autowired
    CartsRepository cartsRepository;

    @Transactional
    public Cart addToCart(Integer identity, CartItem cartItem)
    {
        if(!cartsRepository.existsById(identity))
        {
            Cart newCart = Cart.builder().Identity(identity).build();
            cartsRepository.save(newCart);
        }
        Cart cart = cartsRepository.getById(identity);
        cart.getItems().add(cartItem);
        cartsRepository.save(cart);

        return cart;
    }
    @Transactional
    public Cart getCart(Integer identity)
    {
        Cart cart;
        if(!cartsRepository.existsById(identity))
        {
            Cart newCart = Cart.builder().Identity(identity).build();
            cartsRepository.save(newCart);
        }
        cart = cartsRepository.getById(identity);
        return cart;
    }
}
