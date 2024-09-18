package org.senechka.lab1.kafka.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    //todo refactor dummy
    @Bean
    public NewTopic firstTopic() {
        return TopicBuilder.name("topic-1")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic secondTopic() {
        return TopicBuilder.name("topic-2")
                .partitions(3)
                .replicas(1)
                .build();
    }

}