package com.cg.OrderService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Db_sequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DbSequence {
    @Id
    private String id;
    private int seq;
}
