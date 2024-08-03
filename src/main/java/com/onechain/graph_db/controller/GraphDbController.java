package com.onechain.graph_db.controller;

import com.onechain.global.entity.Movie;
import com.onechain.graph_db.service.GraphDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    public GraphDbController(GraphDbService graphDbService) {
        this.graphDbService = graphDbService;
    }
}
