package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll();

    void  insert(@Param("employee") Employee employee);

    Employee selectOne(@Param("id") String id);

    void  update(@Param("id") String id,
                 @Param("employee") Employee employee);

    void  delete(@Param("id") String id);
     Employee getEmployee(@Param("id") String id);


}
