package io.microsamples.generator.bootswag.api;


import io.microsamples.generator.bootswag.model.Donut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

import static io.github.benas.randombeans.api.EnhancedRandom.randomStreamOf;

@Controller
public class DonutsApiController implements DonutsApi {
    @Override
    public ResponseEntity<List<Donut>> myDonuts() {

        List<Donut> donuts = randomStreamOf(13, Donut.class).collect(Collectors.toList());

        return ResponseEntity.ok(donuts);
    }
}
