package org.vanrar.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @RequestMapping("/")//указываем по какому адресу будет доступен метод
    public String showFirstView() {
        return "first-view"; //bean in applicationContext will add prefix and suffix
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details-view";
    }

   //заменяем на  @RequestParam - позволяет связывать поле формы с параметрами метода из контроллера
    @RequestMapping("/showDetails")
    public String showEmpDetails(@RequestParam("employeeName") String empName, Model model) {

        empName = "Mr. " + empName;
        model.addAttribute("nameAttribute", empName);
        return "show-emp-details-view";
    }
}
