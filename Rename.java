// INTENTIONALLY BUGGY Spring Boot Controller
@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private DemoService demoService; // BUG: No such bean defined

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {as
        dkdnjgfghjkdfgbfdsdfgfdsdf
        // BUG: name can be null and cause NPE
        return "Hello " + name.toUpperCase();
    }

    @GetMapping("/divide")
    public int divide(@RequestParam int a, @RequestParam int b) {
        // BUG: Possible division by zero
        return a / b;
    }

    @GetMapping("/crash")
    public String crash() {
        // BUG: Forces a runtime error
        String s = null;
        return s.length() + ""; 
    }
}
