package com.netflix.order.service;

import com.netflix.commons.kafka.dto.UserCreatedDto;
import com.netflix.order.converter.OrderConverter;
import com.netflix.order.dto.CancelOrderRequest;
import com.netflix.order.dto.OrderResponse;
import com.netflix.order.entity.OrderEntity;
import com.netflix.order.entity.PaymentEntity;
import com.netflix.order.entity.enums.OrderStatus;
import com.netflix.order.kafka.producer.OrderCreatedProducer;
import com.netflix.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 08/11/2019 19:29
 */
@Service
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private OrderCreatedProducer orderCreatedProducer;

    public void createOrderToUser(UserCreatedDto userCreatedDto) {
        final OrderEntity orderEntity = orderConverter.orderCreatedDtoToOrderEntity(userCreatedDto);
        processPayment(orderEntity);
        orderRepository.save(orderEntity);
        orderCreatedProducer.sendMessage(orderConverter.orderCreatedDtoToOrderEntity(orderEntity));
    }

    private void processPayment(OrderEntity orderEntity) {
        IntStream.range(0, 30).forEach(i -> {
            try {
                logger.info("Waiting to proccess... {}s", i);
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        orderEntity.setPayment(PaymentEntity.builder().insertDate(Instant.now()).build());
        orderEntity.setOrderStatus(OrderStatus.PAID);
    }

    public void cancel (final Long idOrder, final CancelOrderRequest cancelOrderRequest) {
        OrderEntity order = orderRepository.getOne(idOrder);
        order.setOrderStatus(OrderStatus.CANCELED);
        // TODO Simular Estorno pagamento asyncrono
        orderRepository.save(order);
    }

    public List<OrderResponse> findByClientId (final Long clientId, final Pageable pageable) {
        final List<OrderEntity> ordersEntity = orderRepository.findByClientId(clientId, pageable);

        return ordersEntity.stream()
                .map(order -> orderConverter.toOrderResponse(order)).collect(Collectors.toList());
    }
}
