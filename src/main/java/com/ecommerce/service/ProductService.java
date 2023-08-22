package com.ecommerce.service;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Product;
import com.ecommerce.request.CreateProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public Product createProduct(CreateProductRequest req);
    public  String deleteProduct(Long productId) throws ProductException;
    public Product updateProduct(Long productId, Product req)throws ProductException;
    public Product findProductById(Long id)throws ProductException;
    public List<Product>findProductByCategory(String category);

    public Page<Product>getAllProduct(String category, List<String>color, List<String>sizes, Integer minPrice,
                                      Integer maxPrice, Integer miniDiscount, String sort,String stock, Integer pageNumber, Integer pageSize );
}
