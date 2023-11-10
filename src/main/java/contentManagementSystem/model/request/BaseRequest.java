package contentManagementSystem.model.request;

import contentManagementSystem.enums.SchemaEnum;

import java.util.Map;

public class BaseRequest {
    String requestId;
    String userId;
    Map<String, String> headers;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public BaseRequest(String requestId, String userId) {
        this.requestId = requestId;
        this.userId = userId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
