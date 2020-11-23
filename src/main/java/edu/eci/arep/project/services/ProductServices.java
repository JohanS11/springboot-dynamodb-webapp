package edu.eci.arep.project.services;

import edu.eci.arep.project.exception.ProductException;
import edu.eci.arep.project.model.Product;

import java.util.List;

public interface ProductServices {

    List<Product> getProducts();

    void addProduct(Product product) throws ProductException;

    Product getProductById(String id) throws ProductException;

}
