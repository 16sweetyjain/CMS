package contentManagementSystem.controller;

import contentManagementSystem.model.request.CreateFaqSchemaRequestBody;
import contentManagementSystem.model.request.UpdateSchemaRequest;
import contentManagementSystem.model.response.CreateSchemaResponse;
import contentManagementSystem.model.response.UpdateSchemaResponse;
import contentManagementSystem.schemaEnum.SchemaEnum;
import contentManagementSystem.service.selectSchema.CrudSchemaInterface;
import contentManagementSystem.service.selectSchema.GetSchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UpdateFaqSchemaController {
    @Autowired
    GetSchemaFactory getSchemaFactory;

    @PutMapping(value = "/faq/{faqId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateSchemaResponse> updateFaqSchema(@PathVariable String faqId, @RequestBody CreateFaqSchemaRequestBody createFaqSchemaRequestBody, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        UpdateSchemaRequest updateFaqSchemaRequest = new UpdateSchemaRequest(SchemaEnum.FAQ, headers.get("x-request-id"), faqId);

        UpdateSchemaResponse updateSchemaResponse = new UpdateSchemaResponse();

        CrudSchemaInterface crudSchemaInterface = getSchemaFactory.createSchemaFactory(SchemaEnum.FAQ);
        try {
            updateSchemaResponse = (UpdateSchemaResponse) crudSchemaInterface.updateSchema(updateFaqSchemaRequest);
            responseEntity = ResponseEntity.ok(updateSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
