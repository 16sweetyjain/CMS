package contentManagementSystem.exception;

public class ResourceNotFoundError extends BaseException{
    public ResourceNotFoundError(String errMsg, int errCode, String requestId) {
        super(errMsg, errCode, requestId);
    }

    public ResourceNotFoundError(Throwable cause, String errMsg, int errCode) {
        super(cause, errMsg, errCode);
    }
}
