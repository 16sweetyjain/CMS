package contentManagementSystem.controller;

import contentManagementSystem.model.request.CreateFaqSchemaRequestBody;
import contentManagementSystem.model.request.CreateHelpXSchemeRequestBody;
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
public class UpdateHelpXSchemaController {
    @Autowired
    GetSchemaFactory getSchemaFactory;

    @PutMapping(value = "/helpX/{helpXId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateSchemaResponse> updateHelpXSchema(@PathVariable String helpXId, @RequestBody CreateHelpXSchemeRequestBody createHelpXSchemeRequestBody, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        UpdateSchemaRequest updateSchemaRequest = new UpdateSchemaRequest(SchemaEnum.HELPX, headers.get("x-request-id"), helpXId);

        UpdateSchemaResponse updateSchemaResponse = new UpdateSchemaResponse();

        CrudSchemaInterface crudSchemaInterface = getSchemaFactory.createSchemaFactory(SchemaEnum.HELPX);
        try {
            updateSchemaResponse = (UpdateSchemaResponse) crudSchemaInterface.updateSchema(updateSchemaRequest);
            responseEntity = ResponseEntity.ok(updateSchemaResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
