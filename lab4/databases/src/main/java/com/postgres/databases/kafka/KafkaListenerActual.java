package com.postgres.databases.kafka;

import com.postgres.databases.service.ActualService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaListenerActual {

    @Autowired
    private ActualService actualService;


    @KafkaListener(topics = "actual", groupId = "group1")
    void listener(String data) {
        log.info("Received message [{}] in group1", data);

        actualService.setTicket(data);

    }


}
