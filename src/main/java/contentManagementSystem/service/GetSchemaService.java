package contentManagementSystem.service;

import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.request.BaseSchemaRequest;
import contentManagementSystem.model.response.BaseResponse;
import contentManagementSystem.model.response.GetSchemaResponse;
import contentManagementSystem.service.factory.CrudInterface;
import contentManagementSystem.service.factory.GetSchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetSchemaService extends SchemaTemplate<BaseSchemaRequest, BaseResponse> {

    @Autowired
    GetSchemaFactory getSchemaFactory;

    @Override
    protected BaseResponse process(BaseSchemaRequest request, BaseResponse response) {
        CrudInterface crudSchemaInterface = getSchemaFactory.findStrategy(request.getSchemaEnum());

        GetSchemaResponse getSchemaResponse = (GetSchemaResponse) crudSchemaInterface.getSchema(request);

        return getSchemaResponse;
    }

    @Override
    protected BaseResponse postprocess(BaseSchemaRequest request) {
        return null;
    }
}
