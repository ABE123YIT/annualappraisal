package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ymagis.annualappraisal.model.Employee;

public class ManagerTeamDeserializer extends StdDeserializer<Set<Employee>> {

	public ManagerTeamDeserializer() {
		this(null);
	}

	public ManagerTeamDeserializer(Class<Set<Employee>> t) {
		super(t);
	}

	@Override
	public Set<Employee> deserialize(JsonParser jsonparser, DeserializationContext context)
			throws IOException, JsonProcessingException {

		return new HashSet<>();
	}
}
