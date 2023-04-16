package tr.edu.ku.ulgen.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * KafkaTopicConfig class is responsible for creating and configuring Kafka Topic beans.
 *
 * @author Kaan Turkmen
 */
@Configuration
public class KafkaTopicConfig {

    /**
     * Creates a NewTopic bean for the "ulgen" topic.
     *
     * @return a NewTopic instance with the name "ulgen".
     */
    @Bean
    public NewTopic ulgenTopic() {
        return TopicBuilder
                .name("ulgen")
                .build();
    }
}
