package contentManagementSystem.service.createSchema;

import contentManagementSystem.model.Faq;
import contentManagementSystem.model.request.CreateFaqSchemaRequest;
import contentManagementSystem.model.response.CreateSchemaResponse;
import contentManagementSystem.service.SchemaTemplate;
import contentManagementSystem.service.selectSchema.CrudSchemaInterface;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateFaqSchemaService extends SchemaTemplate<CreateFaqSchemaRequest, CreateSchemaResponse> {

    @Override
    protected CreateSchemaResponse process(CreateFaqSchemaRequest request, CreateSchemaResponse response, CrudSchemaInterface crudSchemaInterface) {
        String faqId = UUID.randomUUID().toString();
        Faq faq = new Faq(faqId, request.getTitle(), request.getDescription());

        crudSchemaInterface.createSchema(faq);

        response.setSchemaId(faqId);
        return response;
    }

    @Override
    protected CreateSchemaResponse postprocess(CreateFaqSchemaRequest request) {
        return null;
    }
}
