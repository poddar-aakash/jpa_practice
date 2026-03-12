package com.practice.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customerName;


//    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @CreationTimestamp
    private Date orderDate;

    public Order() {
    }

    public Order(Long id, String customerName, Date orderDate) {
        this.id = id;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}
