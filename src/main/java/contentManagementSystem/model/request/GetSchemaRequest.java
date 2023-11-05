package contentManagementSystem.model.request;

public class GetSchemaRequest extends BaseRequest{
    String schemaId;
    public GetSchemaRequest(String selectedSchema, String requestId) {
        super(selectedSchema, requestId);
    }

    public GetSchemaRequest(String selectedSchema, String requestId, String schemaId) {
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
