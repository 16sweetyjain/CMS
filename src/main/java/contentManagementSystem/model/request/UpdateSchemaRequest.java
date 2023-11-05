package contentManagementSystem.model.request;

public class UpdateSchemaRequest extends BaseRequest{
    String schemaId;

    public UpdateSchemaRequest(String selectedSchema, String requestId) {
        super(selectedSchema, requestId);
    }

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }
}
