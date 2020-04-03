package com.example.course.category;

import com.example.course.product.Product;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data

@NoArgsConstructor
@Entity
@Table(name="tb_category")
public class Category implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Transient
    private Set<Product> products = new HashSet<>();

    public Category(Long id,String name){
        this.id=id;
        this.name=name;
    }

}
