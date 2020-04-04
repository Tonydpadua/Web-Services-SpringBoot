package com.example.course.orderItem;

import com.example.course.order.Order;
import com.example.course.product.Product;
import lombok.Data;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class OrderItemPK implements Serializable {

        private static final long serialVersionUID=1L;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;



}
