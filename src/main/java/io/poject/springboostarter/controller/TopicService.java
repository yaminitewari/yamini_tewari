package io.poject.springboostarter.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepo repo;
	
	private List<Topic> topics = new ArrayList<> (Arrays.asList(new Topic("spring", "SpringFramework", "SpringFrameworkDescription"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "Javascript", "JavascriptDescription")));
	
	public List<Topic> getAllTopics(){
		//return topics;
		return (List<Topic>) repo.findAll();
	}
	


	public Topic getTopic(String id) {
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		Optional<Topic> topic= repo.findById(id);
		return topic.get();
			
		
	}

	public void addTopic(Topic topic) {

		repo.save(topic);
		
	}


	public void updateTopic(Topic topic, String id) {
     
	/*for (int i = 0; i< topics.size();i++) {
		Topic topic1=topics.get(i);
		if(topic1.getId().equals(id)){
			topics.set(i, topic);
			return;
		}
		
	}*/
		
		Optional<Topic> topic2=repo.findById(id);
		topic.setId(id);
		repo.save(topic);
		
		
		
		
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t-> t.getId().equals(id));
		
		repo.deleteById(id);
		
	}
}