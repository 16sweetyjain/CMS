package contentManagementSystem.model.request.getRequest;

import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.model.request.BaseRequest;

public class GetSchemaRequest extends BaseRequest {
    String schemaId;

    public GetSchemaRequest(String requestId, SchemaEnum schemaEnum, String schemaId) {
        super(requestId, schemaEnum);
        this.schemaId = schemaId;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }
}
