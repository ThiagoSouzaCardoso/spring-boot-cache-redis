package br.com.empresa.dto;

public class ExceptionResponse {

    private String errorMessage;
    private String requestedURI;

    public void callerURL(final String requestedURI) {
        this.requestedURI = requestedURI;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRequestedURI() {
        return requestedURI;
    }

}
