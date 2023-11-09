package contentManagementSystem.model.request;

import contentManagementSystem.enums.SchemaEnum;

public class GetSchemaRequest extends BaseRequest{
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
