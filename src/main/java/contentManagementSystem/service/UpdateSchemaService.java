package contentManagementSystem.service;

import contentManagementSystem.exception.BadRequestException;
import contentManagementSystem.exception.InternalServerError;
import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.request.BaseSchemaRequest;
import contentManagementSystem.model.response.BaseResponse;
import contentManagementSystem.model.response.UpdateSchemaResponse;
import contentManagementSystem.service.factory.CrudInterface;
import contentManagementSystem.service.factory.GetSchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateSchemaService extends SchemaTemplate<BaseSchemaRequest, BaseResponse>{

    @Autowired
    GetSchemaFactory getSchemaFactory;

    @Override
    protected BaseResponse process(BaseSchemaRequest request, BaseResponse response) throws InternalServerError, BadRequestException {
        CrudInterface crudSchemaInterface = getSchemaFactory.findStrategy(request.getSchemaEnum());

        UpdateSchemaResponse updateSchemaResponse = (UpdateSchemaResponse) crudSchemaInterface.updateSchema(request);
        return updateSchemaResponse;
    }

    @Override
    protected BaseResponse postprocess(BaseSchemaRequest request) {
        return null;
    }
}
