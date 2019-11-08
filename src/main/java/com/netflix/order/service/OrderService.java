package com.netflix.order.service;

import com.netflix.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 08/11/2019 19:29
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

}
