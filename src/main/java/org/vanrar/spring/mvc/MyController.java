package org.vanrar.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/showDetails")
    public String showEmpDetails(HttpServletRequest request, Model model) {

        String empName = request.getParameter("employeeName");//получаем значения поля employeeName из ask-emp-details-view
        empName = "Mr. " + empName;
        model.addAttribute("nameAttribute", empName);
        return "show-emp-details-view";
    }
}
