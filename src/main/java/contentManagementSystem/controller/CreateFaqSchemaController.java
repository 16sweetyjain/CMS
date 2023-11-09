package contentManagementSystem.controller;

import contentManagementSystem.model.request.CreateFaqSchemaRequest;
import contentManagementSystem.model.request.CreateFaqSchemaRequestBody;
import contentManagementSystem.model.response.CreateSchemaResponse;
import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.service.CreateSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CreateFaqSchemaController {
    @Autowired
    CreateSchemaService createService;

    @PostMapping(value = "/faq", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateSchemaResponse> createFaqSchema(@RequestBody CreateFaqSchemaRequestBody createFaqSchemaRequestBody, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        CreateFaqSchemaRequest createFaqSchemaRequest = new CreateFaqSchemaRequest(headers.get("x-request-id"),SchemaEnum.FAQSCHEMA,  createFaqSchemaRequestBody.getDescription(), createFaqSchemaRequestBody.getTitle());

        CreateSchemaResponse createSchemaResponse = new CreateSchemaResponse();

        try {
            createSchemaResponse = (CreateSchemaResponse) createService.driver(createFaqSchemaRequest, createSchemaResponse);
            responseEntity = ResponseEntity.ok(createSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
