package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class PrettyController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/game")
    public String game(Model model) {
        System.out.println("접속 되었습니다~~~~~~~~!!");
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
