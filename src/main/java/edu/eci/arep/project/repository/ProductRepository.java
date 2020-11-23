package edu.eci.arep.project.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import edu.eci.arep.project.model.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepository.class);

    @Autowired
    private DynamoDBMapper mapper;

    public void insertIntoDynamoDB(Product product) {
        mapper.save(product);
    }

    public PaginatedScanList<Product> getProducts()
    {
        System.out.println(mapper.scan(Product.class, new DynamoDBScanExpression()));
        return mapper.scan(Product.class, new DynamoDBScanExpression());
    }

    public Product getProductById(String id)
    {
        return mapper.load(Product.class,id);
    }


}
