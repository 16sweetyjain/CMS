package contentManagementSystem.controller.helpX;

import contentManagementSystem.model.request.updateRequest.UpdateHelpXSchemaRequest;
import contentManagementSystem.model.request.updateRequest.UpdateHelpXSchemaRequestBody;
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

        UpdateHelpXSchemaRequest updateSchemaRequest = new UpdateHelpXSchemaRequest(headers.get("x-request-id"), headers.get("x-gw-auth-id"), SchemaEnum.HELPXSCHEMA, helpXId, updateHelpXSchemaRequestBody.getTitle(), updateHelpXSchemaRequestBody.getSubTitle(), updateHelpXSchemaRequestBody.getDescription(), updateHelpXSchemaRequestBody.getImage(), updateHelpXSchemaRequestBody.getParagraph());

        updateSchemaRequest.setHeaders(headers);
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
