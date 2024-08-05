package com.onechain.graph_db.repository;

import com.onechain.global.entity.Studio;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableNeo4jRepositories
public interface StudioRepository extends Neo4jRepository<Studio, Long> {
}