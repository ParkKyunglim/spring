package com.sboard.repository;

import com.sboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    public int countByUid(String uid);
    public int countByNick(String nick);
    public int countByEmail(String email);
    public int countByHp(String hp);
}
