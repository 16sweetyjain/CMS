package contentManagementSystem.controller.faq;

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
public class GetFaqSchemaController {
    @Autowired
    GetSchemaService getService;

    @GetMapping(value = "/faq/{faqId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetSchemaResponse> getFaqSchema(@PathVariable String faqId, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        GetSchemaRequest getSchemaRequest = new GetSchemaRequest(headers.get("x-request-id"), headers.get("x-gw-auth-id"), SchemaEnum.FAQSCHEMA ,faqId);
        getSchemaRequest.setHeaders(headers);
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
