package tws.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import tws.DTA.EmployeeDTO;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

public class employeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDTO getemployeeWith(@PathVariable String id) {
        Employee employee = employeeMapper.selectOne(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(employee.getName());
        employeeDTO.setAge(employee.getAge());
        employeeDTO.setDesc("name:"+employee.getName()+",age:"+employee.getAge());
        return employeeDTO;
    }
}
