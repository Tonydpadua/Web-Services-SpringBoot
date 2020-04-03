package com.example.course.order;

import com.example.course.orderItem.OrderItem;
import com.example.course.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
//@Data
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

    //@JsonIgnore
    @OneToMany(mappedBy = "id.order")
    Set<OrderItem> items = new HashSet<>();

    public OrderStatus getOrderStatus(){
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus){
        if(orderStatus !=null){
            this.orderStatus=orderStatus.getCode();
        }
    }

    public Set<OrderItem> getItems(){
        return items;
    }

    public Order(Long id,Instant moment,OrderStatus orderStatus,User client) {
        super();
        this.id=id;
        this.moment=moment;
        setOrderStatus(orderStatus);
        this.client=client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
