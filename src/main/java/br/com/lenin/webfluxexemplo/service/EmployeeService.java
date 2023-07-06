package br.com.lenin.webfluxexemplo.service;

import br.com.lenin.webfluxexemplo.entity.Employee;
import br.com.lenin.webfluxexemplo.repository.EmployeeRepository;
import br.com.lenin.webfluxexemplo.mapper.EmployeeMapper;
import br.com.lenin.webfluxexemplo.model.request.EmployeeRequest;
import br.com.lenin.webfluxexemplo.model.response.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeEntity;

    public Mono<EmployeeResponse> saveEmployee(EmployeeRequest employeeDto) {
        Employee employee = employeeEntity.toEntity(employeeDto);
        Mono<Employee> savedEmployee = employeeRepository.save(employee);
        return savedEmployee
                .map((employeer) -> employeeEntity.toResponse(employeer));
    }

    public Mono<EmployeeResponse> getEmployee(String employeeId) {
        Mono<Employee> employeeMono = employeeRepository.findById(employeeId);
        return employeeMono.map((employee -> employeeEntity.toResponse(employee)));
    }

    public Flux<EmployeeResponse> getAllEmployees() {

        Flux<Employee> employeeFlux  = employeeRepository.findAll();
        return employeeFlux
                .map(employeeEntity::toResponse)
                .switchIfEmpty(Flux.empty());
    }

    public Mono<EmployeeResponse> updateEmployee(EmployeeRequest employeeDto, String employeeId) {

        Mono<Employee> employeeMono = employeeRepository.findById(employeeId);

        return employeeMono.flatMap((existingEmployee) -> {
            existingEmployee.setFirstName(employeeDto.firstName());
            existingEmployee.setLastName(employeeDto.lastName());
            existingEmployee.setEmail(employeeDto.email());
            return employeeRepository.save(existingEmployee);
        }).map((employee -> employeeEntity.toResponse(employee)));
    }

//    public Mono<Void> deleteEmployee(String employeeId) {
//        return employeeRepository.deleteById(employeeId);
//    }
}
