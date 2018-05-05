package controllers.formatters;

import org.springframework.validation.FieldError;

import java.util.List;

public class ResponseErrors {
    public static String getErrorsFormatted(List<FieldError> fieldErrorList){
        StringBuilder errorMessages = new StringBuilder();
        String errorMessage = "";
        for (FieldError fieldError : fieldErrorList) {
            errorMessage =fieldError.getField()+':'+fieldError.getDefaultMessage()+';';
            errorMessages.append(errorMessage);
        }
        return errorMessages.toString();
    }

}
