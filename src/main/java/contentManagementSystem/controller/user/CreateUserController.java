package contentManagementSystem.controller.user;

import contentManagementSystem.model.request.user.CreateUserRequest;
import contentManagementSystem.model.request.user.CreateUserRequestBody;
import contentManagementSystem.model.response.UserResponse;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
@RestController
public class CreateUserController {
    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAllSchemaResponse> createUser(@RequestBody CreateUserRequestBody createUserRequestBody, @RequestHeader Map<String, String> headers)  throws Exception  {

        ResponseEntity responseEntity = null;

        CreateUserRequest createUserRequest = new CreateUserRequest(headers.get("x-request-id"), UUID.randomUUID().toString(), createUserRequestBody.getName(), createUserRequestBody.getEmail());

        UserResponse createUserResponse = new UserResponse();


            createUserResponse = userService.createUser(createUserRequest);
            responseEntity = ResponseEntity.ok(createUserResponse);


        return responseEntity;
    }
}
