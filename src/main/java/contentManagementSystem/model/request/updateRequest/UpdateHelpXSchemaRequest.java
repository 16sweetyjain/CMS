package contentManagementSystem.model.request.updateRequest;

import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.model.Image;
import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.request.BaseSchemaRequest;

public class UpdateHelpXSchemaRequest extends BaseSchemaRequest {
    String schemaId;
    String title;
    String subTitle;
    String description;
    Image image;
    String paragraph;

    public UpdateHelpXSchemaRequest(String requestId, String userId, SchemaEnum schemaEnum) {
        super(requestId, userId, schemaEnum);
    }

    public UpdateHelpXSchemaRequest(String requestId, String userId, SchemaEnum schemaEnum, String schemaId, String title, String subTitle, String description, Image image, String paragraph) {
        super(requestId, userId, schemaEnum);
        this.schemaId = schemaId;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.image = image;
        this.paragraph = paragraph;
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
}
