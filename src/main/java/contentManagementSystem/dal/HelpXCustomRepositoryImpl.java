package contentManagementSystem.dal;

import contentManagementSystem.model.Faq;
import contentManagementSystem.model.HelpX;
import contentManagementSystem.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
    public HelpX updateHelpXArticle(HelpX requestedHelpX, String helpXId) {
        Query query = new Query(Criteria.where("schemaId").is(helpXId));
        HelpX updatedHelpX =  mongoTemplate.findOne(query, HelpX.class);

        if(requestedHelpX.getDescription() != null && !requestedHelpX.getDescription().isEmpty()) {
            updatedHelpX.setDescription(requestedHelpX.getDescription());
        }

        if(requestedHelpX.getTitle() != null && !requestedHelpX.getTitle().isEmpty()) {
            updatedHelpX.setTitle(requestedHelpX.getTitle());
        }

        if(requestedHelpX.getParagraph() != null && !requestedHelpX.getParagraph().isEmpty()) {
            updatedHelpX.setParagraph(requestedHelpX.getParagraph());
        }

        Image updatedImage = updatedHelpX.getImage();

        if(requestedHelpX.getImage() != null && requestedHelpX.getImage().getImageURL() != null && !requestedHelpX.getImage().getImageURL().isEmpty() )  {
            updatedImage.setImageURL(requestedHelpX.getImage().getImageURL());
        }

        if(requestedHelpX.getImage() != null  && requestedHelpX.getImage().getAltText() != null && !requestedHelpX.getImage().getAltText().isEmpty() )  {
            updatedImage.setAltText(requestedHelpX.getImage().getAltText());
        }

        return updatedHelpX;
    }

    @Override
    public HelpX getHelpXArticle(String id) {
        Query query = new Query();
        query.addCriteria(new Criteria("schemaId").is(id));

        return mongoTemplate.findOne(query, HelpX.class);
    }
}
