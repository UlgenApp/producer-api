package tr.edu.ku.ulgen.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import tr.edu.ku.ulgen.dto.UlgenDto;
import tr.edu.ku.ulgen.util.UlgenDtoSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * KafkaProducerConfig class is responsible for creating and configuring Kafka Producer beans.
 * It reads the required configuration properties from the application properties file.
 *
 * @author Kaan Turkmen
 */
@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    /**
     * Produces a Map containing the Kafka producer configuration properties.
     *
     * @return a Map<String, Object> containing the configuration properties for the Kafka producer.
     */
    public Map<String, Object> producerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, UlgenDtoSerializer.class);

        return props;
    }

    /**
     * Creates a ProducerFactory bean for creating Kafka producers.
     *
     * @return a ProducerFactory<String, UlgenDto> instance configured with the producer properties.
     */
    @Bean
    public ProducerFactory<String, UlgenDto> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    /**
     * Creates a KafkaTemplate bean for working with Kafka producers.
     *
     * @param producerFactory the ProducerFactory<String, UlgenDto> instance used to create Kafka producers
     * @return a KafkaTemplate<String, UlgenDto> instance configured with the given producerFactory
     */
    @Bean
    public KafkaTemplate<String, UlgenDto> kafkaTemplate(ProducerFactory<String, UlgenDto> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
