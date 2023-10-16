package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Feedback;
import com.example.demo.Service.FeedBackService;
import com.example.demo.dto.request.FeedBackResquest;

import lombok.RequiredArgsConstructor;

@RequestMapping("/feedback")
@RequiredArgsConstructor
@RestController
public class FeedBackController {

    private final FeedBackService service;
    @PostMapping("/save")
    public String saveFeedback(@RequestBody FeedBackResquest request){
        return service.saveFeedback(request);
    }

    @GetMapping("/get")
    public List<Feedback> getAllFeedbacks(){
        return service.getAllFeedbacks();
    }
    @GetMapping("/test")
    public String testfunc()
    {
return "hello";
    }

    @DeleteMapping("/delete/{id}")
    public String deletefeedback(@PathVariable Long id){
        return service.deletefeedback(id);
    }

    @PutMapping("/update/{id}")
    public String updateFeedback(@PathVariable Long id, @RequestBody Feedback data){
        return service.updateFeedback(id, data);
    }
}
