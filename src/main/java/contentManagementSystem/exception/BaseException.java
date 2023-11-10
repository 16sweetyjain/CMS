package contentManagementSystem.exception;

public class BaseException extends Exception {

        private static final long serialVersionUID = 7718828512143293560L;

        private String errMsg;

        private int errCode;

        private String requestId;

        public BaseException(String errMsg, int errCode, String requestId) {
            super();
            this.errMsg = errMsg;
            this.errCode = errCode;
            this.requestId = requestId;
        }

        public BaseException(Throwable cause, String errMsg, int errCode) {
            super(cause);
            this.errMsg = errMsg;
            this.errCode = errCode;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public int getErrCode() {
            return errCode;
        }

    }

