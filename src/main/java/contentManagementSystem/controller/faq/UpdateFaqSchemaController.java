package contentManagementSystem.controller.faq;

import contentManagementSystem.model.request.updateRequest.UpdateFaqSchemaRequestBody;
import contentManagementSystem.model.request.updateRequest.UpdateFaqSchemaRequest;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "/faq/{faqId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UpdateSchemaResponse> updateFaqSchema(@PathVariable String faqId, @RequestBody UpdateFaqSchemaRequestBody updateFaqSchemaRequestBody, @RequestHeader Map<String, String> headers) throws Exception {

        ResponseEntity responseEntity = null;

        UpdateFaqSchemaRequest updateFaqSchemaRequest = new UpdateFaqSchemaRequest(headers.get("x-request-id"), headers.get("x-gw-auth-id"), SchemaEnum.FAQSCHEMA, faqId, updateFaqSchemaRequestBody.getTitle(), updateFaqSchemaRequestBody.getDescription());

        updateFaqSchemaRequest.setHeaders(headers);
        UpdateSchemaResponse updateSchemaResponse = new UpdateSchemaResponse();


            updateSchemaResponse = (UpdateSchemaResponse) updateService.driver(updateFaqSchemaRequest, updateSchemaResponse);
            responseEntity = ResponseEntity.ok(updateSchemaResponse);


        return responseEntity;
    }
}
