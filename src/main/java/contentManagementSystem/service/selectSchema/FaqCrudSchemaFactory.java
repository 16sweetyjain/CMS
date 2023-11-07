package contentManagementSystem.service.selectSchema;


import contentManagementSystem.dal.FaqCustomRepositoryImpl;
import contentManagementSystem.model.Faq;
import contentManagementSystem.model.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqCrudSchemaFactory implements CrudSchemaInterface<Faq> {

    @Autowired
    private FaqCustomRepositoryImpl faqCustomRepository;

    public FaqCrudSchemaFactory() {
    }


    @Override
    public Faq getSchema(String schemaId) {
        return faqCustomRepository.getFaq(schemaId);
    }

    @Override
    public Faq createSchema(Faq faq) {
        return faqCustomRepository.addFaq(faq);
    }

    @Override
    public List<Faq> getAllSchema() {
        return null;
    }

    @Override
    public Faq updateSchema(Faq faq) {
        return null;
    }

    @Override
    public Faq createSchemaFromRequest(BaseRequest baseRequest) {
        return null;
    }
}
