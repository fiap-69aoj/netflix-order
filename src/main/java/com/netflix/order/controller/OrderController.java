package com.netflix.order.controller;

import com.netflix.order.dto.CancelOrderRequest;
import com.netflix.order.dto.CreateOrderRequest;
import com.netflix.order.dto.CreateOrderResponse;
import com.netflix.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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

//    @GetMapping
//    public ResponseEntity<OrderResponse> findByUser(
//            @RequestParam(name = "idUser") String idUser) {
//        final UserResponse userResponse = userService.findUserByEmailAndPassword(email, password);
//        if(userResponse == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return new ResponseEntity<>(userResponse, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<CreateOrderResponse> save(@Valid @RequestBody final CreateOrderRequest orderRequest) {
        final CreateOrderResponse orderResponse = orderService.save(orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/cancel")
    public ResponseEntity<HttpStatus> cancel(@Valid @PathVariable("id") final Long idOrder,
        @Valid @RequestBody CancelOrderRequest cancelOrderRequest) {
        orderService.cancel(idOrder, cancelOrderRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
