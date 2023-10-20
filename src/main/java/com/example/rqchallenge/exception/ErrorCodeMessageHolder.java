package com.example.rqchallenge.exception;

import com.example.rqchallenge.enums.ErrorCode;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodeMessageHolder {
    private static Map<ErrorCode,String> errorCodeMessageMap = new HashMap<ErrorCode, String>();

    static {
        errorCodeMessageMap.put(ErrorCode.NO_RECORDS_FOUND, "No Records Found");
        errorCodeMessageMap.put(ErrorCode.EXCEPTION_IN_CALLING_EXTERNAL_API, "Exception occurred while calling https://dummy.restapiexample.com/api/v1");
        errorCodeMessageMap.put(ErrorCode.EXCEPTION_IN_JSON_TO_OBJECT_CONVERSION, "Exception occurred while converting JSON to Object");
        errorCodeMessageMap.put(ErrorCode.EXCEPTION_IN_OBJECT_TO_JSON_CONVERSION, "Exception occurred while converting object to JSON");
        errorCodeMessageMap.put(ErrorCode.INVALID_CREATE_EMPLOYEE_OBJECT, "Please pass employee object");
        errorCodeMessageMap.put(ErrorCode.EMPLOYEE_NAME_NOT_PASSED, "Employee name not passed");
        errorCodeMessageMap.put(ErrorCode.EMPLOYEE_SALARY_NOT_PASSED, "Employee salary not passed");
        errorCodeMessageMap.put(ErrorCode.INVALID_EMPLOYEE_SALARY_PASSED, "Invalid Employee salary passed");
        errorCodeMessageMap.put(ErrorCode.EMPLOYEE_AGE_NOT_PASSED, "Employee age not passed");
        errorCodeMessageMap.put(ErrorCode.INVALID_EMPLOYEE_AGE_PASSED, "Invalid Employee age passed");
        errorCodeMessageMap.put(ErrorCode.EMPLOYEE_ID_NOT_PASSED, "Employee Id not passed");
        errorCodeMessageMap.put(ErrorCode.INTERNAL_SERVER_EXCEPTION, "Internal Server Exception");


    }

    public static Map<ErrorCode, String> getErrorCodeMessageMap() {
        return errorCodeMessageMap;
    }

    public static void setErrorCodeMessageMap(Map<ErrorCode, String> errorCodeMessageMap) {
        ErrorCodeMessageHolder.errorCodeMessageMap = errorCodeMessageMap;
    }

    public static String getErrorMessage(ErrorCode errorCode)
    {
        return errorCodeMessageMap.get(errorCode);
    }
}
