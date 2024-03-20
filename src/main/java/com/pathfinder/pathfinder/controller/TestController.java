package com.pathfinder.pathfinder.controller;


import com.pathfinder.pathfinder.model.Grid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @CrossOrigin
    @GetMapping
    public Grid test() {
        Grid grid = new Grid();
        grid.setWidth(randomNumber(5, 15));
        grid.setHeight(randomNumber(5,15));
        return grid;
    }

    public int randomNumber(int min, int max){
        int number;
        number = (int) (Math.random() * max + min);
        return number;
    }

}
