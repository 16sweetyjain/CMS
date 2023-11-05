package contentManagementSystem.model;

public class Image {
    String imageURL;
    String altText;

    public Image(String imageURL, String altText) {
        this.imageURL = imageURL;
        this.altText = altText;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageURL='" + imageURL + '\'' +
                ", altText='" + altText + '\'' +
                '}';
    }
}
