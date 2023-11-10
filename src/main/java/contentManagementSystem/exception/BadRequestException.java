package contentManagementSystem.exception;

public class BadRequestException extends BaseException{
    public BadRequestException(String errMsg, int errCode, String requestId) {
        super(errMsg, errCode, requestId);
    }

    public BadRequestException(Throwable cause, String errMsg, int errCode) {
        super(cause, errMsg, errCode);
    }
}
