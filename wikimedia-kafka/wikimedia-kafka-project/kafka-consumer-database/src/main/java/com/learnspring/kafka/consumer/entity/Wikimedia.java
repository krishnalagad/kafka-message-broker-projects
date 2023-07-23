package com.learnspring.kafka.consumer.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wikimedia_recentchanges")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Wikimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikiEventData;
}
