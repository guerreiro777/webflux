package br.com.lenin.webfluxexemplo.controller;

import br.com.lenin.webfluxexemplo.model.request.EmployeeRequest;
import br.com.lenin.webfluxexemplo.model.response.EmployeeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeController {


    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeResponse> saveEmployee(@RequestBody EmployeeRequest employeeDto);

    @GetMapping("{id}")
    public Mono<EmployeeResponse> getEmployee(@PathVariable("id") String employeeId);

    @GetMapping
    public Flux<EmployeeResponse> getAllEmployees();

    @PutMapping("{id}")
    public Mono<EmployeeResponse> updateEmployee(@RequestBody EmployeeRequest employeeDto,
                                            @PathVariable("id") String employeeId);

//    @DeleteMapping("{id}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public Mono<Void> deleteEmployee(@PathVariable("id") String employeeId){
//        return employeeService.deleteEmployee(employeeId);
//    }
}
