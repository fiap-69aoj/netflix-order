package com.netflix.order.service.producer;

import com.netflix.order.dto.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 09/11/2019 21:05
 */
@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "user";

    @Autowired
    private KafkaTemplate<String, Greeting> greetingKafkaTemplate;

    public void sendMessage(Greeting message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.greetingKafkaTemplate.send(TOPIC, message);
    }
}
