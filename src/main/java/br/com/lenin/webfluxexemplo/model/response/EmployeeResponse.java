package br.com.lenin.webfluxexemplo.model.response;

public record EmployeeResponse(
        String id,
        String firstName,
        String email,
        String lastName
) {
}
