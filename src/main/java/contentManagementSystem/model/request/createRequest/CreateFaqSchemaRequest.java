package contentManagementSystem.model.request.createRequest;

import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.model.request.BaseRequest;

public class CreateFaqSchemaRequest extends BaseRequest {
    String description;
    String title;

    public CreateFaqSchemaRequest(String requestId, SchemaEnum schemaEnum, String description, String title) {
        super(requestId, schemaEnum);
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
