package contentManagementSystem.controller.helpX;

import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.model.request.getRequest.GetAllSchemaRequest;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.model.response.GetSchemaResponse;
import contentManagementSystem.service.GetSchemaListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;



@RestController
public class GetHelpXSchemaListController {

    @Autowired
    GetSchemaListService getSchemaListService;

    @GetMapping(value = "/helpX", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetSchemaResponse> getHelpXSchemaList(@RequestHeader Map<String, String> headers) {

            ResponseEntity responseEntity = null;

            GetAllSchemaRequest getAllSchemaRequest = new GetAllSchemaRequest(headers.get("x-request-id"), headers.get("x-gw-auth-id"), SchemaEnum.HELPXSCHEMA);

            getAllSchemaRequest.setHeaders(headers);
            GetAllSchemaResponse getAllSchemaResponse = new GetAllSchemaResponse();
            try {
                getAllSchemaResponse = (GetAllSchemaResponse) getSchemaListService.driver(getAllSchemaRequest, getAllSchemaResponse);
                responseEntity = ResponseEntity.ok(getAllSchemaResponse);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return responseEntity;
    }
}

