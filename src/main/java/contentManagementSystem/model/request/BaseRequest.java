package contentManagementSystem.model.request;

public class BaseRequest {
    String selectedSchema;
    String requestId;

    public BaseRequest(String selectedSchema, String requestId) {
        this.selectedSchema = selectedSchema;
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getSelectedSchema() {
        return selectedSchema;
    }

    public void setSelectedSchema(String selectedSchema) {
        this.selectedSchema = selectedSchema;
    }
}
