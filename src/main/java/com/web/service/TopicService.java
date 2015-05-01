package com.web.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TopicService {

	private static Map<String, Topic> cache = new ConcurrentHashMap<String, Topic>();

	public static List<Topic> searchByTitle(String q) {
		List<Topic> topics = new LinkedList<Topic>();
		if (q != null) {
			Iterator<String> reader = cache.keySet().iterator();
			while (reader.hasNext()) {
				String index = reader.next();
				Topic topic = cache.get(index);

				if (topic.getTitle().toLowerCase().contains(q.toLowerCase())) {
					topics.add(topic);

				}
			}
		}
		return topics;
	}
	
	public static Topic createTopic(String title){
		Topic topic = new Topic();
		topic.setTitle(title);
		return topic;
	}
	

}
