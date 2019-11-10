package com.netflix.order.kafka.consumer;

import com.netflix.commons.kafka.dto.UserCreatedDto;
import com.netflix.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 10/11/2019 15:21
 */
@Service
public class UserCreatedConsumer {

    private final Logger logger = LoggerFactory.getLogger(UserCreatedConsumer.class);

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "user_created", groupId = "group_id", containerFactory = "userCreatedKafkaListenerContainerFactory")
    public void consume(UserCreatedDto message) throws IOException {
        logger.info(String.format("Consuming user_created, user: %s", message.toString()));
        orderService.createOrderToUser(message);
    }

}
