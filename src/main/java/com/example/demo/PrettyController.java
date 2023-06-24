package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Controller
public class PrettyController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/game")
    public String game(Model model) throws InterruptedException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(format +"접속 되었습니다~~~~~~~~~~~!!");
        Thread.sleep(1000);
        Random random = new Random();
        int i = random.nextInt(3) + 1;
        int i2 = random.nextInt(3) + 1;
        GameDto myResult = new GameDto(i);
        GameDto otherResult = new GameDto(i2);
        model.addAttribute("myResult", myResult);
        model.addAttribute("otherResult", otherResult);
        return "game";
    }

    static class GameDto {
        private Integer result;

        public GameDto() {
        }

        public GameDto(Integer result) {
            this.result = result;
        }

        public Integer getResult() {
            return result;
        }
    }
}
