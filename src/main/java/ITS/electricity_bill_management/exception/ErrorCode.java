package ITS.electricity_bill_management.exception;

public enum ErrorCode {
    UNCATEGORIED_EXCEPTION(9999, "Uncategoried Exception"),
    CONFIGURATION_STARTKWH_EXITSTED(1001, "StartKWH already exited !"),
    CONFIGURATION_ENDKWH_EXITSTED(1001, "EndKWH already exited !"),
    CONFIGURATION_VALIDRANGE_ERROR(1002, "EndKWH must be greater than StartKWH !"),
    CONFIGURATION_STARTKWH_INVALID(1002, "StartKWH must be greater than 0 !"),
    USAGEHISTORY_COMSUMPTION_INVALID(1003, "Comsumption must be greater than 0 !"),
    USERNAME_EXITSED(1004, "Username exited !"),
    USERNAME_VALID(1005, "Username must be least at 3 characters !"),
    PASSWORD_VALID(1006, "Password must be least at 8 characters !"),
    ;



    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
