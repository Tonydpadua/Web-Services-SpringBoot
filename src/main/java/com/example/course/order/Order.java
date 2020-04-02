package com.example.course.order;

import com.example.course.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone ="GMT")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name="client_id")

    private User client;

    private Integer orderStatus;

    public OrderStatus getOrderStatus(){
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus){
        if(orderStatus !=null){
            this.orderStatus=orderStatus.getCode();
        }
    }

    public Order(Long id,Instant moment,User client,OrderStatus orderStatus) {
        super();
        this.id=id;
        this.moment=moment;
        this.client=client;
        setOrderStatus(orderStatus);
    }

}
