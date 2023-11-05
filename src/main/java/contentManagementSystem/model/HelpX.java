package contentManagementSystem.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "helpX")
public class HelpX extends  Schema{
    String title;
    String subTitle;
    String description;
    Image image;
    String paragraph;

    public HelpX(String schemaId, String title, String subTitle, String description, Image image, String paragraph) {
        super(schemaId);
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.image = image;
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
