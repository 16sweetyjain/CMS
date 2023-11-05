package contentManagementSystem.service.createSchema;

import contentManagementSystem.dal.HelpXCustomRepositoryImpl;
import contentManagementSystem.model.HelpX;
import contentManagementSystem.model.request.CreateHelpXSchemaRequest;
import contentManagementSystem.model.response.CreateSchemaResponse;
import contentManagementSystem.service.SchemaTemplate;
import contentManagementSystem.service.selectSchema.CrudSchemaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateHelpXSchemaService extends SchemaTemplate<CreateHelpXSchemaRequest, CreateSchemaResponse> {

    @Autowired
    HelpXCustomRepositoryImpl helpXCustomRepository;

    @Override
    protected CreateSchemaResponse process(CreateHelpXSchemaRequest request, CreateSchemaResponse response, CrudSchemaInterface crudSchemaInterface) {
        String helpXId = UUID.randomUUID().toString();
        HelpX helpX = new HelpX(helpXId, request.getTitle(),request.getSubTitle(), request.getDescription(), request.getImage(), request.getParagraph());
        crudSchemaInterface.createSchema(helpX);

        response.setSchemaId(helpXId);
        return response;
    }

    @Override
    protected CreateSchemaResponse postprocess(CreateHelpXSchemaRequest request) {
        return null;
    }
}
