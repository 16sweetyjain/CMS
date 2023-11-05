package contentManagementSystem.dal;

import contentManagementSystem.model.Faq;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FaqCustomRepository {
    public List<Faq> getAllFaq();
    public Faq addFaq(Faq faq);
    public Faq getFaq(String id);
    public Faq updateFaq(Faq faq);
}
