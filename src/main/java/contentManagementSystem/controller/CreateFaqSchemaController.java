package contentManagementSystem.controller;

import contentManagementSystem.model.request.CreateFaqSchemaRequest;
import contentManagementSystem.model.request.CreateFaqSchemaRequestBody;
import contentManagementSystem.model.response.CreateSchemaResponse;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.schemaEnum.SchemaEnum;
import contentManagementSystem.service.createSchema.CreateFaqSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CreateFaqSchemaController {
    @Autowired
    CreateFaqSchemaService createFaqSchemaService;

    @PostMapping(value = "/create/schema/faq", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAllSchemaResponse> getAllSchemaResponse(@RequestBody CreateFaqSchemaRequestBody createFaqSchemaRequestBody, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        CreateFaqSchemaRequest createFaqSchemaRequest = new CreateFaqSchemaRequest(SchemaEnum.FAQ, headers.get("x-request-id"), createFaqSchemaRequestBody.getDescription(), createFaqSchemaRequestBody.getTitle());

        CreateSchemaResponse createSchemaResponse = new CreateSchemaResponse();
        try {
            createSchemaResponse = createFaqSchemaService.driver(createFaqSchemaRequest, createSchemaResponse);
            responseEntity = ResponseEntity.ok(createSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
