package com.example.demomusic.repository;

import com.example.demomusic.models.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class UserDao {

    Set<User> users = new HashSet<>();


    public boolean validateUserInDataBase(String userEmail) {
        this.users = new HashSet<>();
        User user1 = new User("tmehra@gmail.com", "Tanmay", "Mehra");
        User user2 = new User("rahul@gmail.com", "Rahul", "Gupta");
        users.add(user1);
        users.add(user2);

        for (User user : users) {
            if (user.getEmailAddress().equalsIgnoreCase(userEmail)){
                return true;
            }
        }

        return false;
    }


}
