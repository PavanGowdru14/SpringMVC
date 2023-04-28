package controler;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.EmployeeDao;
import dto.Employee;
import net.bytebuddy.asm.Advice.Return;
import service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("Loademployee")
	public ModelAndView loadEmployee() {
		return service.loadEmployee();
	}

	@PostMapping("saveemployee")
	public ModelAndView saveemployee(@ModelAttribute Employee employee, @RequestParam String date) {

		return service.saveemployee(employee, date);
	}

	@GetMapping("fetchall")
	public ModelAndView fetch() {
		return service.fetch();
	}
	@GetMapping("delete")
	public ModelAndView delete(@RequestParam int id){
		return service.deleteemp(id);
	}
	@RequestMapping("edit")
	public ModelAndView editEmployee(@RequestParam int id) {
		return service.editEmployee(id);
	}

	@PostMapping("updateemployee")
	public ModelAndView updateEmployee(@ModelAttribute Employee employee, @RequestParam String date) {

		return service.updateEmployee(employee, date);
	}

}
