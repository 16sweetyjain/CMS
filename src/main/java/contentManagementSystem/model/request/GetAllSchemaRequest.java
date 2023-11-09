package contentManagementSystem.model.request;

import contentManagementSystem.enums.SchemaEnum;

import java.util.List;

public class GetAllSchemaRequest<K> extends BaseRequest{
    public GetAllSchemaRequest(String requestId, SchemaEnum schemaEnum) {
        super(requestId, schemaEnum);
    }
}
