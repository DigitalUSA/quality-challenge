package com.questionablequalitysoftware.gemoetry;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.questionablequalitysoftware.gemoetry.gen.api.CircleApi;
import com.questionablequalitysoftware.gemoetry.gen.model.CircleRequest;
import com.questionablequalitysoftware.gemoetry.gen.model.Response;

@Controller
public class CircleController implements CircleApi {
    private ObjectMapper objectMapper;

    private HttpServletRequest request;

    @Autowired
    private IInsideGeometry geometry;
    
    @Autowired
    public CircleController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

	@Override
	public Optional<String> getAcceptHeader() {
		return CircleApi.super.getAcceptHeader();
	}

	@Override
	public ResponseEntity<Response> insidePointCircle(@Valid @RequestBody CircleRequest request) {
//		System.out.println(String.format("r=%d d=%d x=%d y=%d offsetX=%d offsetY=%d", request.getR(), request.getD(), request.getX(), request.getY(), request.getPointX(), request.getPointY()));
		if (request.getR() == null) {
			request.setR(request.getD() / 2);
		}		
		Point2D p = new Point2D(request.getPointX(), request.getPointY());
		Response response = new Response();
		response.setInside(geometry.isInsideCircle(p, request.getR(), request.getX(), request.getY()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
