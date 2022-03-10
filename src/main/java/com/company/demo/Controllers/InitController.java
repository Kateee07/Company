package com.company.demo.Controllers;

import com.example.demo.Services.InitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/init")
public class InitController {

    private InitService initService;

    public InitController(InitService initService) {
        this.initService = initService;
    }

    @PostMapping("/init")
    public void init() {
        initService.init();
    }
}
