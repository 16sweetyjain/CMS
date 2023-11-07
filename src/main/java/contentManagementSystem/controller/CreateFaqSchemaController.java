package contentManagementSystem.controller;

import contentManagementSystem.model.request.CreateFaqSchemaRequest;
import contentManagementSystem.model.request.CreateFaqSchemaRequestBody;
import contentManagementSystem.model.response.CreateSchemaResponse;
import contentManagementSystem.schemaEnum.SchemaEnum;
import contentManagementSystem.service.selectSchema.CrudSchemaInterface;
import contentManagementSystem.service.selectSchema.GetSchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CreateFaqSchemaController {
    @Autowired
    GetSchemaFactory getSchemaFactory;

    @PostMapping(value = "/faq", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateSchemaResponse> createFaqSchema(@RequestBody CreateFaqSchemaRequestBody createFaqSchemaRequestBody, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        CreateFaqSchemaRequest createFaqSchemaRequest = new CreateFaqSchemaRequest(SchemaEnum.FAQ, headers.get("x-request-id"), createFaqSchemaRequestBody.getDescription(), createFaqSchemaRequestBody.getTitle());

        CreateSchemaResponse createSchemaResponse = new CreateSchemaResponse();

        CrudSchemaInterface crudSchemaInterface = getSchemaFactory.createSchemaFactory(SchemaEnum.FAQ);
        try {
            createSchemaResponse = (CreateSchemaResponse) crudSchemaInterface.createSchema(createFaqSchemaRequest);
            responseEntity = ResponseEntity.ok(createSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
