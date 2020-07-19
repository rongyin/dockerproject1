package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
class DemoApplicationTests {
	@Resource
	private QueueProducer queueProducer;

	@Test
	void contextLoads() {
	}
	@Test
	public void testSend() throws  Exception{
		queueProducer.produceMsg();
	}
}
