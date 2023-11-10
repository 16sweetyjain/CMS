package contentManagementSystem.dal.user;

import contentManagementSystem.model.HelpX;
import contentManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository{
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public User createUser(String name, String email) {
        User user = new User(UUID.randomUUID().toString(), name, email);

        User createdUser = mongoTemplate.insert(user, "User");

        return  createdUser;
    }

    @Override
    public User findUserByUserId(String userId) {
        Query query = new Query();
        query.addCriteria(new Criteria("userId").is(userId));

        User user =  mongoTemplate.findOne(query, User.class);
        return  user;
    }

    @Override
    public User findUserByEmail(String email) {
        Query query = new Query();
        query.addCriteria(new Criteria("email").is(email));

        User user =  mongoTemplate.findOne(query, User.class);
        return  user;
    }
}
