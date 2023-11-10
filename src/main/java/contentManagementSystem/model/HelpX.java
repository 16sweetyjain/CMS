package contentManagementSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HelpX")
public class HelpX{
    @Id
    String id;
    String schemaId;
    String title;
    String subTitle;
    String description;
    Image image;
    String paragraph;

    public HelpX() {
    }

    public HelpX(String id, String schemaId, String title, String subTitle, String description, Image image, String paragraph) {
        this.id = id;
        this.schemaId = schemaId;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.image = image;
        this.paragraph = paragraph;
    }

    public HelpX(String schemaId, String title, String subTitle, String description, Image image, String paragraph) {
        this.schemaId = schemaId;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.image = image;
        this.paragraph = paragraph;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public String toString() {
        return "HelpX{" +
                "title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", paragraph='" + paragraph + '\'' +
                ", schemaId='" + schemaId + '\'' +
                "} " + super.toString();
    }
}
