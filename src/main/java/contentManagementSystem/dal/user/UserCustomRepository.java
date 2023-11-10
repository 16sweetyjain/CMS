package contentManagementSystem.dal.user;

import contentManagementSystem.model.User;

public interface UserCustomRepository {
    public User createUser(String name, String gmail);
    public User findUserByUserId(String userId);
    public User findUserByEmail(String mail);
}
