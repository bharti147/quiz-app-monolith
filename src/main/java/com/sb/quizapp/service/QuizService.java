package com.sb.quizapp.service;

import com.sb.quizapp.dao.QuestionDao;
import com.sb.quizapp.dao.QuizDao;
import com.sb.quizapp.model.Question;
import com.sb.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title){

        try {
            List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizDao.save(quiz);
            return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error creating quiz", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
