package contentManagementSystem.service.readSchema;

import contentManagementSystem.model.request.GetAllSchemaRequest;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.service.SchemaTemplate;
import contentManagementSystem.service.selectSchema.CrudSchemaInterface;
import org.springframework.stereotype.Service;

@Service
public class GetAllSchemaService extends SchemaTemplate<GetAllSchemaRequest, GetAllSchemaResponse> {
    @Override
    protected GetAllSchemaResponse process(GetAllSchemaRequest request, GetAllSchemaResponse response, CrudSchemaInterface schemaInterface) {

        response.setSchemaList(schemaInterface.getAllSchema());

        return response;
    }

    @Override
    protected GetAllSchemaResponse postprocess(GetAllSchemaRequest request) {
        return null;
    }
}
