package contentManagementSystem.dal.faq;

import contentManagementSystem.dal.faq.FaqCustomRepository;
import contentManagementSystem.model.Faq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FaqCustomRepositoryImpl implements FaqCustomRepository {

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
        Query query = new Query(Criteria.where("faqId").is(id));
        Faq faq =  mongoTemplate.findOne(query, Faq.class);
        return faq;
    }

    @Override
    public Faq updateFaq(Faq requestFaq, String faqId) {
        Query query = new Query(Criteria.where("faqId").is(faqId));
        Faq updatedFaq =  mongoTemplate.findOne(query, Faq.class);

        if(requestFaq.getDescription() != null && !requestFaq.getDescription().isEmpty()) {
            updatedFaq.setDescription(requestFaq.getDescription());
        }

        if(requestFaq.getTitle() != null && !requestFaq.getTitle().isEmpty() ) {
            updatedFaq.setTitle(requestFaq.getTitle());
        }

        return updatedFaq;
    }

}
