package com.ch09.entity;


import com.ch09.dto.User1DTO;
import com.ch09.dto.User2DTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

// Entity는 @Setter 안씀
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity                 // 엔티티 객체 정의
@Table(name = "user2")  // 매핑 테이블 설정
public class User2 {
    @Id
    private String uid;
    private String name;
    private String birth;
    private String addr;

    public User2DTO toDTO(){
        return User2DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();
    }
}