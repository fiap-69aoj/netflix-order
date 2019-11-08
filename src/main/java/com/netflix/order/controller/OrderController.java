package com.netflix.order.controller;

import com.netflix.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 08/11/2019 19:30
 */
@Controller
@RequestMapping("/")
public class OrderController {

    @Autowired
    private OrderService orderService;

}
