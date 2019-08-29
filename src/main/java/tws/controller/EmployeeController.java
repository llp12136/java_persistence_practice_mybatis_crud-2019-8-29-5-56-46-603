package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeMapper.selectAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> selectOne(@PathVariable String id) {
        Employee employee = employeeMapper.selectOne(id);
        return ResponseEntity.ok(employee);
    }

@PostMapping("")
public ResponseEntity<List<Employee>> insert(@RequestBody Employee employee) {
        String id = UUID.randomUUID().toString();
        employee.setId(id);
        employeeMapper.insert(employee);
    return ResponseEntity.created(URI.create("/employees"+id)).build();
}

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateOne(
            @PathVariable String id,
            @RequestBody Employee employee) {
        employeeMapper.update(id,employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Employee>> deleteOne(@PathVariable String id) {
        employeeMapper.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
