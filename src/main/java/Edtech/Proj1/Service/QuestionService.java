package Edtech.Proj1.Service;

import Edtech.Proj1.Model.Question;
import Edtech.Proj1.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

public interface QuestionService {
    List<Question> getRandomQuestions(int count);
}

