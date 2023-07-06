package br.com.lenin.webfluxexemplo.model.response;

public record UserResponse(
        String id,
        String name,
        String email,
        String password
) { }
