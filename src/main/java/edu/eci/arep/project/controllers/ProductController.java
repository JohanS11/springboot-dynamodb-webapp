package edu.eci.arep.project.controllers;
import edu.eci.arep.project.model.Product;
import edu.eci.arep.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("products")
public class ProductController {

    private final ProductRepository productServices;

    @Autowired
    public ProductController(ProductRepository productServices) {
        this.productServices = productServices;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getProducts()
    {
        return productServices.getProducts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addProduct(@RequestBody Product product)
    {
        productServices.insertIntoDynamoDB(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@RequestParam String id)
    {
        Product product = productServices.getProductById(id);
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }

}
