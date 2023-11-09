package contentManagementSystem.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.validation.Schema;

@Document(collection = "Faq")
public class Faq {
    @Id
    String id;
    String schemaId;
    String title;
    String description;


    public Faq(String schemaId, String title, String description) {
        this.schemaId = schemaId;
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
