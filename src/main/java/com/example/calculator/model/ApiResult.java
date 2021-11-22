package com.example.calculator.model;

public class ApiResult {

   private String result;
   private String message;
   private Boolean error;

   private ApiResult() {
   }

   static ApiResult withResult(String resultMessage) {
      ApiResult apiResult = new ApiResult();
      apiResult.result = resultMessage;
      apiResult.error = false;
      return apiResult;
   }

   static ApiResult withError(String errorMessage) {
      ApiResult apiResult = new ApiResult();
      apiResult.message = errorMessage;
      apiResult.error = true;
      return apiResult;
   }

   public String getResult() {
      return result;
   }

   public Boolean getError() {
      return error;
   }

   public String getMessage() {
      return message;
   }
}
