package com.questionablequalitysoftware.gemoetry;



import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.questionablequalitysoftware.gemoetry.gen.api.PolygonApi;
import com.questionablequalitysoftware.gemoetry.gen.model.PolygonRequest;
import com.questionablequalitysoftware.gemoetry.gen.model.Response;

@Controller
public class PolygonController implements PolygonApi {
	
    private ObjectMapper objectMapper;

    private HttpServletRequest request;
    
    @Autowired
    private IInsideGeometry geometry;

    @Autowired
    public PolygonController(ObjectMapper objectMapper, HttpServletRequest request) {
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
		return PolygonApi.super.getAcceptHeader();
	}

	@Override
	public ResponseEntity<Response> insideRegularPolygon(Integer x, Integer y, Integer n, Integer r,  Integer offsetX, Integer offsetY) {
		Point2D p = new Point2D(x, y);
		Response response = new Response();
		response.inside(geometry.isInsideRegularPolygon(p, n, r, offsetX, offsetY));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Response> pointPolygon(@Valid @RequestBody PolygonRequest request) {
		Integer xArr[] = toArray(request.getX());
		Integer yArr[] = toArray(request.getY());
		Point2D polygon[] = new Point2D[xArr.length];
		for (int i = 0; i < xArr.length; i++) {
			polygon[i] = new Point2D(xArr[i], yArr[i]);
		}
		Point2D p = new Point2D(request.getPointX(), request.getPointY());
		Response response = new Response();
		response.inside(geometry.isInsidePolygon(p, polygon));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	private Integer[] toArray(List<Integer> values) {
		Integer [] ret = new Integer[values.size()];
		return values.toArray(ret);
	}
	
}
