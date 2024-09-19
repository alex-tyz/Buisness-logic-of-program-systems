package org.senechka.lab1.kafka.listneres;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaListenerExample {
    // todo infinite cycle
    @KafkaListener(topics = "topic-1", groupId = "group1")
    void listener(String data) {
        log.info("Received message [{}] in group1", data);
    }
}