package com.netflix.order.converter;

import com.netflix.commons.kafka.dto.OrderCreatedDto;
import com.netflix.commons.kafka.dto.OrderStatusDto;
import com.netflix.commons.kafka.dto.UserCreatedDto;
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
                .insertDate(Instant.now())
                .build();
    }

    public CreateOrderResponse toCreateOrderResponse (final OrderEntity orderEntity) {
        return CreateOrderResponse.builder()
                .clientID(orderEntity.getClient().getId())
                .build();
    }

    public OrderResponse toOrderResponse (final OrderEntity orderEntity) {
        return OrderResponse.builder()
                .insertDate(orderEntity.getInsertDate())
                .orderStatus(orderEntity.getOrderStatus())
                .build();
    }

    public OrderEntity orderCreatedDtoToOrderEntity (final UserCreatedDto userCreatedDto) {
        return OrderEntity.builder()
                .client(UserEntity.builder().id(userCreatedDto.getId()).build())
                .orderStatus(OrderStatus.WAITING_PAYMENT)
                .insertDate(Instant.now())
                .build();
    }

    public OrderCreatedDto orderCreatedDtoToOrderEntity (final OrderEntity orderEntity) {
        return OrderCreatedDto.builder()
                .clientId(orderEntity.getClient().getId())
                .orderStatus(OrderStatusDto.valueOf(orderEntity.getOrderStatus().name()))
                .orderId(orderEntity.getId())
                .build();
    }

}
