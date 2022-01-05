package org.vanrar.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/")//указываем по какому адресу будет доступен метод
    public String showFirstView() {
        return "first-view"; //bean in applicationContext will add prefix and suffix
    }
}
