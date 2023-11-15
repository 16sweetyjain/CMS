package contentManagementSystem.controller.faq;

import contentManagementSystem.model.request.createRequest.CreateFaqSchemaRequest;
import contentManagementSystem.model.request.createRequest.CreateFaqSchemaRequestBody;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/faq", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateSchemaResponse> createFaqSchema(@RequestBody CreateFaqSchemaRequestBody createFaqSchemaRequestBody, @RequestHeader Map<String, String> headers) throws Exception {

        ResponseEntity responseEntity = null;

        CreateFaqSchemaRequest createFaqSchemaRequest = new CreateFaqSchemaRequest(headers.get("x-request-id"),headers.get("x-gw-auth-id"), SchemaEnum.FAQSCHEMA,  createFaqSchemaRequestBody.getDescription(), createFaqSchemaRequestBody.getTitle());
        createFaqSchemaRequest.setHeaders(headers);
        CreateSchemaResponse createSchemaResponse = new CreateSchemaResponse();

        createSchemaResponse = (CreateSchemaResponse) createService.driver(createFaqSchemaRequest, createSchemaResponse);
        responseEntity = ResponseEntity.ok(createSchemaResponse);


        return responseEntity;
    }
}
