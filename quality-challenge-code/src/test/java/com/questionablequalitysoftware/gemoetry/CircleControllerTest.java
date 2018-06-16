package com.questionablequalitysoftware.gemoetry;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.questionablequalitysoftware.gemoetry.gen.model.CircleRequest;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CircleControllerTest {
			
    @Autowired
    private MockMvc mockMvc;
	@Autowired
	private ObjectMapper mapper;
    
	@Test
	public void test01() throws Exception {
		CircleRequest request = new CircleRequest();
		request.setR(100);
		request.setX(0);
		request.setY(0);
		request.setPointX(0);
		request.setPointY(0);
        mockMvc.perform(post("/circle/point/inside")
        		.contentType(MediaType.APPLICATION_JSON_UTF8)
        		.accept(MediaType.APPLICATION_JSON)
        		.content(mapper.writeValueAsString(request)))
//        		.andDo(print())
        		.andExpect(status().isOk())
        		.andExpect(header().string("Content-Type",MediaType.APPLICATION_JSON_UTF8.toString()))
        		.andExpect(content().string("{\"inside\":true}"));
	}
	
	@Test
	public void test02() throws Exception {
		CircleRequest request = new CircleRequest();
		request.setR(100);
		request.setX(0);
		request.setY(0);
		request.setPointX(150);
		request.setPointY(150);
        mockMvc.perform(post("/circle/point/inside")
        		.contentType(MediaType.APPLICATION_JSON_UTF8)
        		.accept(MediaType.APPLICATION_JSON)
        		.content(mapper.writeValueAsString(request)))
//        		.andDo(print())
        		.andExpect(status().isOk())
        		.andExpect(header().string("Content-Type",MediaType.APPLICATION_JSON_UTF8.toString()))
        		.andExpect(content().string("{\"inside\":false}"));
	}
	
	@Test
	public void test03() {
		HttpServletRequest request = null;
		CircleController controller = new CircleController(mapper, request);
		assertEquals(controller.getObjectMapper(), Optional.ofNullable(mapper));
		assertEquals(controller.getRequest(), Optional.ofNullable(request));
		assertEquals(controller.getAcceptHeader(), Optional.ofNullable((String)null));
	}

	@Test
	public void test01d() throws Exception {
		CircleRequest request = new CircleRequest();
		request.setD(100);
		request.setX(0);
		request.setY(0);
		request.setPointX(0);
		request.setPointY(0);
        mockMvc.perform(post("/circle/point/inside")
        		.contentType(MediaType.APPLICATION_JSON_UTF8)
        		.accept(MediaType.APPLICATION_JSON)
        		.content(mapper.writeValueAsString(request)))
//        		.andDo(print())
        		.andExpect(status().isOk())
        		.andExpect(header().string("Content-Type",MediaType.APPLICATION_JSON_UTF8.toString()))
        		.andExpect(content().string("{\"inside\":true}"));
	}
	
	@Test
	public void test02d() throws Exception {
		CircleRequest request = new CircleRequest();
		request.setD(100);
		request.setX(0);
		request.setY(0);
		request.setPointX(150);
		request.setPointY(150);
        mockMvc.perform(post("/circle/point/inside")
        		.contentType(MediaType.APPLICATION_JSON_UTF8)
        		.accept(MediaType.APPLICATION_JSON)
        		.content(mapper.writeValueAsString(request)))
//        		.andDo(print())
        		.andExpect(status().isOk())
        		.andExpect(header().string("Content-Type",MediaType.APPLICATION_JSON_UTF8.toString()))
        		.andExpect(content().string("{\"inside\":false}"));
	}

}
