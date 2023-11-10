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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CreateHelpXSchemaController {
    @Autowired
    CreateSchemaService createService;

    @PostMapping(value = "/helpX", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAllSchemaResponse> createHelpXSchema(@RequestBody CreateHelpXSchemeRequestBody createHelpXSchemeRequestBody, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        CreateHelpXSchemaRequest createHelpXSchemaRequest = new CreateHelpXSchemaRequest(headers.get("x-request-id"),SchemaEnum.HELPXSCHEMA, createHelpXSchemeRequestBody.getTitle(),createHelpXSchemeRequestBody.getSubTitle(), createHelpXSchemeRequestBody.getDescription(), createHelpXSchemeRequestBody.getImage(), createHelpXSchemeRequestBody.getParagraph());

        CreateSchemaResponse createSchemaResponse = new CreateSchemaResponse();

        try {
            createSchemaResponse = (CreateSchemaResponse) createService.driver(createHelpXSchemaRequest, createSchemaResponse);
            responseEntity = ResponseEntity.ok(createSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
