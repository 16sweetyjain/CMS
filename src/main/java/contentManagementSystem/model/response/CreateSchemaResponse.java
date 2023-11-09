package contentManagementSystem.model.response;

public class CreateSchemaResponse extends BaseResponse {
    String schemaId;

    public CreateSchemaResponse(String schemaId) {
        this.schemaId = schemaId;
    }

    public CreateSchemaResponse() {
    }

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    @Override
    public String toString() {
        return "CreateSchemaResponse{" +
                "schemaId='" + schemaId + '\'' +
                "} " + super.toString();
    }
}
