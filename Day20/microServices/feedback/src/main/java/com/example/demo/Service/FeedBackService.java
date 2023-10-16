package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.Feedback;
import com.example.demo.Repository.FeedbackRepository;
import com.example.demo.dto.request.FeedBackResquest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedBackService {
    private final FeedbackRepository feedbackRepository;

    public String saveFeedback(FeedBackResquest request){
        var resposneform = Feedback.builder()
        .fullname(request.getFullname())
        .useremail(request.getUseremail())
        .description(request.getDescription())
        .build();
        feedbackRepository.save(resposneform);
        return "Saved successfully";
    }

    public List<Feedback> getAllFeedbacks(){
        return feedbackRepository.findAll();
    }

    public String deletefeedback(Long id){
        feedbackRepository.deleteById(id);
        return "Deleted successfully";
    }

    public String updateFeedback(Long id, Feedback data){
        Feedback newform = feedbackRepository.findByFormId(id);
        if(newform!=null){
            newform.setUseremail(data.getUseremail());
            newform.setFullname(data.getFullname());
            newform.setDescription(data.getDescription());
            feedbackRepository.save(newform);
        }
        return "Updated successfully";
    }
}
