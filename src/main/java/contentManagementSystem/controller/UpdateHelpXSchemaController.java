package contentManagementSystem.controller;

import contentManagementSystem.model.request.CreateHelpXSchemeRequestBody;
import contentManagementSystem.model.request.UpdateHelpXSchemaRequestBody;
import contentManagementSystem.model.request.UpdateSchemaRequest;
import contentManagementSystem.model.response.CreateSchemaResponse;
import contentManagementSystem.model.response.UpdateSchemaResponse;
import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.service.UpdateSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UpdateHelpXSchemaController {
    @Autowired
    UpdateSchemaService updateService;

    @PutMapping(value = "/helpX/{helpXId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UpdateSchemaResponse> updateHelpXSchema(@PathVariable String helpXId, @RequestBody UpdateHelpXSchemaRequestBody updateHelpXSchemaRequestBody, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        UpdateSchemaRequest updateSchemaRequest = new UpdateSchemaRequest(headers.get("x-request-id"), SchemaEnum.HELPXSCHEMA, helpXId, updateHelpXSchemaRequestBody);

        UpdateSchemaResponse updateSchemaResponse = new UpdateSchemaResponse();

        try {
            updateSchemaResponse = (UpdateSchemaResponse) updateService.driver(updateSchemaRequest, updateSchemaResponse);
            responseEntity = ResponseEntity.ok(updateSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
