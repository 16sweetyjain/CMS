package contentManagementSystem.controller;

import contentManagementSystem.model.request.GetAllSchemaRequest;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.service.readSchema.GetAllSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetAllSchemaController {
    @Autowired
    GetAllSchemaService getAllSchemaService;

    @GetMapping(value = "/getAllSchema", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAllSchemaResponse> getAllSchemaResponse(@RequestParam String selectedSchema, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        GetAllSchemaRequest getAllSchemaRequest = new GetAllSchemaRequest(selectedSchema, headers.get("x-request-id"));

        GetAllSchemaResponse getAllSchemaResponse = new GetAllSchemaResponse();
        try {
            getAllSchemaResponse = getAllSchemaService.driver(getAllSchemaRequest, getAllSchemaResponse);
            responseEntity = ResponseEntity.ok(getAllSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
