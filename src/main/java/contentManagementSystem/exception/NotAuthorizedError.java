package contentManagementSystem.exception;

public class NotAuthorizedError extends BaseException{
    public NotAuthorizedError(String errMsg, int errCode, String requestId) {
        super(errMsg, errCode, requestId);
    }

    public NotAuthorizedError(Throwable cause, String errMsg, int errCode) {
        super(cause, errMsg, errCode);
    }
}
