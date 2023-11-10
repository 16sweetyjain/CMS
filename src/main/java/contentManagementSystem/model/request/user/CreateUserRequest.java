package contentManagementSystem.model.request.user;

import contentManagementSystem.model.request.BaseRequest;

public class CreateUserRequest extends BaseRequest {
    String name;
    String email;

    public CreateUserRequest(String requestId, String userId, String name, String email) {
        super(requestId, userId);
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
