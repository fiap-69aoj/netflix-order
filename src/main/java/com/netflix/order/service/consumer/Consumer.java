package com.netflix.order.service.consumer;

import com.netflix.order.dto.Greeting;
import com.netflix.order.service.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 09/11/2019 21:06
 */
@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "user", groupId = "group_id", containerFactory = "greetingKafkaListenerContainerFactory")
    public void consume(Greeting message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}