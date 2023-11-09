package contentManagementSystem.model.request;

import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.model.Image;

public class CreateHelpXSchemaRequest extends BaseRequest {
    String title;
    String subTitle;
    String description;
    Image image;
    String paragraph;

    public CreateHelpXSchemaRequest(String requestId, SchemaEnum schemaEnum, String title, String subTitle, String description, Image image, String paragraph) {
        super(requestId, schemaEnum);
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.image = image;
        this.paragraph = paragraph;
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
}
