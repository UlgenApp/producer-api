package tr.edu.ku.ulgen.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import tr.edu.ku.ulgen.dto.UlgenDto;

/**
 * ProducerController is a RESTful web service controller responsible for handling
 * requests related to producing messages to a Kafka topic. It uses a KafkaTemplate
 * to send messages to the Kafka topic.
 *
 * @author Kaan Turkmen
 */
@RestController
@RequestMapping("/api/v1/producer")
@AllArgsConstructor
@Slf4j
public class ProducerController {
    private KafkaTemplate<String, UlgenDto> kafkaTemplate;

    @PostMapping("/produce")
    public ResponseEntity<?> authenticate(@RequestBody UlgenDto request) {
        log.info("Produce request is received by the producer microservice: {}", request);
        return ResponseEntity.ok(kafkaTemplate.send("ulgen", request.getUserId().toString(), request));
    }
}
