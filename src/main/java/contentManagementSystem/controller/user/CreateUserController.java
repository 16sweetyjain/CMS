package contentManagementSystem.controller.user;

import contentManagementSystem.model.request.user.CreateUserRequest;
import contentManagementSystem.model.request.user.CreateUserRequestBody;
import contentManagementSystem.model.response.UserResponse;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;
@RestController
public class CreateUserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAllSchemaResponse> createUser(@RequestBody CreateUserRequestBody createUserRequestBody, @RequestHeader Map<String, String> headers) {

        ResponseEntity responseEntity = null;

        CreateUserRequest createUserRequest = new CreateUserRequest(headers.get("x-request-id"), UUID.randomUUID().toString(), createUserRequestBody.getName(), createUserRequestBody.getEmail());

        UserResponse createUserResponse = new UserResponse();

        try {
            createUserResponse = userService.createUser(createUserRequest);
            responseEntity = ResponseEntity.ok(createUserResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
