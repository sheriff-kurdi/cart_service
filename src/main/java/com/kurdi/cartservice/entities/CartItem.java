package com.kurdi.cartservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kurdi.cartservice.entities.compositeKeys.CartItemId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_items")
@ToString
public class CartItem implements Serializable {

    @EmbeddedId
    CartItemId id;
    int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cart_id", nullable=true)
    @JsonIgnore
    Cart cart;
}

