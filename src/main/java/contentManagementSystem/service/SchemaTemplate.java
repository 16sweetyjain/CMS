package contentManagementSystem.service;

import contentManagementSystem.model.User;
import contentManagementSystem.model.request.BaseRequest;
import contentManagementSystem.model.request.user.FindUserRequest;
import contentManagementSystem.model.response.BaseResponse;
import contentManagementSystem.service.factory.GetSchemaFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

    protected T validateUser(T request, K response) throws Exception {

        String userId = request.getHeaders().get("x-gw-auth-id");

        if(userService.findUserByUserId(userId) == null) {
            //user not found exception to be thrown
            throw new Exception();
        }

        request.setUserId(userId);

        return request;
    }

    protected abstract K process(T request, K response);

    protected abstract K postprocess(T request);


}
