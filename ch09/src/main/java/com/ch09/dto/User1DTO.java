package com.ch09.dto;


import com.ch09.entity.User1;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User1DTO {
    private String uid;
    private String name;
    private String birth;
    private String hp;
    private int age;

    public User1 toEntity() {
        return User1.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }
}