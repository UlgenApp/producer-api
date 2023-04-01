package tr.edu.ku.ulgen.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import tr.edu.ku.ulgen.dto.UlgenDto;

@RestController
@RequestMapping("/api/v1/producer")
@AllArgsConstructor
public class ProducerController {
    private KafkaTemplate<String, UlgenDto> kafkaTemplate;

    @PostMapping("/produce")
    public ResponseEntity<?> authenticate(@RequestBody UlgenDto request) {
        return ResponseEntity.ok(kafkaTemplate.send("ulgen", request.getUserId().toString(), request));
    }
}
