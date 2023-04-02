package tr.edu.ku.ulgen.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import tr.edu.ku.ulgen.dto.UlgenDto;

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
