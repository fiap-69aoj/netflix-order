package com.netflix.order.controller;

import com.netflix.order.dto.CancelOrderRequest;
import com.netflix.order.dto.OrderResponse;
import com.netflix.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 08/11/2019 19:30
 */
@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public Page<OrderResponse> findByUser(
            @RequestParam(name = "userId") Long userId, final Pageable pageable) {
        final List<OrderResponse> orderResponse = orderService.findByClientId(userId, pageable);
        return new PageImpl<>(orderResponse);
    }

    @PostMapping(value = "/{id}/cancel")
    public ResponseEntity<HttpStatus> cancel(@Valid @PathVariable("id") final Long idOrder,
        @Valid @RequestBody CancelOrderRequest cancelOrderRequest) {
        orderService.cancel(idOrder, cancelOrderRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
