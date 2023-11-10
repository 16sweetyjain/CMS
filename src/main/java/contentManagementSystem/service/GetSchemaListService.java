package contentManagementSystem.service;

import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.request.BaseSchemaRequest;
import contentManagementSystem.model.response.BaseResponse;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.service.factory.CrudInterface;
import contentManagementSystem.service.factory.GetSchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetSchemaListService extends SchemaTemplate<BaseSchemaRequest, BaseResponse> {

    @Autowired
    GetSchemaFactory getSchemaFactory;

    @Override
    protected BaseResponse process(BaseSchemaRequest request, BaseResponse response) {
        CrudInterface crudSchemaInterface = getSchemaFactory.findStrategy(request.getSchemaEnum());

        GetAllSchemaResponse getAllSchemaResponse = (GetAllSchemaResponse) crudSchemaInterface.getAllSchema(request);
        return getAllSchemaResponse;
    }


    @Override
    protected BaseResponse postprocess(BaseSchemaRequest request) {
        return null;
    }
}
