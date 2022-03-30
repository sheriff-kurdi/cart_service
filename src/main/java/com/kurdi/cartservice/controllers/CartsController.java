package com.kurdi.cartservice.controllers;

import com.kurdi.cartservice.entities.Cart;
import com.kurdi.cartservice.entities.CartItem;
import com.kurdi.cartservice.repositories.CartsRepository;
import com.kurdi.cartservice.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/carts/")
public class CartsController {

    @Autowired
    CartService cartService;

    @GetMapping()
    public ResponseEntity<Cart> getCart()
    {
        Integer identity = 0;//TODO: get identity from token;
        return new ResponseEntity<>(cartService.getCart(identity), HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<Cart> addToCart(@RequestBody CartItem cartItem)
    {
        Integer identity = 0;//TODO: get identity from token;
        Cart cart = cartService.addToCart(identity,cartItem);
        return new ResponseEntity<>(cart, HttpStatus.OK);

    }
}
