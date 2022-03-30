package com.kurdi.cartservice.controllers;

import com.kurdi.cartservice.entities.Cart;
import com.kurdi.cartservice.entities.CartItem;
import com.kurdi.cartservice.repositories.CartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/carts/")
public class CartsController {

    @Autowired
    CartsRepository cartsRepository;

    @GetMapping()
    public ResponseEntity<Cart> getCart()
    {
        Integer identity = 0;//TODO: get identity from token;
        if(cartsRepository.existsById(identity))
        {
            Cart cart = cartsRepository.getById(identity);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Cart> addToCart(@RequestBody CartItem cartItem)
    {
        Integer identity = 0;//TODO: get identity from token;
        if(!cartsRepository.existsById(identity))
        {
            Cart newCart = Cart.builder().Identity(identity).build();
            cartsRepository.save(newCart);
        }
        Cart cart = cartsRepository.getById(identity);
        cart.getItems().add(cartItem);
        cartsRepository.save(cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);

    }
}
