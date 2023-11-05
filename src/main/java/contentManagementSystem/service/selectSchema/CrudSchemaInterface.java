package contentManagementSystem.service.selectSchema;


import contentManagementSystem.model.request.BaseRequest;

import java.util.List;

public interface CrudSchemaInterface<K> {
    public K getSchema(String schemaId);
    public K createSchema(K k);
    public List<K> getAllSchema();
    public K updateSchema(K k);
    public K createSchemaFromRequest(BaseRequest baseRequest);
}
