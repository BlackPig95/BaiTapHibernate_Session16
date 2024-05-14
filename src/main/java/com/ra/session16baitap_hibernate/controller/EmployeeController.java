package com.ra.session16baitap_hibernate.controller;

import com.ra.session16baitap_hibernate.dao.IEmployeeDao;
import com.ra.session16baitap_hibernate.orm.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController
{
    private final IEmployeeDao employeeDao;

    @Autowired
    public EmployeeController(IEmployeeDao ed)
    {
        this.employeeDao = ed;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }

    @GetMapping({"/", "/list"})
    public String listEmployee(Model model)
    {
        List<Employee> employeeList = employeeDao.findAll();
        model.addAttribute("list", employeeList);
        return "listEmployee";
    }

    @GetMapping("/add")
    public String viewAdd(Model model)
    {
        Employee e = new Employee();
        model.addAttribute("em", e);
        return "addEmployee";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable("id") Integer id, Model model)
    {
        Employee e = employeeDao.findById(id);
        model.addAttribute("edit", e);
        return "editEmployee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id, Model model)
    {
        employeeDao.deleteEmployee(id);
        return "redirect:/list";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("em") Employee employee, Model model)
    {
        boolean success = employeeDao.insertEmployee(employee);
        if (success)
        {
            return "redirect:/list";
        } else
        {
            model.addAttribute("err", "Insert failed");
            model.addAttribute("em", employee);
            return "addEmployee";
        }
    }

    @PostMapping("/editEmployee")
    public String editEmployee(@ModelAttribute("edit") Employee e)
    {
        employeeDao.updateEmployee(e);
        return "redirect:/list";
    }
}
