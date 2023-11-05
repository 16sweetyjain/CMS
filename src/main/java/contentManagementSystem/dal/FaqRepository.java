package contentManagementSystem.dal;

import contentManagementSystem.model.Faq;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FaqRepository extends MongoRepository<Faq, String> {
}
