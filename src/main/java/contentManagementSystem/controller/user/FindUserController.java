package contentManagementSystem.controller.user;

import contentManagementSystem.model.request.user.CreateUserRequest;
import contentManagementSystem.model.request.user.CreateUserRequestBody;
import contentManagementSystem.model.request.user.FindUserRequest;
import contentManagementSystem.model.response.GetAllSchemaResponse;
import contentManagementSystem.model.response.UserResponse;
import contentManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class FindUserController {
    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/user/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAllSchemaResponse> findUser(@PathVariable String email, @RequestHeader Map<String, String> headers)  throws Exception  {

        ResponseEntity responseEntity = null;

        UserResponse findUserResponse = new UserResponse();


            findUserResponse = userService.findUserByUserEmail(email);
            responseEntity = ResponseEntity.ok(findUserResponse);

        return responseEntity;
    }
}
