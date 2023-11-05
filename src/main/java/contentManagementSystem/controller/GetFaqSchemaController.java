package contentManagementSystem.controller;

import contentManagementSystem.model.request.GetSchemaRequest;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.model.response.GetSchemaResponse;
import contentManagementSystem.service.readSchema.GetSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GetFaqSchemaController {
    @Autowired
    GetSchemaService getSchemaService;

    @GetMapping(value = "/getSchema/{schemaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAllSchemaResponse> getAllSchemaResponse(@RequestParam String selectedSchema, @PathVariable String schemaId, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        GetSchemaRequest getSchemaRequest = new GetSchemaRequest(selectedSchema, headers.get("x-request-id"), schemaId);


        GetSchemaResponse getSchemaResponse = new GetSchemaResponse();
        try {
            getSchemaResponse = getSchemaService.driver(getSchemaRequest, getSchemaResponse);
            responseEntity = ResponseEntity.ok(getSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
