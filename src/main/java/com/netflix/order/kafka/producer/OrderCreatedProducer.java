package com.netflix.order.kafka.producer;

import com.netflix.commons.kafka.dto.OrderCreatedDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 10/11/2019 18:24
 */
@Service
public class OrderCreatedProducer {

    private static final Logger logger = LoggerFactory.getLogger(OrderCreatedProducer.class);
    private static final String TOPIC = "order_created";

    @Autowired
    private KafkaTemplate<String, OrderCreatedDto> orderCreatedKafkaTemplate;

    public void sendMessage(OrderCreatedDto user) {
        logger.info(String.format("Producing %s, user: %s", TOPIC, user.toString()));
        this.orderCreatedKafkaTemplate.send(TOPIC, user);
    }

}
