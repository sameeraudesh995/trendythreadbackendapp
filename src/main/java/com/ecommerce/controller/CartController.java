package com.ecommerce.controller;

import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.User;
import com.ecommerce.request.AddItemRequest;
import com.ecommerce.response.ApiResponse;
import com.ecommerce.service.CartService;
import com.ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private CartService cartService;
    private UserService userService;

    @GetMapping("/")
    //@Operation(description = "find cart by user id")
    public ResponseEntity<Cart> findUserCartHandler(@RequestHeader ("Authorization") String jwt) throws UserException{
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findUserCart(user.getId());
        System.out.println("cart - "+cart.getUser().getEmail());
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }
    @PutMapping("/add")
    //@Operation(description = "add item to cart")
    public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest addItemRequest , @RequestHeader("Authorization") String jwt ) throws UserException, ProductException{
        User user = userService.findUserProfileByJwt(jwt);
        cartService.addCartItem(user.getId(),addItemRequest);
        ApiResponse apiResponse = new ApiResponse("Item Added to cart Successfully", true);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);



    }

}
