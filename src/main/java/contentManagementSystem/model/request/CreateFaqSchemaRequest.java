package contentManagementSystem.model.request;

public class CreateFaqSchemaRequest extends BaseRequest {
    String description;
    String title;

    public CreateFaqSchemaRequest(String selectedSchema, String requestId, String description, String title) {
        super(selectedSchema, requestId);
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

    @Override
    public String toString() {
        return "CreateFaqSchemaRequest{" +
                ", requestId='" + requestId + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
