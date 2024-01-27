package com.example.seminar3spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api")
public class MyController {
    private final MyService myService;
    @Autowired

    public MyController(MyService myService) {
        this.myService = myService;
    }
    @RequestMapping(value = "/List",method = RequestMethod.GET)
    public ResponseEntity<List<User>> getList(){
        return new ResponseEntity<>(myService.getList(), HttpStatus.OK);
    }
    @RequestMapping(value = "/Sort",method = RequestMethod.GET)
    public ResponseEntity<List<User>> getSort(){
        return new ResponseEntity<>(myService.sortByAge(), HttpStatus.OK);
    }
    @RequestMapping(value = "/Filter/{age}",method = RequestMethod.GET)
    public ResponseEntity<List<User>> getFilter(@PathVariable("age") int age){
        return new ResponseEntity<>(myService.filterByAge(age), HttpStatus.OK);
    }
    @RequestMapping(value = "/Middle",method = RequestMethod.GET)
    public ResponseEntity<Double> getMiddle(){
        return new ResponseEntity<>(myService.getMiddleAge(), HttpStatus.OK);
    }
    @RequestMapping(value = "/Create",method = RequestMethod.POST)
    public ResponseEntity<User> createUser(
            @RequestParam String name, @RequestParam String email, @RequestParam int age){
        return new ResponseEntity<>(myService.createUser(name, email, age), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/Complete",method = RequestMethod.POST)
    public ResponseEntity<List<User>> getComplete(){
        return new ResponseEntity<>(myService.complete(), HttpStatus.OK);
    }
    @RequestMapping(value = "/Notes",method = RequestMethod.GET)
    public ResponseEntity<List<String>> getNotes(){
        return new ResponseEntity<>(myService.getNotes(), HttpStatus.OK);
    }
}
