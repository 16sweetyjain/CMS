package contentManagementSystem.service.selectSchema;


import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.service.SchemaTemplate;

import java.util.List;
// K - generic request object
// T - generic response object
public interface CrudSchemaInterface<K, T> {
    public T getSchema(K k);
    public T createSchema(K k);
    public T updateSchema(K k);
    public T getAllSchema(K k);
}
