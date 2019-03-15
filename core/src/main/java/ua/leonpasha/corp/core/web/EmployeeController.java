package ua.leonpasha.corp.core.web;


import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.leonpasha.corp.api.dto.Employee;

@Controller
public class EmployeeController {

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("employeeHome", "employee", new Employee());
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("employee")Employee employee,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("first name", employee.getFirstName());
        model.addAttribute("second name", employee.getSecondName());
        model.addAttribute("id", employee.getEmployeeId());
        return "employeeView";
    }

    @RequestMapping(value = "/employee/hello", method = RequestMethod.GET)
    public String showFormString(Model model) {
        model.addAttribute("name", "tom");
        return "greeting";
    }
}
