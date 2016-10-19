package br.com.cit.resteasy.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.api.validation.ResteasyViolationException;
import org.springframework.stereotype.Component;

@Provider
@Component
public class ResteasyViolationExceptionMapper implements ExceptionMapper<ResteasyViolationException> {

	public Response toResponse(ResteasyViolationException exception) {
		final Map<String, List<String>> result = new HashMap<String, List<String>>();
		final List<String> erros = new ArrayList<String>();

		for (final ConstraintViolation<?> violation : exception.getConstraintViolations()) {
			erros.add(violation.getMessage());
		}
		result.put("Erro", erros);
		return Response.status(Status.BAD_REQUEST).entity(result).build();
	}

}
