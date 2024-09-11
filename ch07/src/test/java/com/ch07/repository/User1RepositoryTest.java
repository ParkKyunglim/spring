package com.ch07.repository;

import com.ch07.entity.Child;
import com.ch07.entity.Parent;
import com.ch07.entity.User1;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;


    @Test
    void findUser1ByUid() {
        User1 entity = user1Repository.findUser1ByUid("a101");
        System.out.println(entity);
    }

    @Test
    void findUser1ByName() {
        List<User1> users = user1Repository.findUser1ByName("김춘추");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameNot() {
        List<User1> users = user1Repository.findUser1ByNameNot("김춘추");
        System.out.println(users);
    }

    @Test
    void findUser1ByUidAndName(){
        User1 entity = user1Repository.findUser1ByUidAndName("a101", "김유신");
        System.out.println(entity);
    }
    @Test
    void findUser1ByUidOrName(){}
    @Test
    void findUser1ByAgeGreaterThan(){}
    @Test
    void findUser1ByAgeGreaterThanEqual(){}
    @Test
    void findUser1ByAgeLessThan(){}
    @Test
    void findUser1ByAgeLessThanEqual(){}
    @Test
    void findUser1ByAgeBetween(){}

    @Test
    void selectUser1UnderAge30(){}

    @Test
    void selectUser1WhereName(){}

    @Test
    void selectUser1WhereNameParam(){}

    @Test
    void selectFromParentJoinChild(){
        List<Object[]> list = user1Repository.selectFromParentJoinChild("P101");

        System.out.println(list.size());

        for(Object[] obj : list){
            System.out.println(Arrays.toString(obj));

            Parent parent = (Parent) obj[0];
            Child child = (Child) obj[1];

            System.out.println(parent);
            System.out.println(child);
        }
    }

}