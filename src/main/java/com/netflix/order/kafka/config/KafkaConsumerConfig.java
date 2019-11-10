package com.netflix.order.kafka.config;

import com.netflix.commons.kafka.dto.UserCreatedDto;
import com.netflix.order.kafka.deserializer.CustomJsonDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 10/11/2019 11:18
 */
@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserCreatedDto> userCreatedKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserCreatedDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userCreatedConsumerFactory());
        return factory;
    }

    public ConsumerFactory<String, UserCreatedDto> userCreatedConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new CustomJsonDeserializer<>(UserCreatedDto.class));
    }

}
