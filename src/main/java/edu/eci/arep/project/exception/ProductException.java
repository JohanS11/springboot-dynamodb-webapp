package edu.eci.arep.project.exception;

public class ProductException extends Exception {
    public static final String PRODUCT_NOT_FOUND = "Product couldn't be found";
    public static final String PRODUCT_REGISTERED = "Product already registered" ;

    public ProductException(Object p0) {
    }
}
