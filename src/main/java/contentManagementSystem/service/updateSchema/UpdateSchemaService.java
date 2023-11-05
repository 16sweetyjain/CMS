package contentManagementSystem.service.updateSchema;

import contentManagementSystem.model.request.GetAllSchemaRequest;
import contentManagementSystem.model.request.UpdateSchemaRequest;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.model.response.UpdateSchemaResponse;
import contentManagementSystem.service.SchemaTemplate;
import contentManagementSystem.service.selectSchema.CrudSchemaInterface;

public class UpdateSchemaService extends SchemaTemplate<UpdateSchemaRequest, UpdateSchemaResponse> {
    @Override
    protected UpdateSchemaResponse process(UpdateSchemaRequest request, UpdateSchemaResponse response, CrudSchemaInterface schemaInterface) {
        response.setSchema(schemaInterface.updateSchema(request.getSchemaId()));

        return response;
    }

    @Override
    protected UpdateSchemaResponse postprocess(UpdateSchemaRequest request) {
        return null;
    }
}
