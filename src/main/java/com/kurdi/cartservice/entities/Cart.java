package com.kurdi.cartservice.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "carts")
public class Cart implements Serializable {
    @Id
    Integer Identity;
    @OneToMany(mappedBy="cart")
    List<CartItem> items = new ArrayList<>();

}
