package com.practice.main;

import com.practice.dao.OrderDao;
import com.practice.dao.ProductDao;
import com.practice.entity.Product;
import com.practice.util.JPAUtill;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        EntityManager em =  JPAUtill.getEntityManager();
        ProductDao productDao = new ProductDao(em);
        OrderDao orderDao = new OrderDao(em);


        Product p1 = new Product();
        p1.setProductName("soap");
        p1.setPrice(200L);

        //========== Add new Product ========
        em.getTransaction().begin();
        productDao.saveProduct(p1);
        em.getTransaction().commit();

        //====== get All products ========
        List<Product> bookList = productDao.getAllProducts();
        for(Product product : bookList){
            System.out.println(product);
        }

        //========= Get Product By Id ========
        Product product = productDao.getProduct(1L);
        System.out.println(product);


        //==========Delete product by id ===========
        productDao.deleteProduct(2L);



    }
}
