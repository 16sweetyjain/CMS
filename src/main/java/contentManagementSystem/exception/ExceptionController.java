package contentManagementSystem.exception;

import contentManagementSystem.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler( value = {BadRequestException.class, InternalServerError.class ,NotAuthorizedError.class, ResourceNotFoundError.class})
    public ResponseEntity<ErrorResponse> handleException(BaseException exception) {
        HttpStatus statusCode = getErrorCode(exception.getErrCode());
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrMsg(),exception.getErrCode());
        return new ResponseEntity<>(errorResponse, statusCode);
    }

    public HttpStatus getErrorCode(int errorCode){
        switch (errorCode){
            case 500: return HttpStatus.INTERNAL_SERVER_ERROR;
            case 403 : return HttpStatus.FORBIDDEN;
            case 404: return HttpStatus.NOT_FOUND;
            default:    return HttpStatus.BAD_REQUEST;
        }
    }

}
