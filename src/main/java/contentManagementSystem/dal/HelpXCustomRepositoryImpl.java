package contentManagementSystem.dal;

import contentManagementSystem.model.HelpX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class HelpXCustomRepositoryImpl implements HelpXCustomRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<HelpX> getAllHelpXArticle() {
        return mongoTemplate.findAll(HelpX.class);
    }

    @Override
    public HelpX addHelpXArticle(HelpX helpX) {
        HelpX addedHelpX = mongoTemplate.insert(helpX, "HelpX");

        return addedHelpX;
    }

    @Override
    public HelpX updateHelpXArticle(HelpX helpX) {
        return null;
    }

    @Override
    public HelpX getHelpXArticle(String id) {
        Query query = new Query();
        query.addCriteria(new Criteria("schemaId").is(id));

        return mongoTemplate.findOne(query, HelpX.class);
    }
}
