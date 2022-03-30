package com.kurdi.cartservice.services;

import com.kurdi.cartservice.dto.CartItemDTO;
import com.kurdi.cartservice.entities.Cart;
import com.kurdi.cartservice.entities.CartItem;
import com.kurdi.cartservice.entities.compositeKeys.CartItemId;
import com.kurdi.cartservice.repositories.CartItemsRepository;
import com.kurdi.cartservice.repositories.CartsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CartService {
    @Autowired
    CartsRepository cartsRepository;
    @Autowired
    CartItemsRepository cartItemsRepository;

    @Transactional
    public Cart addToCart(Integer identity, CartItemDTO cartItemDTO)
    {

        Cart cart = getCart(identity);
        CartItem cartItem;
        if(cartItemsRepository.existsById(new CartItemId(identity, cartItemDTO.getSKU())))
        {
            //noinspection OptionalGetWithoutIsPresent
            cartItem = cartItemsRepository.findById(new CartItemId(identity, cartItemDTO.getSKU())).get();
            cartItem.setQuantity(cartItem.getQuantity() + cartItemDTO.getQuantity());
            cartItemsRepository.save(cartItem);

        }else{
            cartItem = CartItem.builder()
                    .id(new CartItemId(identity, cartItemDTO.getSKU()))
                    .quantity(cartItemDTO.getQuantity())
                    .cart(getCart(identity))
                    .build();
            cart.getItems().add(cartItem);
        }
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
