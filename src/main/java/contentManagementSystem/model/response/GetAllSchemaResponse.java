package contentManagementSystem.model.response;

import java.util.List;

public class GetAllSchemaResponse<K> extends BaseResponse{
    List<K> schemaList;

    public GetAllSchemaResponse() {
    }

    public GetAllSchemaResponse(List<K> schemaList) {
        this.schemaList = schemaList;
    }

    public List<K> getSchemaList() {
        return schemaList;
    }

    public void setSchemaList(List<K> schemaList) {
        this.schemaList = schemaList;
    }
}
