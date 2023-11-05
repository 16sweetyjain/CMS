package contentManagementSystem.model.response;

public class GetSchemaResponse<K> extends BaseResponse{
    K schema;

    public GetSchemaResponse(K schema) {
        this.schema = schema;
    }

    public GetSchemaResponse() {
    }

    public K getSchema() {
        return schema;
    }

    public void setSchema(K schema) {
        this.schema = schema;
    }
}
