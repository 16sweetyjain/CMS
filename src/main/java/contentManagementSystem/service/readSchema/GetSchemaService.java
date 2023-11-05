package contentManagementSystem.service.readSchema;

import contentManagementSystem.model.request.GetSchemaRequest;
import contentManagementSystem.model.response.GetSchemaResponse;
import contentManagementSystem.service.SchemaTemplate;
import contentManagementSystem.service.selectSchema.CrudSchemaInterface;
import org.springframework.stereotype.Service;

@Service
public class GetSchemaService extends SchemaTemplate<GetSchemaRequest, GetSchemaResponse> {
    @Override
    protected GetSchemaResponse process(GetSchemaRequest request, GetSchemaResponse response, CrudSchemaInterface schemaInterface) {

        response.setSchema(schemaInterface.getSchema(request.getSchemaId()));

        return response;
    }

    @Override
    protected GetSchemaResponse postprocess(GetSchemaRequest request) {
        return null;
    }
}
