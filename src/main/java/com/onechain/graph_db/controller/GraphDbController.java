package com.onechain.graph_db.controller;

import com.onechain.global.entity.Movie;
import com.onechain.global.entity.Studio;
import com.onechain.graph_db.dto.StudioRequest;
import com.onechain.graph_db.service.GraphDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/graph_db")
public class GraphDbController {

    private final GraphDbService graphDbService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        Optional<List<Movie>> result = this.graphDbService.getMovies();
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/studio-report")
    public ResponseEntity<?> getStudioOrgReport() {
        Optional<?> result = this.graphDbService.getStudioOrgReport();
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/studios")
    public ResponseEntity<Studio>  createStudio(@RequestBody StudioRequest newStudio) {
        Optional<Studio> result = this.graphDbService.createStudio(newStudio);
        return result.isPresent() ? ResponseEntity.created(null).build() : ResponseEntity.badRequest().build();
    }
    @Autowired
    public GraphDbController(GraphDbService graphDbService) {
        this.graphDbService = graphDbService;
    }
}
