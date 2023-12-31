package contentManagementSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HelpX")
public class HelpX{
    @Id
    String id;
    String helpXId;
    String title;
    String subTitle;
    Image image;
    String paragraph;
    String userId;

    public HelpX() {
    }

    public HelpX(String helpXId, String title, String subTitle, String description, Image image, String paragraph, String userId) {
        this.helpXId = helpXId;
        this.title = title;
        this.subTitle = subTitle;
        this.image = image;
        this.paragraph = paragraph;
        this.userId = userId;
    }

    public HelpX(String id, String helpXId, String title, String subTitle, String description, Image image, String paragraph, String userId) {
        this.id = id;
        this.helpXId = helpXId;
        this.title = title;
        this.subTitle = subTitle;
        this.image = image;
        this.paragraph = paragraph;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchemaId() {
        return helpXId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSchemaId(String helpXId) {
        this.helpXId = helpXId;
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
                ", image=" + image +
                ", paragraph='" + paragraph + '\'' +
                ", helpXId='" + helpXId + '\'' +
                "} " + super.toString();
    }
}
