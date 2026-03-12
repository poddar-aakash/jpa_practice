package com.practice.dao;

import com.practice.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class OrderDao {

    private final EntityManager em;

    public OrderDao(EntityManager em) {
        this.em = em;
    }

    //Add order
    public void saveOrder(Order order) {
        em.persist(order);
    }

    //Find order By Id
    public Order getOrder(Long id) {
        return em.find(Order.class, id);
    }

    //Get all Orders
    public List<Order> getAllOrders() {
        TypedQuery<Order> query = em.createQuery("SELECT o FROM  Order o", Order.class);
        List<Order> resultList = query.getResultList();
        return resultList;
    }


    //Delete order
    public void deleteOrder(Long id) {
        Order order = em.find(Order.class, id);
        if (order != null) {
            em.remove(order);
        } else {
            System.out.println("Invalid Id");
        }
    }
}
