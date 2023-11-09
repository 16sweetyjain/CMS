package contentManagementSystem.controller;

import contentManagementSystem.model.request.GetSchemaRequest;
import contentManagementSystem.model.response.GetSchemaResponse;
import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.service.GetSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetHelpXSchemaController {
    @Autowired
    GetSchemaService getService;

    @GetMapping(value = "/helpX/{helpXId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetSchemaResponse> getHelpXSchema(@PathVariable String helpXId, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;


        GetSchemaRequest getSchemaRequest = new GetSchemaRequest(headers.get("x-request-id"), SchemaEnum.HELPXSCHEMA ,helpXId);

        GetSchemaResponse getSchemaResponse = new GetSchemaResponse();
        try {
            getSchemaResponse = (GetSchemaResponse) getService.driver(getSchemaRequest, getSchemaResponse);
            responseEntity = ResponseEntity.ok(getSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}