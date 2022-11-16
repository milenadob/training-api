package com.mak.trainingapi.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
@Getter
@Setter
@ToString
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
