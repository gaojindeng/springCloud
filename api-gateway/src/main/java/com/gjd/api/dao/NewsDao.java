package com.gjd.api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.gjd.api.common.RestResponse;
import com.gjd.api.dto.UserNews;
import com.gjd.api.model.News;
import com.gjd.api.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Repository
@DefaultProperties(groupKey="newsDao",
commandProperties={@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")},
threadPoolProperties={@HystrixProperty(name="coreSize",value="10")
,@HystrixProperty(name="maxQueueSize",value="1000")},
threadPoolKey="newsDao"
)
public class NewsDao {

	@Autowired
	private RestTemplate restTemplate;
	
	public int insert(News news){
		return restTemplate.postForObject("http://news/news/insert", news, Integer.class);
	}
	
	@HystrixCommand
	public UserNews queryOne(int id){
		Map<String,Integer> map = new HashMap<>();
		map.put("id", id);
		UserNews response = restTemplate.getForObject("http://news/news/query?id={id}", UserNews.class, map);
		return response;
	}
	
	@HystrixCommand(fallbackMethod = "errFallback")
	public List<News> queryAll(){
		List<News> response = restTemplate.getForObject("http://news/news/list", List.class);
		return response;
	}
	/**
	 * 有降级方法，但是用户线程池用完了的话，还是会启动短路器。并且一定的时间段调用还是会拒绝所有请求，当这个请求时间过了的时候，等下一次请求正常访问，断路器才会关闭
	 * @return
	 */
	public List<News> errFallback(){
		return null;
	}
}
