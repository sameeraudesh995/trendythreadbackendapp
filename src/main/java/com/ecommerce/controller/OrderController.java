package com.ecommerce.controller;

import com.ecommerce.exception.OrderException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Address;
import com.ecommerce.model.Order;
import com.ecommerce.model.User;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Order>CreateOrder(@RequestBody Address spippingAddress, @RequestHeader("Authorization")String jwt) throws UserException{
        User user =userService.findUserProfileByJwt(jwt);
        Order order=orderService.createOrder(user, spippingAddress);
        System.out.println("order "+order);
        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }
    @GetMapping("/user")
    public ResponseEntity<List<Order>> userOrderHistory(@RequestHeader("Athorization")String jwt) throws OrderException, UserException{
        User user = userService.findUserProfileByJwt(jwt);
        List<Order> orders=orderService.usersOrderHistory(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable("id")Long orderId, @RequestHeader("Authorization")String jwt) throws UserException, OrderException{
        User user= userService.findUserProfileByJwt(jwt);
        Order order = orderService.findOrderById(orderId);
        return new ResponseEntity<>(order,HttpStatus.CREATED);
    }

}
