package contentManagementSystem.model;

public class Image {
    String imageURL;
    String altText;

    public Image(String imageURL, String altText) {
        this.imageURL = imageURL;
        this.altText = altText;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
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
