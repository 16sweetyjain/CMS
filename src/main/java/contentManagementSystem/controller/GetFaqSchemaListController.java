package contentManagementSystem.controller;

import contentManagementSystem.model.request.GetAllSchemaRequest;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.model.response.GetSchemaResponse;
import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.service.GetSchemaListService;
import contentManagementSystem.service.factory.CrudSchemaInterface;
import contentManagementSystem.service.factory.GetSchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetFaqSchemaListController {
    @Autowired
    GetSchemaListService getSchemaListService;

    @GetMapping(value = "/faq", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetSchemaResponse> getFaqSchemaList(@RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        GetAllSchemaRequest getAllSchemaRequest = new GetAllSchemaRequest(headers.get("x-request-id"), SchemaEnum.FAQSCHEMA);

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
