package contentManagementSystem.model.request;

import contentManagementSystem.model.Image;

public class UpdateHelpXSchemaRequestBody {
    String title;
    String subTitle;
    String description;
    Image image;
    String paragraph;

    public UpdateHelpXSchemaRequestBody() {
    }

    public UpdateHelpXSchemaRequestBody(String title, String subTitle, String description, Image image, String paragraph) {
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.image = image;
        this.paragraph = paragraph;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getDescription() {
        return description;
    }

    public Image getImage() {
        return image;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }
}
