package contentManagementSystem.controller;

import contentManagementSystem.model.request.CreateFaqSchemaRequest;
import contentManagementSystem.model.request.CreateHelpXSchemaRequest;
import contentManagementSystem.model.request.CreateHelpXSchemeRequestBody;
import contentManagementSystem.model.response.CreateSchemaResponse;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.schemaEnum.SchemaEnum;
import contentManagementSystem.service.selectSchema.CrudSchemaInterface;
import contentManagementSystem.service.selectSchema.GetSchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CreateHelpXSchemaController {
    @Autowired
    GetSchemaFactory getSchemaFactory;

    @PostMapping(value = "/helpX", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAllSchemaResponse> createHelpXSchema(@RequestBody CreateHelpXSchemeRequestBody createHelpXSchemeRequestBody, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        CreateHelpXSchemaRequest createHelpXSchemaRequest = new CreateHelpXSchemaRequest(SchemaEnum.HELPX, headers.get("x-request-id"), createHelpXSchemeRequestBody.getTitle(),createHelpXSchemeRequestBody.getSubTitle(), createHelpXSchemeRequestBody.getDescription(), createHelpXSchemeRequestBody.getImage(), createHelpXSchemeRequestBody.getParagraph());

        CreateSchemaResponse createSchemaResponse = new CreateSchemaResponse();

        CrudSchemaInterface crudSchemaInterface = getSchemaFactory.createSchemaFactory(SchemaEnum.FAQ);
        try {
            createSchemaResponse = (CreateSchemaResponse) crudSchemaInterface.createSchema(createHelpXSchemaRequest);
            responseEntity = ResponseEntity.ok(createSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
