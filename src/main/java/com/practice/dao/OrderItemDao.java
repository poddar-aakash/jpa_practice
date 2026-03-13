package com.practice.dao;

import com.practice.entity.OrderItem;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OrderItemDao {

        private EntityManager em;

        public OrderItemDao(EntityManager em) {
            this.em = em;
        }

        // Save OrderItem
        public void saveOrderItem(OrderItem orderItem){
            em.persist(orderItem);
        }

        // Get OrderItem by id
        public OrderItem getOrderItem(Long id){
            return em.find(OrderItem.class, id);
        }

        // Get all OrderItems
        public List<OrderItem> getAllOrderItems(){
            return em.createQuery("from OrderItem", OrderItem.class).getResultList();
        }

        // Delete OrderItem
        public void deleteOrderItem(Long id){
            OrderItem item = em.find(OrderItem.class, id);
            if(item != null){
                em.remove(item);
            }else {
                System.out.println("can not delete orderItem for this id");
            }
        }
    }

