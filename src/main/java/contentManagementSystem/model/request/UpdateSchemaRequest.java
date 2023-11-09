package contentManagementSystem.model.request;

import contentManagementSystem.enums.SchemaEnum;

public class UpdateSchemaRequest<K> extends BaseRequest{
    String schemaId;
    K schema;

    public K getSchema() {
        return schema;
    }

    public void setSchema(K schema) {
        this.schema = schema;
    }

    public UpdateSchemaRequest(String requestId, SchemaEnum schemaEnum, String schemaId, K schema) {
        super(requestId, schemaEnum);
        this.schemaId = schemaId;
        this.schema = schema;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }
}
