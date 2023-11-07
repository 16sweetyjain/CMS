package contentManagementSystem.controller;

import contentManagementSystem.model.request.GetAllSchemaRequest;
import contentManagementSystem.model.request.GetSchemaRequest;
import contentManagementSystem.model.response.GetSchemaResponse;
import contentManagementSystem.schemaEnum.SchemaEnum;
import contentManagementSystem.service.selectSchema.CrudSchemaInterface;
import contentManagementSystem.service.selectSchema.GetSchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetAllFaqSchemaController {
    @Autowired
    GetSchemaFactory getSchemaFactory;

    @GetMapping(value = "/faq", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetSchemaResponse> getFaqSchema(@RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        CrudSchemaInterface crudSchemaInterface = getSchemaFactory.createSchemaFactory(SchemaEnum.FAQ);

        GetAllSchemaRequest getAllSchemaRequest = new GetAllSchemaRequest(SchemaEnum.FAQ, headers.get("x-request-id"));

        GetSchemaResponse getSchemaResponse = new GetSchemaResponse();
        try {
            getSchemaResponse = (GetSchemaResponse) crudSchemaInterface.getSchema(getAllSchemaRequest);
            responseEntity = ResponseEntity.ok(getSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
