package com.onechain.graph_db.service;

import com.onechain.global.entity.Movie;
import com.onechain.graph_db.repository.GraphDbRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class GraphDbService {

    private final GraphDbRepository repository;

    @Transactional
    public Optional<List<Movie>> getMovies() {
        return Optional.of(this.repository.findAll());
    }

    @Transactional
    public Optional<?> getStudioOrgReport(){
        return Optional.of(this.repository.findNodesWithChildAndGrandchildCounts());
    }

    @Autowired
    public GraphDbService(GraphDbRepository repository) {
        this.repository = repository;
    }
}
