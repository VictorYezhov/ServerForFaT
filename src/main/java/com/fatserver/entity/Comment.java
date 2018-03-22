package com.fatserver.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fatserver.helpers.JsonDateSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String textComment;
    private Integer price;

    @JsonSerialize(using = JsonDateSerializer.class)
    private Timestamp dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question_com;



}
