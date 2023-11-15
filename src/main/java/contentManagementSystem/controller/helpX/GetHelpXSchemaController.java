package contentManagementSystem.controller.helpX;

import contentManagementSystem.model.request.getRequest.GetSchemaRequest;
import contentManagementSystem.model.response.GetSchemaResponse;
import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.service.GetSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GetHelpXSchemaController {
    @Autowired
    GetSchemaService getService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/helpX/{helpXId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetSchemaResponse> getHelpXSchema(@PathVariable String helpXId, @RequestHeader Map<String, String> headers) throws Exception {

        ResponseEntity responseEntity = null;


        GetSchemaRequest getSchemaRequest = new GetSchemaRequest(headers.get("x-request-id"), headers.get("x-gw-auth-id"), SchemaEnum.HELPXSCHEMA ,helpXId);

        getSchemaRequest.setHeaders(headers);
        GetSchemaResponse getSchemaResponse = new GetSchemaResponse();

            getSchemaResponse = (GetSchemaResponse) getService.driver(getSchemaRequest, getSchemaResponse);
            responseEntity = ResponseEntity.ok(getSchemaResponse);


        return responseEntity;
    }
}