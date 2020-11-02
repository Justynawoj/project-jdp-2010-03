package com.kodilla.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private Long quantity;

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;

    @JsonBackReference
    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="group_id")
    private Group group;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    public Product(String title, BigDecimal price, String description, Long quantity) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) &&
                Objects.equals(title, product.title) &&
                Objects.equals(price, product.price) &&
                Objects.equals(description, product.description) &&
                Objects.equals(group, product.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, description, group);
    }
}
