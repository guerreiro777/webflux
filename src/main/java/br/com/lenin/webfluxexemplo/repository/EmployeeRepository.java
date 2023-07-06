package br.com.lenin.webfluxexemplo.repository;

import br.com.lenin.webfluxexemplo.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {

    private final ReactiveMongoTemplate mongoTemplate;

    public Mono<Employee> save(final Employee Employee) {
        return mongoTemplate.save(Employee);
    }

    public Mono<Employee> findById(String id) {
        return mongoTemplate.findById(id, Employee.class);
    }

    public Flux<Employee> findAll() {
        return mongoTemplate.findAll(Employee.class);
    }

    public Mono<Employee> findAndRemove(String id) {
        Query query = new Query();
        Criteria where = Criteria.where("id").is(id);
        return mongoTemplate.findAndRemove(query.addCriteria(where), Employee.class);
    }
}
