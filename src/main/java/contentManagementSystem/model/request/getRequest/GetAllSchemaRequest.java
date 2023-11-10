package contentManagementSystem.model.request.getRequest;

import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.request.BaseSchemaRequest;

import java.util.List;

public class GetAllSchemaRequest<K> extends BaseSchemaRequest {
    public GetAllSchemaRequest(String requestId, String userId, SchemaEnum schemaEnum) {
        super(requestId, userId, schemaEnum);
    }
}
