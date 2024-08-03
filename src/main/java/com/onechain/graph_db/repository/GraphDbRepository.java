package com.onechain.graph_db.repository;

import com.onechain.global.entity.Movie;
import com.onechain.graph_db.dto.StudioReport;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
@EnableNeo4jRepositories
public interface GraphDbRepository extends Neo4jRepository<Movie, Long> {
    @Query(value = "MATCH (parent)-[]->(child)\n" +
            "OPTIONAL MATCH (child)-[]->(grandchild)\n" +
            "RETURN labels(parent) as types, parent.name as name, COUNT(DISTINCT child) AS numChildren, COUNT(DISTINCT grandchild) AS numGrandchildren\n")
    List<StudioReport> findNodesWithChildAndGrandchildCounts();
}
