package contentManagementSystem.model.request;

public class BaseRequest {
    String requestId;

    public BaseRequest(String selectedSchema, String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


    @Override
    public String toString() {
        return "BaseRequest{" +
                ", requestId='" + requestId + '\'' +
                '}';
    }
}
