package com.project.earthquake.controller;

import com.project.earthquake.dto.EarthquakeDto;
import com.project.earthquake.dto.request.EarthquakeRequest;
import com.project.earthquake.service.EarthquakeService;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/earthquake")
public class EarthquakeController {
    private final EarthquakeService earthquakeService;

    public EarthquakeController(EarthquakeService earthquakeService) {
        this.earthquakeService = earthquakeService;
    }

    @GetMapping()
    public ResponseEntity<List<EarthquakeDto>> getEarthquakeLastFewDays(@RequestBody EarthquakeRequest earthquakeRequest) throws ParseException {
        return ResponseEntity.ok(earthquakeService.getEarthquakeLastFewDays(earthquakeRequest));
    }
}
