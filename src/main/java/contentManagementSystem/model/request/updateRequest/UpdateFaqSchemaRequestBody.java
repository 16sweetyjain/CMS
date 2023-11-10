package contentManagementSystem.model.request.updateRequest;

public class UpdateFaqSchemaRequestBody {
    String description;
    String title;

    public UpdateFaqSchemaRequestBody() {
    }

    public UpdateFaqSchemaRequestBody(String description, String title) {
        this.description = description;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
