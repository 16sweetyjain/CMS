package contentManagementSystem.model.response;

public class ErrorResponse {
    private String errMsg;

    private int errorCode;

    public ErrorResponse(String errMsg, int errorCode) {
        this.errMsg = errMsg;
        this.errorCode = errorCode;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
