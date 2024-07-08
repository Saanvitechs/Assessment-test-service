package Edtech.Proj1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Edtech.Proj1.Model.Question;
import Edtech.Proj1.Model.QuestionResponse;
import Edtech.Proj1.Model.User;
import Edtech.Proj1.Repository.QuestionRepository;
import Edtech.Proj1.Repository.UserRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuesService {

	@Autowired
	private QuestionRepository questionRepository;

	public List<Question> getRandomQuestions(int numberOfQuestions) {
		List<Question> questions = questionRepository.findAll();
		if (questions.size() <= numberOfQuestions) {
			return questions; // Return all questions if there are fewer than the requested number
		}
		Collections.shuffle(questions);
		return questions.stream().limit(numberOfQuestions).collect(Collectors.toList());
	}
	
	public int calculateScore(List<QuestionResponse> responses) {
        int score = 0;
        for (QuestionResponse response : responses) {
            int questionId = response.getQuestionId();
            String selectedOption = response.getSelectedOption();
            String correctOption = findCorrectAnswer(questionId);
System.out.println("hello sb" +selectedOption +"  corr  "+ correctOption+"  "+questionId);
            if (correctOption != null && correctOption.equals(selectedOption)) {
            	System.out.println("hi");
                score++;
            }
        }
        return score;
    }
	
	 
	private String findCorrectAnswer(int quesId) {
	Optional<Question> questions = questionRepository.findById(quesId);
	//System.out.println("Question From DB "+questions.get());
       
            if (questions.isPresent()) {
                return questions.get().getCorrectAnswer();
                
            }
            else {
        
        return "0";
            }
        
    }
	
	 @Autowired
	  private UserRepository userRepository;

	    public void saveUserScore(int userId, int score) {
	        User user = new User();
	        user.setUserId(10);
	        user.setScore(score);
	        user.setCreatedAt(new Date()); 

	        userRepository.save(user);
	    }
}
