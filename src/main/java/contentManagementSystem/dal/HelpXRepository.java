package contentManagementSystem.dal;

import contentManagementSystem.model.HelpX;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HelpXRepository extends MongoRepository<HelpX, String> {
}
