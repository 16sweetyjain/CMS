package contentManagementSystem.dal;

import contentManagementSystem.model.Faq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FaqCustomRepositoryImpl implements FaqCustomRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Faq> getAllFaq() {
        return mongoTemplate.findAll(Faq.class);
    }

    @Override
    public Faq addFaq(Faq faq) {
        Faq addedFaq = mongoTemplate.insert(faq, "Faq");

        return addedFaq;
    }

    @Override
    public Faq getFaq(String id) {
        Query query = new Query();
        query.addCriteria(new Criteria("schemaId").is(id));

        return mongoTemplate.findOne(query, Faq.class);
    }

    @Override
    public Faq updateFaq(Faq faq) {
        return null;
    }

}
