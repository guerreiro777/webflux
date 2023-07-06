package br.com.lenin.webfluxexemplo.model.request;

import br.com.lenin.webfluxexemplo.validator.TrimString;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeRequest(
        @TrimString
        @NotBlank(message = "must not be null or empty")
        @Size(min = 3, max = 50, message = "must be between 3 and 50 characters")
        String firstName,

        @TrimString
        @Email(message = "invalid email")
        @NotBlank(message = "must not be null or empty")
        String email,

        @TrimString
        @NotBlank(message = "must not be null or empty")
        @Size(min = 3, max = 20, message = "must be between 3 and 20 characters")
        String lastName) {

}
