package com.ecommerce.repository;

import java.util.Arrays;

import com.ecommerce.beans.Product;

public class ProductDAO {
    private static Product[] products = new Product[100];
    
    private static int productCount = 0;

    public boolean addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount++] = product;
            return true;
        }
        return false;
    }

    public Product[] getAllProducts() {
        Product[] result = new Product[productCount];
        System.arraycopy(products, 0, result, 0, productCount);
        return result;
    }

    public Product getProductById(int productId) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId() == productId) {
                return products[i];
            }
        }
        return null;
    }
}