package contentManagementSystem.model.response;

public class UpdateSchemaResponse<K> extends BaseResponse{
    K schema;

    public UpdateSchemaResponse() {
    }

    public K getSchema() {
        return schema;
    }

    public void setSchema(K schema) {
        this.schema = schema;
    }

    public UpdateSchemaResponse(K schema) {
        this.schema = schema;
    }
}