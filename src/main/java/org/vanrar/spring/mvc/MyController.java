package org.vanrar.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
//если несколько контроллеров, то надо делать @RequestMapping на весь контроллер, что бы не было конфликтов, напрамиер
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")//указываем по какому адресу будет доступен метод
    public String showFirstView() {
        return "first-view"; //bean in applicationContext will add prefix and suffix
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {

        //здесь можем предварительно создлать сущность и заполнить дефолтными значениями
        model.addAttribute("employee", new Employee());//теперь он доступен в первом view, то есть в ask-emp-details-view мы сможем его заполнять

        return "ask-emp-details-view";
    }

    //заменяем на  @RequestParam - позволяет связывать поле формы с параметрами метода из контроллера
    @RequestMapping("/showDetails")
    public String showEmpDetails(@ModelAttribute("employee") Employee emp) { //указываем, что show-emp-details-view может использовать аттрибут модели employee
        //тут можем дернуть значения из emp и откорректировать их через set полей
        return "show-emp-details-view";
    }
}
