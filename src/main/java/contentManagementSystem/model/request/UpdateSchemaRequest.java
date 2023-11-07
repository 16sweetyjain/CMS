package contentManagementSystem.model.request;

public class UpdateSchemaRequest<K> extends BaseRequest{
    String schemaId;
    K schema;

    public K getSchema() {
        return schema;
    }

    public void setSchema(K schema) {
        this.schema = schema;
    }

    public UpdateSchemaRequest(String selectedSchema, String requestId) {
        super(selectedSchema, requestId);
    }

    public UpdateSchemaRequest(String selectedSchema, String requestId, String schemaId) {
        super(selectedSchema, requestId);
        this.schemaId = schemaId;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }
}
