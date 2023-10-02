package dev.vishal.productservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorDTO {
    private HttpStatus errorCode;
    private String message;

    public ErrorDTO(HttpStatus errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
