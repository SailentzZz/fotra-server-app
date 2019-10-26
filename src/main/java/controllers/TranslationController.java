package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/translate")
public class TranslationController {

    @GetMapping("/")
    public String getTranslation() {
        return "Translation";
    }

}
