package com.questionablequalitysoftware.gemoetry;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import com.questionablequalitysoftware.gemoetry.gen.model.PolygonRequest;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PolygonControllerTest {
			
    @Autowired
    private MockMvc mockMvc;
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void test13() throws Exception {
        mockMvc.perform(get("/polygon/point/inside")
        		.accept(MediaType.APPLICATION_JSON)
        		.param("n", "3")
        		.param("r", "100")
        		.param("x", "0")
        		.param("y", "0")
        		.param("offsetX", "0")
        		.param("offsetY", "0"))
//        		.andDo(print())
        		.andExpect(status().isOk())
        		.andExpect(header().string("Content-Type",MediaType.APPLICATION_JSON_UTF8.toString()))
        		.andExpect(content().string("{\"inside\":true}"));
	}

	@Test
	public void test14() throws Exception {
        mockMvc.perform(get("/polygon/point/inside")
        		.accept(MediaType.APPLICATION_JSON)
        		.param("n", "3")
        		.param("r", "100")
        		.param("x", "150")
        		.param("y", "150")
        		.param("offsetX", "0")
        		.param("offsetY", "0"))
//      		.andDo(print())
        		.andExpect(status().isOk())
        		.andExpect(header().string("Content-Type",MediaType.APPLICATION_JSON_UTF8.toString()))
        		.andExpect(content().string("{\"inside\":false}"));
	}

	@Test
	public void test15() throws Exception {
        mockMvc.perform(get("/polygon/point/inside")
        		.accept(MediaType.APPLICATION_JSON)
        		.param("n", "8")
        		.param("r", "100")
        		.param("x", "0")
        		.param("y", "0")
        		.param("offsetX", "0")
        		.param("offsetY", "0"))
//        		.andDo(print())
        		.andExpect(status().isOk())
        		.andExpect(header().string("Content-Type",MediaType.APPLICATION_JSON_UTF8.toString()))
        		.andExpect(content().string("{\"inside\":true}"));
	}

	@Test
	public void test16() throws Exception {
        mockMvc.perform(get("/polygon/point/inside")
        		.accept(MediaType.APPLICATION_JSON)
        		.param("n", "8")
        		.param("r", "100")
        		.param("x", "150")
        		.param("y", "150")
        		.param("offsetX", "0")
        		.param("offsetY", "0"))
//        		.andDo(print())
        		.andExpect(status().isOk())
        		.andExpect(header().string("Content-Type",MediaType.APPLICATION_JSON_UTF8.toString()))
        		.andExpect(content().string("{\"inside\":false}"));
	}
	
	@Test
	public void test17() throws Exception {
		PolygonRequest request = triangle();
		request.setPointX(0);
		request.setPointY(0);
	    mockMvc.perform(post("/polygon/point/inside")
	       		.contentType(MediaType.APPLICATION_JSON_UTF8)
	       		.accept(MediaType.APPLICATION_JSON)
	       		.content(mapper.writeValueAsString(request)))
//	       		.andDo(print())
	       		.andExpect(status().isOk())
	       		.andExpect(header().string("Content-Type",MediaType.APPLICATION_JSON_UTF8.toString()))
	       		.andExpect(content().string("{\"inside\":true}"));
	}

	@Test
	public void test18() throws Exception {
		PolygonRequest request = triangle();
		request.setPointX(150);
		request.setPointY(150);
	    mockMvc.perform(post("/polygon/point/inside")
	       		.contentType(MediaType.APPLICATION_JSON_UTF8)
	       		.accept(MediaType.APPLICATION_JSON)
	       		.content(mapper.writeValueAsString(request)))
//	       		.andDo(print())
	       		.andExpect(status().isOk())
	       		.andExpect(header().string("Content-Type",MediaType.APPLICATION_JSON_UTF8.toString()))
	       		.andExpect(content().string("{\"inside\":false}"));
	}

	@Test
	public void test19() throws Exception {
		PolygonRequest request = hexagon();
		request.setPointX(0);
		request.setPointY(0);
	    mockMvc.perform(post("/polygon/point/inside")
	       		.contentType(MediaType.APPLICATION_JSON_UTF8)
	       		.accept(MediaType.APPLICATION_JSON)
	       		.content(mapper.writeValueAsString(request)))
//	       		.andDo(print())
	       		.andExpect(status().isOk())
	       		.andExpect(header().string("Content-Type",MediaType.APPLICATION_JSON_UTF8.toString()))
	       		.andExpect(content().string("{\"inside\":true}"));
	}

	@Test
	public void test20() throws Exception {
		PolygonRequest request = hexagon();
		request.setPointX(150);
		request.setPointY(150);
	    mockMvc.perform(post("/polygon/point/inside")
	       		.contentType(MediaType.APPLICATION_JSON_UTF8)
	       		.accept(MediaType.APPLICATION_JSON)
	       		.content(mapper.writeValueAsString(request)))
//	       		.andDo(print())
	       		.andExpect(status().isOk())
	       		.andExpect(header().string("Content-Type",MediaType.APPLICATION_JSON_UTF8.toString()))
	       		.andExpect(content().string("{\"inside\":false}"));
	}

	
	@Test
	public void test21() {
		HttpServletRequest request = null;
		PolygonController controller = new PolygonController(mapper, request);
		assertEquals(controller.getObjectMapper(), Optional.ofNullable(mapper));
		assertEquals(controller.getRequest(), Optional.ofNullable(request));
		assertEquals(controller.getAcceptHeader(), Optional.ofNullable((String)null));
		
	}
	
	private PolygonRequest triangle() {
		PolygonRequest triangle = new PolygonRequest();
		addXY(triangle, 100, 0);
		addXY(triangle, -50, 86);
		addXY(triangle, -50, -86);
		return triangle;
	}
	
	
	private PolygonRequest hexagon() {
		PolygonRequest hexagon = new PolygonRequest();
		addXY(hexagon, 100, 0);
		addXY(hexagon, 70, 70);
		addXY(hexagon, 0, 100);
		addXY(hexagon, -70, 70);
		addXY(hexagon, -100, 0);
		addXY(hexagon, -70, -70);
		addXY(hexagon, 0, -100);
		addXY(hexagon, 70, -70);
		return hexagon;
	}	
	private void addXY(final PolygonRequest request, int x, int y) {
		request.addXItem(x);
		request.addYItem(y);
	}
}
