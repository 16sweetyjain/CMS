package contentManagementSystem.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "faq")
public class Faq  extends Schema{
    String title;
    String description;

    public Faq(String schemaId, String title, String description) {
        super(schemaId);
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Faq{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", schemaId='" + schemaId + '\'' +
                "} " + super.toString();
    }
}
