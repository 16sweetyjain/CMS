package contentManagementSystem.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Faq")
public class Faq {
    @Id
    String id;
    String faqId;
    String title;
    String description;
    String userId;

    public Faq() {
    }

    public Faq(String faqId, String title, String description, String userId) {
        this.faqId = faqId;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public Faq(String id, String faqId, String title, String description, String userId) {
        this.id = id;
        this.faqId = faqId;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchemaId() {
        return faqId;
    }

    public void setSchemaId(String faqId) {
        this.faqId = faqId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Faq{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", schemaId='" + faqId + '\'' +
                "} " + super.toString();
    }
}
