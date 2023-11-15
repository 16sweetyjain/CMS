package contentManagementSystem.controller.helpX;

import contentManagementSystem.model.request.createRequest.CreateHelpXSchemaRequest;
import contentManagementSystem.model.request.createRequest.CreateHelpXSchemeRequestBody;
import contentManagementSystem.model.response.CreateSchemaResponse;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.service.CreateSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CreateHelpXSchemaController {
    @Autowired
    CreateSchemaService createService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/helpX", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAllSchemaResponse> createHelpXSchema(@RequestBody CreateHelpXSchemeRequestBody createHelpXSchemeRequestBody, @RequestHeader Map<String, String> headers) throws Exception {

        ResponseEntity responseEntity = null;

        CreateHelpXSchemaRequest createHelpXSchemaRequest = new CreateHelpXSchemaRequest(headers.get("x-request-id"), headers.get("x-gw-auth-id"), SchemaEnum.HELPXSCHEMA, createHelpXSchemeRequestBody.getTitle(),createHelpXSchemeRequestBody.getSubTitle(), createHelpXSchemeRequestBody.getDescription(), createHelpXSchemeRequestBody.getImage(), createHelpXSchemeRequestBody.getParagraph());
        createHelpXSchemaRequest.setHeaders(headers);
        CreateSchemaResponse createSchemaResponse = new CreateSchemaResponse();


            createSchemaResponse = (CreateSchemaResponse) createService.driver(createHelpXSchemaRequest, createSchemaResponse);
            responseEntity = ResponseEntity.ok(createSchemaResponse);


        return responseEntity;
    }
}
