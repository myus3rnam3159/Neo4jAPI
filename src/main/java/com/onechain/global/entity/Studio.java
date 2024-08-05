package com.onechain.global.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Node("Studio")
public class Studio {
    @Id
    @GeneratedValue
    private long id;
    private String name;
}