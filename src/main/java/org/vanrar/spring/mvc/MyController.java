package org.vanrar.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
//если несколько контроллеров, то надо делать @RequestMapping на весь контроллер, что бы не было конфликтов, например
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

    /**
     * bindingResult - возращает результат валидации
     */
    @RequestMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult) { //указываем, что show-emp-details-view может использовать аттрибут модели employee

        if(bindingResult.hasErrors()){
            return "ask-emp-details-view";
        }else {
            return "show-emp-details-view";//хотя можно и без else, итак если в if зайдёт, то дальше не пойдёт и наоборот
        }
    }
}
