package com.kurdi.cartservice.controllers;

import com.kurdi.cartservice.entities.Cart;
import com.kurdi.cartservice.repositories.CartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/carts/")
public class CartsController {

    @Autowired
    CartsRepository cartsRepository;

    @GetMapping("{identity}")
    public ResponseEntity<Cart> getCart(Integer identity)
    {
        if(cartsRepository.existsById(identity))
        {
            Cart cart = cartsRepository.getById(identity);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
