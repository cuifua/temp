package cuifua.dao;

import cuifua.pojo.Department;
import cuifua.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    //模拟数据库中的数据

    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    static
    {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"AA","2231595741@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","2231595742@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","2231595743@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","2231595744@qq.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","2231595745@qq.com",0,new Department(105,"后勤部")));
        employees.put(1006,new Employee(1006,"FF","2231595746@qq.com",1,new Department(106,"记者部")));
    }

    //主键自增
    private static Integer initId = 1006;

    //增加一个员工
    public void save(Employee employee)
    {
        if (employee.getId()==null)
             employee.setId(initId++);


        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll()
    {
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id)
    {
        return employees.get(id);
    }

    //删除员工通过id
    public void deleteById(Integer id)
    {
        employees.remove(id);
    }


}
