package contentManagementSystem.service;

import contentManagementSystem.dal.user.UserCustomRepositoryImpl;
import contentManagementSystem.model.User;
import contentManagementSystem.model.request.user.CreateUserRequest;
import contentManagementSystem.model.request.user.FindUserRequest;
import contentManagementSystem.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserCustomRepositoryImpl userCustomRepository;

    public UserResponse createUser(CreateUserRequest request) {
        User user = new User();

        try {
            user = userCustomRepository.createUser(request.getName(), request.getEmail());
        }catch(Exception e) {
            e.printStackTrace();
        }

        UserResponse userResponse = new UserResponse(user);

        return userResponse;
    }

    public UserResponse findUserByUserId(String userId ) {
        User user = new User();

        try {
            user = userCustomRepository.findUserByUserId(userId);
        }catch(Exception e) {
            e.printStackTrace();
        }

        UserResponse userResponse = new UserResponse(user);

        return userResponse;
    }

    public UserResponse findUserByUserEmail(String email) {
        User user = new User();

        try {
            user = userCustomRepository.findUserByEmail(email);
        }catch(Exception e) {
            e.printStackTrace();
        }

        UserResponse userResponse = new UserResponse(user);

        return userResponse;
    }
}
