package com.onechain.graph_db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudioReport {
    private String name;
    private Long numChildren;
    private Long numGrandchildren;
    private List<String> types;
}
