package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping(value = "/code/{code:\\d+}")
    public void code(@PathVariable("code") Integer code, HttpServletResponse httpServletResponse) {
        httpServletResponse.setStatus(code);
    }

    @GetMapping(value = "/hello/{name:[a-zA-Z\\d]+}")
    public void hello(@PathVariable("name") String name, HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.getWriter().write("Hello, " + name + "!");
        } catch (IOException e) {
            logger.error("Write response error", e);
        }
    }

    @GetMapping(value = "/sleep/{time:\\d+}")
    public String sleep(@PathVariable("time") long time) throws InterruptedException {
        Thread.sleep(time);
        return time + "@" + System.currentTimeMillis();
    }

}
