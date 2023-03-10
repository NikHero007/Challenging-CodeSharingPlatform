package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

@Controller
public class AppController {
    @Autowired
    UserService userService;


    @PostMapping ("/api/code/new")
    public ResponseEntity<?> PostAPIcode (@RequestBody CodeSnippet codeSnippet) {
        String newCodeSnippet = codeSnippet.getCode();
        //устанавливаем новый код
        Code code = new Code(newCodeSnippet);
        userService.save(code);
        String output = "{\"id\" : \"" + userService.count() + "\"}";
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @GetMapping("/api/code/{N}")
    public ResponseEntity<?> GetAPIcode (@PathVariable Long N) {
        Code code = userService.findCodeById(N);

        return new ResponseEntity<>(code, HttpStatus.OK);
    }

    @GetMapping("/code/{N}")
    public String GetWebCode(@PathVariable Long N, Model model) {
        Code code = userService.findCodeById(N);
        model.addAttribute("code", code);
        return "GetWebCode";
    }

    @GetMapping("/code/new")
    public String GetNewWebCode() {
        return "GetNewWebCode";
    }

    @GetMapping("/api/code/latest")
    public ResponseEntity<?> GetLatestAPI () {
        LinkedList<Code> latestList = new LinkedList<>();
        long count = userService.count() >= 10 ? (userService.count() - 9) : 1;

        for(long counter = userService.count(); counter >= count; counter--) {
            Code code = userService.findCodeById(counter);
            latestList.add(code);
        }
        return new ResponseEntity<>(latestList, HttpStatus.OK);
    }

    @GetMapping("/code/latest")
    public String GetLatest (Model model) {
        LinkedList<Code> latestList = new LinkedList<>();
        long count = userService.count() >= 10 ? (userService.count() - 9) : 1;

        for(long counter = userService.count(); counter >= count; counter--) {
            Code code = userService.findCodeById(counter);
            latestList.add(code);
        }

        model.addAttribute("Codes", latestList);
        return "codeList";
    }

}
