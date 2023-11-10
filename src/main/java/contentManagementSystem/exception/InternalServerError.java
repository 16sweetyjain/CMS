package contentManagementSystem.exception;

public class InternalServerError extends BaseException{
    public InternalServerError(String errMsg, int errCode, String requestId) {
        super(errMsg, errCode, requestId);
    }

    public InternalServerError(Throwable cause, String errMsg, int errCode) {
        super(cause, errMsg, errCode);
    }
}
