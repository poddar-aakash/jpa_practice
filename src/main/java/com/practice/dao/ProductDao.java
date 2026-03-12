package com.practice.dao;

import com.practice.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductDao {

    private final EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;

    }

    //Add Product
    public void saveProduct(Product product) {
        em.persist(product);
    }

    //Find Product By Id
    public Product getProduct(Long id) {
        return em.find(Product.class, id);
    }

    //Get all Products
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM  Product p", Product.class);
        List<Product> resultList = query.getResultList();
        return resultList;
    }


    //Delete Product by id
    public void deleteProduct(Long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        } else {
            System.out.println("Invalid Id");
        }
    }
}
