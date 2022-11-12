package com.mak.trainingapi.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Timestamp startDateTime;

    @NotNull
    private Timestamp endDateTime;

    @NotNull
    private Long duration;

    @NotNull
    private Double distance;

    private String additionalInfo;


    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private User user;
}
