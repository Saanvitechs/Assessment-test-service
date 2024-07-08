package Edtech.Proj1.Repository;

import Edtech.Proj1.Model.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
