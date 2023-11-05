package contentManagementSystem.service;

import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.response.BaseResponse;
import contentManagementSystem.service.selectSchema.CrudSchemaInterface;
import contentManagementSystem.service.selectSchema.SchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class SchemaTemplate<T extends BaseRequest, K extends BaseResponse> {

    @Autowired
    SchemaFactory schemaFactory;

    public K driver(T request, K response) {

        //validate request user
        validate(request, response);

        //preproces the request
        CrudSchemaInterface crudSchemaInterface = preprocess(request, response);

        //perform business logic
        process(request, response, crudSchemaInterface);

        //post processing of request i.e., sending analytics or others
        postprocess(request);

        return response;
    }

    protected  K validate(T request, K response) {
        return null;
    }

    protected CrudSchemaInterface preprocess(T request, K response) {
        CrudSchemaInterface schemaInterface = schemaFactory.createSchemaFactory(request.getSelectedSchema());

        return schemaInterface;
    }

    protected abstract K process(T request, K response, CrudSchemaInterface schemaInterface);

    protected abstract K postprocess(T request);


}
