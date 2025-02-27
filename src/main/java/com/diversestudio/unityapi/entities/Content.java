package com.diversestudio.unityapi.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "content")
@Getter
@Setter
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long content_id;

    @Column(nullable = false)
    private String data;

    @ManyToOne
    @JoinColumn(name = "creator", referencedColumnName = "user_id", nullable = false)
    private User creator;

    @Column(nullable = false, length = 100)
    private String name;

    @Column
    private String description;

    @Column
    private int version;

    @OneToOne(mappedBy = "content", cascade = CascadeType.ALL, orphanRemoval = true)
    private ContentDates contentDates;
}
