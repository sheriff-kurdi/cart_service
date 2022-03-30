package com.kurdi.cartservice.entities;

import com.kurdi.cartservice.entities.compositeKeys.CartItemId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_items")
public class CartItem {

    @EmbeddedId
    CartItemId id;
    int quantity;
    @ManyToOne
    @JoinColumn(name="cart_id", nullable=true)
    Cart cart;
}

