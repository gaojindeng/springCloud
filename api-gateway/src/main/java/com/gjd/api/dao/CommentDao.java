package com.gjd.api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.gjd.api.common.RestResponse;
import com.gjd.api.dto.CommentUser;
import com.gjd.api.model.Comment;
import com.gjd.api.model.News;

@Repository
public class CommentDao {

	@Autowired
	private RestTemplate restTemplate;

	public int insert(Comment comment) {
		int response = restTemplate.postForObject("http://comment/comment/insert", comment, Integer.class);
		return response;
	}

	public List<CommentUser> queryAll(int nid) {
		Map<String, Integer> map = new HashMap<>();
		map.put("nid", nid);
		List<CommentUser> response = restTemplate.getForObject("http://comment/comment/list?nid={nid}", List.class,
				map);
		return response;
	}
}
