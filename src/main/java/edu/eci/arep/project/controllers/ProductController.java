package edu.eci.arep.project.controllers;

import edu.eci.arep.project.exception.ProductException;
import edu.eci.arep.project.model.Product;
import edu.eci.arep.project.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("products")
public class ProductController {

    private final ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Product> getProducts()
    {
        return productServices.getProducts();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getProductById(@PathVariable String id)
    {
        try {
            return new ResponseEntity<>(productServices.getProductById(id), HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addProduct(@RequestBody Product product)
    {
        try {
            productServices.addProduct(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ProductException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
}
