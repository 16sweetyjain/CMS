package contentManagementSystem.model.request.user;

import contentManagementSystem.model.request.BaseRequest;

public class FindUserRequest extends BaseRequest {

    public FindUserRequest(String requestId, String userId) {
        super(requestId, userId);
    }
}
