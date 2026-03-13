package com.practice.main;

import com.practice.dao.OrderDao;
import com.practice.dao.OrderItemDao;
import com.practice.dao.ProductDao;
import com.practice.entity.Order;
import com.practice.entity.OrderItem;
import com.practice.entity.Product;
import com.practice.util.JPAUtill;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        EntityManager em =  JPAUtill.getEntityManager();
        ProductDao productDao = new ProductDao(em);
        OrderDao orderDao = new OrderDao(em);
        OrderItemDao orderItemDao =  new OrderItemDao(em);



//        Product p1 = new Product();
//        p1.setProductName("soap");
//        p1.setPrice(200L);

        //========== Add new Product ========
//        em.getTransaction().begin();
//        productDao.saveProduct(p1);
//        em.getTransaction().commit();

        //====== get All products ========
//        List<Product> bookList = productDao.getAllProducts();
//        for(Product product : bookList){
//            System.out.println(product);
//        }

        //========= Get Product By Id ========
//        Product product = productDao.getProduct(1L);
//        System.out.println(product);


        //==========Delete product by id ===========
//        em.getTransaction().begin();
//        productDao.deleteProduct(2L);
//        em.getTransaction().commit();


        // ORDER OPERATIONS
        //========================

//        Order order1 = new Order();
//        order1.setCustomerName("Akash");
//
//        // Create Order
////        em.getTransaction().begin();
////        orderDao.saveOrder(order1);
////        em.getTransaction().commit();
//
//
//        // Get Order by Id
//        Order order = orderDao.getOrder(1L);
//        System.out.println(order);
//
//
//        // Get All Orders
//        List<Order> orders = orderDao.getAllOrders();
//        for(Order o : orders){
//            System.out.println(o);
//        }
//
//        //==========Delete order by id ===========
//          em.getTransaction().begin();
//          orderDao.deleteOrder(2L);
//          em.getTransaction().commit();

        Product product = productDao.getProduct(1L);
        Order order = orderDao.getOrder(1L);

        OrderItem item = new OrderItem();
        item.setOrder(order);
        item.setProduct(product);

        em.getTransaction().begin();
        orderItemDao.saveOrderItem(item);
        em.getTransaction().commit();


    }
}
