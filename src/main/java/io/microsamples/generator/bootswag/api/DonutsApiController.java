package io.microsamples.generator.bootswag.api;


import io.microsamples.generator.bootswag.model.Donut;
import org.jeasy.random.EasyRandom;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class DonutsApiController implements DonutsApi {

    private EasyRandom easyRandom = new EasyRandom();

    @Override
    public ResponseEntity<List<Donut>> myDonuts() {

        List<Donut> donuts = easyRandom.objects(Donut.class, 13).collect(Collectors.toList());

        return ResponseEntity.ok(donuts);
    }
}
