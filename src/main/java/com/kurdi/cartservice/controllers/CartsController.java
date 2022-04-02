package com.kurdi.cartservice.controllers;

import com.kurdi.cartservice.dto.CartItemDTO;
import com.kurdi.cartservice.entities.Cart;
import com.kurdi.cartservice.entities.CartItem;
import com.kurdi.cartservice.repositories.CartsRepository;
import com.kurdi.cartservice.services.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/carts/")
public class CartsController {

    @Autowired
    CartService cartService;

    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("getCart")
    public ResponseEntity<Cart> getCart(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Integer identity = Integer.parseInt(auth.getPrincipal().toString());
        Cart cart = cartService.getCart(identity);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
    @PostMapping("addToCart")
    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Cart> addToCart(@RequestBody CartItemDTO cartItemDTO){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Integer identity = Integer.parseInt(auth.getPrincipal().toString());
        Cart cart = cartService.addToCart(identity,cartItemDTO);
        return new ResponseEntity<>(cart, HttpStatus.OK);

    }
    @GetMapping("clearCart")
    @Operation(security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Cart> clearCart(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Integer identity = Integer.parseInt(auth.getPrincipal().toString());        return new ResponseEntity<>(cartService.clearCart(identity),HttpStatus.OK);
    }


}
