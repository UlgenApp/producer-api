package tr.edu.ku.ulgen.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic ulgenTopic() {
        return TopicBuilder
                .name("ulgen")
                .build();
    }
}
