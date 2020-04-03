package com.example.course.product;

import com.example.course.category.Category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    private static final Long serialUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private double price;

    private String imgUrl;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name="product_id"), inverseJoinColumns = @JoinColumn(name="category_id"))
    private Set<Category> categories = new HashSet<>();

    public Product(Long id,String name,String description,double price,String imgUrl) {
        super();
        this.id=id;
        this.name=name;
        this.description=description;
        this.price=price;
        this.imgUrl=imgUrl;
    }


}
