package contentManagementSystem.service;

import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.response.BaseResponse;
import contentManagementSystem.service.factory.GetSchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class SchemaTemplate<T extends BaseRequest, K extends BaseResponse> {

    public K driver(T request, K response) {

        //validate request user
        validate(request, response);

        //perform business logic
        response = process(request, response);

        //post processing of request i.e., sending analytics or others
        postprocess(request);

        return response;
    }

    protected  K validate(T request, K response) {
        return null;
    }

    protected abstract K process(T request, K response);

    protected abstract K postprocess(T request);


}
