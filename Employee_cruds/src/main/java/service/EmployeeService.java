package service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.EmployeeDao;
import dto.Employee;

@Component
public class EmployeeService {

	@Autowired
	Employee employee;

	@Autowired
	EmployeeDao Dao;

	// @GetMapping("Loademployee")
	public ModelAndView loadEmployee() {
		ModelAndView andView = new ModelAndView("InsrtData");
		andView.addObject("employee", employee);
		return andView;
		// return service.l;
	}

	// @PostMapping("saveemployee")
	public ModelAndView saveemployee(@ModelAttribute Employee employee, @RequestParam String date) {
		employee.setDoj(Date.valueOf(date));
		// EmployeeDao Dao = new EmployeeDao();
		Dao.save(employee);

		ModelAndView andView = new ModelAndView("Home.jsp");
		andView.addObject("msg", "Data added");
		return andView;
	}

	public ModelAndView fetch() {
		ModelAndView andView = new ModelAndView("Result");
		// List<Employee> list = Dao.fetch();
		List<Employee>list=Dao.fetch();
		if (list.isEmpty())
		{
			andView.addObject("msg","Data not found");
			andView.setViewName("Home");
		}
		else
		{
			andView.addObject("list",list);
			andView.setViewName("Result");
		}
		

		return andView;
	}

	public ModelAndView deleteemp(@RequestParam int id){
	  
	  ModelAndView andView = new ModelAndView("Result");
	  Dao.delete(id);
	  List<Employee>list=Dao.fetch();
		if (list.isEmpty())
		{
			andView.addObject("msg","Data not found");
			andView.setViewName("Home");
		}
		else
		{
			andView.addObject("list",list);
			andView.setViewName("Result");
		}
		
	  andView.addObject("list", Dao.fetch());
	  andView.addObject("msg","Employee data deleted sucessfully");
	  return andView;
  }

	public ModelAndView editEmployee(int id) {
		ModelAndView andView = new ModelAndView("edit");
	   
	   andView.addObject("employee", Dao.find(id));
		return andView;
	}
	public  ModelAndView updateEmployee(Employee employee,String date)
	{
		employee.setDoj(Date.valueOf(date));
		Dao.update(employee);
		ModelAndView andView=new ModelAndView("Result");
		andView.addObject("list",Dao.fetch());
		andView.addObject("msg","Date Update Sucessfully");
		return andView;		
	}
}
