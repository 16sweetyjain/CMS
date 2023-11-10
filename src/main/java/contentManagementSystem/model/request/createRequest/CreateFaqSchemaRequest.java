package contentManagementSystem.model.request.createRequest;

import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.request.BaseSchemaRequest;

public class CreateFaqSchemaRequest extends BaseSchemaRequest {
    String description;
    String title;

    public CreateFaqSchemaRequest(String requestId, String userId, SchemaEnum schemaEnum, String description, String title) {
        super(requestId, userId, schemaEnum);
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
