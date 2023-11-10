package contentManagementSystem.model.request.getRequest;

import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.model.request.BaseRequest;

import java.util.List;

public class GetAllSchemaRequest<K> extends BaseRequest {
    public GetAllSchemaRequest(String requestId, SchemaEnum schemaEnum) {
        super(requestId, schemaEnum);
    }
}
