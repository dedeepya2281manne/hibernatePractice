package com.web.model.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Question {

	@Id
	private int quesId;
	private String ques;
	
	@OneToOne
	@JoinColumn(name = "ans_id") //giving name to column
	private Answer answer;

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int quesId, String ques, Answer answer) {
		super();
		this.quesId = quesId;
		this.ques = ques;
		this.answer = answer;
	}

	
	
	
	
	
}
