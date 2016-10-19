package br.com.cit.resteasy.exceptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

@Provider
@Component
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

	public Response toResponse(BusinessException exception) {
		final Map<String, List<String>> result = new HashMap<String, List<String>>();
		result.put("erro", Arrays.asList(exception.getMessage()));
		return Response.status(Status.BAD_REQUEST).entity(result).build();
	}

}
