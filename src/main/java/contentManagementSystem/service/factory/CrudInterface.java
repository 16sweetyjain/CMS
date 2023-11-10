package contentManagementSystem.service.factory;


import contentManagementSystem.enums.SchemaEnum;
import contentManagementSystem.exception.BadRequestException;
import contentManagementSystem.exception.InternalServerError;

// K - generic request object
// T - generic response object
public interface CrudInterface<K, T> {
    public T getSchema(K k) throws InternalServerError, BadRequestException;
    public T createSchema(K k) throws InternalServerError, BadRequestException;
    public T updateSchema(K k) throws InternalServerError, BadRequestException;
    public T getAllSchema(K k) throws InternalServerError;
    public SchemaEnum getStrategyName();
}
