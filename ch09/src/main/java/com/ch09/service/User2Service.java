package com.ch09.service;

import com.ch09.dto.User1DTO;
import com.ch09.dto.User2DTO;
import com.ch09.entity.User2;
import com.ch09.repository.User1Repository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class User2Service {

    private final User2Repository user2Repository;

    public User2 insertUser2(User2DTO user2DTO) {
        User2 entity = user2DTO.toEntity();
        return user2Repository.save(entity);
    }

    public User1DTO selectUser2(String uid){

        Optional<User2> opt = user2Repository.findById(uid);

        if(opt.isPresent()){
            User2 user2 = opt.get();
            return user2.toDTO();
        }
        return null;
    }

    public List<User1DTO> selectUser1s(){

        List<User2> user1s = user1Repository.findAll();

        List<User1DTO> users = user1s
                .stream()
                .map(entity -> entity.toDTO())
                .collect(Collectors.toList());
        return users;
    }

    public User2 updateUser1(User1DTO user1DTO) {

        boolean result = user1Repository.existsById(user1DTO.getUid());

        if(result){
            User2 entity = user1DTO.toEntity();
            return user1Repository.save(entity);
        }
        return null;
    }

    public void deleteUser1(String uid){
        if (!user1Repository.existsById(uid)){
            throw new EntityNotFoundException("user not found");
        }
        user1Repository.deleteById(uid);
    }
}