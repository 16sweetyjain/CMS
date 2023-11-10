package contentManagementSystem.model.request.updateRequest;

import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.model.Faq;
import contentManagementSystem.model.request.BaseRequest;

public class UpdateFaqSchemaRequest extends BaseRequest {
    String schemaId;
    String description;
    String title;

    public UpdateFaqSchemaRequest(String requestId, SchemaEnum schemaEnum) {
        super(requestId, schemaEnum);
    }

    public UpdateFaqSchemaRequest(String requestId, SchemaEnum schemaEnum, String schemaId, String description, String title) {
        super(requestId, schemaEnum);
        this.schemaId = schemaId;
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

    public String getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }
}
