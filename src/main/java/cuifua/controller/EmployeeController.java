package cuifua.controller;


import cuifua.dao.DepartmentDao;
import cuifua.dao.EmployeeDao;
import cuifua.pojo.Department;
import cuifua.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;


@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model)
    {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model)
    {
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee)
    {
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    @RequestMapping("/emp/{id}")
    public String update(@PathVariable("id")Integer id, Model model)
    {
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    @RequestMapping("/updateEmp")
    public String updateEmp(Employee employee)
    {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/delemp/{id}")
    public String delEmp(@PathVariable("id") int id)
    {
        employeeDao.deleteById(id);
        return "redirect:/emps";
    }
}
