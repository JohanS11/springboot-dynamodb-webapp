package edu.eci.arep.project.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import edu.eci.arep.project.model.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepository.class);

    @Autowired
    private DynamoDBMapper mapper;

    public void insertIntoDynamoDB(Product product) {
        mapper.save(product);
    }
}
