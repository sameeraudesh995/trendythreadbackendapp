package com.ecommerce.service.impl;

import com.ecommerce.model.OrderItem;
import com.ecommerce.repository.OrderItemRepository;
import com.ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImplementation implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {

        return orderItemRepository.save(orderItem);
    }
}
