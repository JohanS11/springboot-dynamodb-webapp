package edu.eci.arep.project.services.impl;

import edu.eci.arep.project.exception.ProductException;
import edu.eci.arep.project.model.Product;
import edu.eci.arep.project.repository.ProductRepository;
import edu.eci.arep.project.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) throws ProductException {
        if(productRepository.findById(product.getId()).isPresent()){
            throw new ProductException(ProductException.PRODUCT_REGISTERED);
        }
        else {
            productRepository.save(product);
        }
    }

    @Override
    public Product getProductById(String id) throws ProductException {
        return productRepository.findById(id).orElseThrow(() -> new ProductException(ProductException.PRODUCT_NOT_FOUND));
    }

}

