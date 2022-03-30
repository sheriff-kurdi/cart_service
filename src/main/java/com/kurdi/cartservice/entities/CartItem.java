package com.kurdi.cartservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kurdi.cartservice.entities.compositeKeys.CartItemId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_items")
public class CartItem implements Serializable {

    @EmbeddedId
    CartItemId id;
    int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cart_id", nullable=true)
    @JsonIgnore
    Cart cart;
}

