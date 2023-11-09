package contentManagementSystem.service;

import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.response.BaseResponse;
import contentManagementSystem.model.response.CreateSchemaResponse;
import contentManagementSystem.service.factory.CrudSchemaInterface;
import contentManagementSystem.service.factory.GetSchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSchemaService extends SchemaTemplate<BaseRequest, BaseResponse> {

    @Autowired
    GetSchemaFactory getSchemaFactory;
    @Override
    protected BaseResponse process(BaseRequest request, BaseResponse response) {

        CrudSchemaInterface crudSchemaInterface = getSchemaFactory.findStrategy(request.getSchemaEnum());

        CreateSchemaResponse createSchemaResponse = (CreateSchemaResponse) crudSchemaInterface.createSchema(request);

        return createSchemaResponse;
    }

    @Override
    protected BaseResponse postprocess(BaseRequest request) {
        return null;
    }
}
