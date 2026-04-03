package com.sb.quizapp.controller;

import com.sb.quizapp.model.QuestionWrapper;
import com.sb.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer quizId){
        return quizService.getQuizQuestions(quizId);
    }
}
