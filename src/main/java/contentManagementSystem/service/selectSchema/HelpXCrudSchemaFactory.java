package contentManagementSystem.service.selectSchema;

import contentManagementSystem.dal.HelpXCustomRepositoryImpl;
import contentManagementSystem.model.HelpX;
import contentManagementSystem.model.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class HelpXCrudSchemaFactory implements CrudSchemaInterface<HelpX> {

    @Autowired
    HelpXCustomRepositoryImpl helpXCustomRepository;

    @Override
    public HelpX getSchema(String schemaId) {
        return helpXCustomRepository.getHelpXArticle(schemaId);
    }

    @Override
    public HelpX createSchema(HelpX helpX) {
        return helpXCustomRepository.addHelpXArticle(helpX);
    }

    @Override
    public List<HelpX> getAllSchema() {
        return null;
    }

    @Override
    public HelpX updateSchema(HelpX helpX) {
        return null;
    }

    @Override
    public HelpX createSchemaFromRequest(BaseRequest baseRequest) {
        return null;
    }

}
