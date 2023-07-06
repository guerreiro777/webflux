package br.com.lenin.webfluxexemplo.controller.impl;

import br.com.lenin.webfluxexemplo.controller.EmployeeController;
import br.com.lenin.webfluxexemplo.model.request.EmployeeRequest;
import br.com.lenin.webfluxexemplo.model.response.EmployeeResponse;
import br.com.lenin.webfluxexemplo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("employees")
@AllArgsConstructor
public class EmployeeControllerImpl implements EmployeeController {

    private EmployeeService employeeService;

    @Override
    public Mono<EmployeeResponse> saveEmployee(@RequestBody EmployeeRequest employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    @Override
    public Mono<EmployeeResponse> getEmployee(@PathVariable("id") String employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @Override
    public Flux<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @Override
    public Mono<EmployeeResponse> updateEmployee(@RequestBody EmployeeRequest employeeDto,
                                                 @PathVariable("id") String employeeId) {
        return employeeService.updateEmployee(employeeDto, employeeId);
    }

//    @DeleteMapping("{id}")
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public Mono<Void> deleteEmployee(@PathVariable("id") String employeeId){
//        return employeeService.deleteEmployee(employeeId);
//    }
}
