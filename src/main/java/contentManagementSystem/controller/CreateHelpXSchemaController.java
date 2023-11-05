package contentManagementSystem.controller;

import contentManagementSystem.model.request.CreateHelpXSchemaRequest;
import contentManagementSystem.model.request.CreateHelpXSchemeRequestBody;
import contentManagementSystem.model.response.CreateSchemaResponse;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.schemaEnum.SchemaEnum;
import contentManagementSystem.service.createSchema.CreateHelpXSchemaService;
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
    CreateHelpXSchemaService createHelpXSchemaService;

    @PostMapping(value = "/create/schema/helpX", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAllSchemaResponse> getAllSchemaResponse(@RequestBody CreateHelpXSchemeRequestBody createHelpXSchemeRequestBody, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        CreateHelpXSchemaRequest createHelpXSchemaRequest = new CreateHelpXSchemaRequest(SchemaEnum.HELPX, headers.get("x-request-id"), createHelpXSchemeRequestBody.getTitle(),createHelpXSchemeRequestBody.getSubTitle(), createHelpXSchemeRequestBody.getDescription(), createHelpXSchemeRequestBody.getImage(), createHelpXSchemeRequestBody.getParagraph());

        CreateSchemaResponse createSchemaResponse = new CreateSchemaResponse();
        try {
            createSchemaResponse = createHelpXSchemaService.driver(createHelpXSchemaRequest, createSchemaResponse);
            responseEntity = ResponseEntity.ok(createSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
