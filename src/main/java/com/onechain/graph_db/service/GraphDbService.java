package com.onechain.graph_db.service;

import com.onechain.global.entity.Movie;
import com.onechain.global.entity.Studio;
import com.onechain.graph_db.dto.StudioRequest;
import com.onechain.graph_db.repository.GraphDbRepository;
import com.onechain.graph_db.repository.StudioRepository;
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
    private final StudioRepository studioRepository;

    @Transactional
    public Optional<List<Movie>> getMovies() {
        return Optional.of(this.repository.findAll());
    }

    @Transactional
    public Optional<?> getStudioOrgReport() {
        return Optional.of(this.repository.findNodesWithChildAndGrandchildCounts());
    }

    @Transactional
    public Optional<Studio> createStudio(StudioRequest newData) {
        try {
            Studio newStudio = new Studio();
            newStudio.setName(newData.getName());
            return Optional.of(this.studioRepository.save(newStudio));
        } catch (Exception e) {

        }
        return Optional.empty();
    }

    @Autowired
    public GraphDbService(GraphDbRepository repository, StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
        this.repository = repository;
    }
}
