package com.ecommerce.controller;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Product;
import com.ecommerce.request.CreateProductRequest;
import com.ecommerce.response.ApiResponse;
import com.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("\"/api/admin/products\"")
public class AdminProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> createProductHandler(@RequestBody CreateProductRequest createProductRequest) throws ProductException{
        Product createProduct = productService.createProduct(createProductRequest);
        return new ResponseEntity<Product>(createProduct, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/productId}/delete")
    public ResponseEntity<ApiResponse> deleteProductHandler(@PathVariable Long productId) throws ProductException{
        System.out.println("dlete product controller .... ");
        String msg=productService.deleteProduct(productId);
        System.out.println("dlete product controller .... msg "+msg);
        ApiResponse res=new ApiResponse(msg,true);

        return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAllProduct(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @PutMapping("/{produtId}/update")
    public ResponseEntity<Product> updateProductHandler(@RequestBody Product product, @PathVariable Long produtId)throws ProductException{
        Product updateProduct=productService.updateProduct(produtId, product);
        return new ResponseEntity<Product>(updateProduct, HttpStatus.OK);
    }

    @PostMapping("/creates")
    public ResponseEntity<ApiResponse> createMultipleProduct(@RequestBody CreateProductRequest[] createProductRequests) throws ProductException{
        for(CreateProductRequest prducts : createProductRequests){
            productService.createProduct(prducts);
        }
        ApiResponse res=new ApiResponse("products created successfully",true);
        return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);

    }

}
