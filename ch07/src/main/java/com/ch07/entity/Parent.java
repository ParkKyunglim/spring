package com.ch07.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "parent")
public class Parent {
    @Id
    private String pid;
    private String name;
    private String birth;
    private String addr;
}