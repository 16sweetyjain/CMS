package contentManagementSystem.model.request.createRequest;

import contentManagementSystem.model.Image;

public class CreateHelpXSchemeRequestBody {
    String title;
    String subTitle;
    String description;
    Image image;
    String paragraph;

    public CreateHelpXSchemeRequestBody(String title, String subTitle, String description, Image image, String paragraph) {
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

    public CreateHelpXSchemeRequestBody() {
    }
}
