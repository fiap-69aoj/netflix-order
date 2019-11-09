package com.netflix.order.service;

import com.netflix.order.converter.OrderConverter;
import com.netflix.order.dto.CancelOrderRequest;
import com.netflix.order.dto.CreateOrderRequest;
import com.netflix.order.dto.CreateOrderResponse;
import com.netflix.order.entity.OrderEntity;
import com.netflix.order.entity.enums.OrderStatus;
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

    @Autowired
    private OrderConverter orderConverter;

    public CreateOrderResponse save(final CreateOrderRequest orderRequest) {
        OrderEntity orderEntity = orderRepository.save(orderConverter.toCreateOrderEntity(orderRequest));
        // TODO SImular Aprovação pagamento asyncrono
        return orderConverter.toCreateOrderResponse(orderEntity);
    }

    public void cancel (final Long idOrder, final CancelOrderRequest cancelOrderRequest) {
        OrderEntity order = orderRepository.getOne(idOrder);
        order.setOrderStatus(OrderStatus.CANCELED);
        // TODO Simular Estorno pagamento asyncrono
        orderRepository.save(order);
    }
}
