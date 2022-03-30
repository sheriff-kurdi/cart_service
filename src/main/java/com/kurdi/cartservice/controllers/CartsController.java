package com.kurdi.cartservice.controllers;

import com.kurdi.cartservice.dto.CartItemDTO;
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

    @GetMapping("getCart")
    public ResponseEntity<Cart> getCart(){
        Integer identity = 1;//TODO: get identity from token;
        return new ResponseEntity<>(cartService.getCart(identity), HttpStatus.OK);
    }
    @PostMapping("addToCart")
    public ResponseEntity<Cart> addToCart(@RequestBody CartItemDTO cartItemDTO){
        Integer identity = 1;//TODO: get identity from token;
        Cart cart = cartService.addToCart(identity,cartItemDTO);
        return new ResponseEntity<>(cart, HttpStatus.OK);

    }
    @GetMapping("clearCart")
    public ResponseEntity<Cart> clearCart(){
        Integer identity = 1;//TODO: get identity from token;
        return new ResponseEntity<>(cartService.clearCart(identity),HttpStatus.OK);
    }


}
