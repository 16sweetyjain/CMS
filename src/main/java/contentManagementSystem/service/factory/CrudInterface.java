package contentManagementSystem.service.factory;


import contentManagementSystem.enums.SchemaEnum;

// K - generic request object
// T - generic response object
public interface CrudInterface<K, T> {
    public T getSchema(K k);
    public T createSchema(K k);
    public T updateSchema(K k);
    public T getAllSchema(K k);
    public SchemaEnum getStrategyName();
}
