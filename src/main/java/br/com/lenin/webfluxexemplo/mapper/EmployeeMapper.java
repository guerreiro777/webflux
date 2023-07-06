package br.com.lenin.webfluxexemplo.mapper;

import br.com.lenin.webfluxexemplo.entity.Employee;
import br.com.lenin.webfluxexemplo.model.request.EmployeeRequest;
import br.com.lenin.webfluxexemplo.model.response.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        nullValueCheckStrategy = ALWAYS
)
public interface EmployeeMapper {

    @Mapping(target = "id", ignore = true)
    Employee toEntity(final EmployeeRequest request);

    @Mapping(target = "id", ignore = true)
    Employee toEntity(final EmployeeRequest request, @MappingTarget final Employee entity);

    EmployeeResponse toResponse(final Employee entity);
}
