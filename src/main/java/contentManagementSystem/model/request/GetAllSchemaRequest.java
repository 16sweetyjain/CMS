package contentManagementSystem.model.request;

import java.util.List;

public class GetAllSchemaRequest<K> extends BaseRequest{
    List<K> schemaList;

    public List<K> getSchemaList() {
        return schemaList;
    }

    public void setSchemaList(List<K> schemaList) {
        this.schemaList = schemaList;
    }

    public GetAllSchemaRequest(String selectedSchema, String requestId) {
        super(selectedSchema, requestId);
    }

}
