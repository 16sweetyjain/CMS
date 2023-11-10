package contentManagementSystem.model.request.getRequest;

import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.request.BaseSchemaRequest;

public class GetSchemaRequest extends BaseSchemaRequest {
    String schemaId;

    public GetSchemaRequest(String requestId, String userId, SchemaEnum schemaEnum, String schemaId) {
        super(requestId, userId, schemaEnum);
        this.schemaId = schemaId;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }
}
