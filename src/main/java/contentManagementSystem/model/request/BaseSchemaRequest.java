package contentManagementSystem.model.request;

import contentManagementSystem.enums.SchemaEnum;

public class BaseSchemaRequest extends BaseRequest{
    SchemaEnum schemaEnum;

    public BaseSchemaRequest(String requestId, String userId, SchemaEnum schemaEnum) {
        super(requestId, userId);
        this.schemaEnum = schemaEnum;
    }

    public SchemaEnum getSchemaEnum() {
        return schemaEnum;
    }

    public void setSchemaEnum(SchemaEnum schemaEnum) {
        this.schemaEnum = schemaEnum;
    }
}
