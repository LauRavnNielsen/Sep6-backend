package SEP6_Spring.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/Test")
    public String Test()
    {
        return "Hello World";
    }




}
