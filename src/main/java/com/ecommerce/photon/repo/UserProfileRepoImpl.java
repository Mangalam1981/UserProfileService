package com.ecommerce.photon.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.photon.model.User;
@Repository
public class UserProfileRepoImpl implements UserProfileRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public User findUserByEmail(String email, String password) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        query.addCriteria(Criteria.where("password").is(password));
        List<User> users = mongoTemplate.find(query, User.class);
        if (users != null && !users.isEmpty()) {
            return users.get(0);
        }else {

            throw new Exception();

        }
    }

    @Override
    public String addNewUser(User user) {

        try {
            mongoTemplate.insert(user);
            return  "User created successfully";
        } catch (Exception e) {
            throw e;
        }
    }
}
