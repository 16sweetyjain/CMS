package contentManagementSystem.model.response;

import contentManagementSystem.model.User;

public class UserResponse {
    User user;

    public UserResponse() {
    }

    public UserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "user=" + user +
                '}';
    }
}
