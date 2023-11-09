package contentManagementSystem.model.request;

import contentManagementSystem.enums.SchemaEnum;

public class BaseRequest {
    String requestId;
    SchemaEnum schemaEnum;

    public BaseRequest(String requestId, SchemaEnum schemaEnum) {
        this.requestId = requestId;
        this.schemaEnum = schemaEnum;
    }

    public SchemaEnum getSchemaEnum() {
        return schemaEnum;
    }

    public void setSchemaEnum(SchemaEnum schemaEnum) {
        this.schemaEnum = schemaEnum;
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
