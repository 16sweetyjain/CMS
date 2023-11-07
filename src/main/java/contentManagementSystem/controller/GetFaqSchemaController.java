package contentManagementSystem.controller;

import contentManagementSystem.model.request.GetSchemaRequest;
import contentManagementSystem.model.response.GetSchemaResponse;
import contentManagementSystem.schemaEnum.SchemaEnum;
import contentManagementSystem.service.selectSchema.CrudSchemaInterface;
import contentManagementSystem.service.selectSchema.GetSchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GetFaqSchemaController {
    @Autowired
    GetSchemaFactory getSchemaFactory;

    @GetMapping(value = "/faq/{faqId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetSchemaResponse> getFaqSchema(@PathVariable String faqId, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        CrudSchemaInterface crudSchemaInterface = getSchemaFactory.createSchemaFactory(SchemaEnum.FAQ);

        GetSchemaRequest getSchemaRequest = new GetSchemaRequest(headers.get("x-request-id"), faqId);

        GetSchemaResponse getSchemaResponse = new GetSchemaResponse();
        try {
            getSchemaResponse = (GetSchemaResponse) crudSchemaInterface.getSchema(getSchemaRequest);
            responseEntity = ResponseEntity.ok(getSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
