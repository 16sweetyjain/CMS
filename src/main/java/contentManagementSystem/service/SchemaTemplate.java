package contentManagementSystem.service;

import contentManagementSystem.exception.BadRequestException;
import contentManagementSystem.exception.InternalServerError;
import contentManagementSystem.exception.ResourceNotFoundError;
import contentManagementSystem.model.User;
import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.request.user.FindUserRequest;
import contentManagementSystem.model.response.BaseResponse;
import contentManagementSystem.service.factory.GetSchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public abstract class SchemaTemplate<T extends BaseRequest, K extends BaseResponse> {

    @Autowired
    UserService userService;

    public K driver(T request, K response) throws Exception {

        //validate if user is allowed to call api or not
        request = validateUser(request, response);

        //perform business logic
        response = process(request, response);

        //post processing of request i.e., sending analytics or others
        postprocess(request);

        return response;
    }

    protected T validateUser(T request, K response) throws ResourceNotFoundError {

        String userId = request.getHeaders().get("x-gw-auth-id");

        if(userService.findUserByUserId(userId) == null) {
            throw new ResourceNotFoundError("User not found", HttpStatus.NOT_FOUND.value(), request.getRequestId());
        }

        request.setUserId(userId);

        return request;
    }

    protected abstract K process(T request, K response) throws InternalServerError, BadRequestException;

    protected abstract K postprocess(T request);


}
