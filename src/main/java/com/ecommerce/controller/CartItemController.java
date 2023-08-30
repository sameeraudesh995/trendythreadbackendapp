package com.ecommerce.controller;

import com.ecommerce.exception.CartItemException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.CartItem;
import com.ecommerce.model.User;
import com.ecommerce.response.ApiResponse;
import com.ecommerce.service.CartItemService;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart_items")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private UserService userService;

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse>deleteCartItemHandler(@PathVariable Long cartItemId, @RequestHeader("Authorization")String jwt) throws CartItemException, UserException{
        User user = userService.findUserProfileByJwt(jwt);
        cartItemService.removecartItem(user.getId(), cartItemId);

        ApiResponse res =new ApiResponse("Item Remove From Cart", true);
        return new ResponseEntity<ApiResponse>(res, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<CartItem> updateCartItemHandler(@PathVariable Long cartItemId, @RequestBody CartItem cartItem, @RequestHeader("Authorization")String jwt) throws CartItemException, UserException{
        User user = userService.findUserProfileByJwt(jwt);
        CartItem updateCartItem = cartItemService.updateCartItem(user.getId(), cartItemId, cartItem );
        ApiResponse res = new ApiResponse("Item Updated", true);
        return new ResponseEntity<>(updateCartItem, HttpStatus.ACCEPTED);
    }
}

