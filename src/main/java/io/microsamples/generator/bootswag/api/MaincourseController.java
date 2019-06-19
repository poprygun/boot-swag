package io.microsamples.generator.bootswag.api;


import io.microsamples.generator.bootswag.model.Maincourse;
import org.jeasy.random.EasyRandom;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class MaincourseController implements MaincourseApi {

    private EasyRandom easyRandom = new EasyRandom();

    @Override
    public ResponseEntity<List<Maincourse>> myMaincourse() {
        List<Maincourse> maincourses = easyRandom.objects(Maincourse.class, 13).collect(Collectors.toList());

        return ResponseEntity.ok(maincourses);
    }
}
