package contentManagementSystem.controller;

import contentManagementSystem.model.request.CreateFaqSchemaRequestBody;
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
public class UpdateFaqSchemaController {
    @Autowired
    UpdateSchemaService updateService;

    @PutMapping(value = "/faq/{faqId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateSchemaResponse> updateFaqSchema(@PathVariable String faqId, @RequestBody CreateFaqSchemaRequestBody createFaqSchemaRequestBody, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        UpdateSchemaRequest updateFaqSchemaRequest = new UpdateSchemaRequest(headers.get("x-request-id"), SchemaEnum.FAQSCHEMA, faqId, createFaqSchemaRequestBody);

        UpdateSchemaResponse updateSchemaResponse = new UpdateSchemaResponse();

        try {
            updateSchemaResponse = (UpdateSchemaResponse) updateService.driver(updateFaqSchemaRequest, updateSchemaResponse);
            responseEntity = ResponseEntity.ok(updateSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
