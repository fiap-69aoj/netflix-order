package com.netflix.order.converter;

import com.netflix.order.dto.CreateOrderRequest;
import com.netflix.order.dto.CreateOrderResponse;
import com.netflix.order.dto.OrderResponse;
import com.netflix.order.entity.OrderEntity;
import com.netflix.order.entity.UserEntity;
import com.netflix.order.entity.enums.OrderStatus;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 08/11/2019 22:18
 */
@Component
public class OrderConverter {

    public OrderEntity toCreateOrderEntity (final CreateOrderRequest orderRequest) {
        UserEntity userEntity = UserEntity.builder().id(orderRequest.getClientID()).build();
        return OrderEntity.builder()
                .client(userEntity)
                .orderStatus(OrderStatus.WAITING_PAYMENT)
                .moment(Instant.now())
                .build();
    }

    public CreateOrderResponse toCreateOrderResponse (final OrderEntity orderEntity) {
        return CreateOrderResponse.builder()
                .clientID(orderEntity.getClient().getId())
                .build();
    }

    public OrderResponse toOrderResponse (final OrderEntity orderEntity) {
        return OrderResponse.builder()
                .moment(orderEntity.getMoment())
                .orderStatus(orderEntity.getOrderStatus())
                .build();
    }

}
