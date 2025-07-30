@RestController
public class GreetController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello World";
    }
}
