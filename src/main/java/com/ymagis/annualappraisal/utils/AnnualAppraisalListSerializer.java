package com.ymagis.annualappraisal.utils;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ymagis.annualappraisal.model.AnnualAppraisal;

public class AnnualAppraisalListSerializer extends StdSerializer<List<AnnualAppraisal>> {

	public AnnualAppraisalListSerializer() {
		this(null);
	}

	public AnnualAppraisalListSerializer(Class<List<AnnualAppraisal>> t) {
		super(t);
	}

	@Override
	public void serialize(List<AnnualAppraisal> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		generator.writeStartArray();
		for (AnnualAppraisal item : items) {
			generator.writeStartObject();
			generator.writeNumberField(Constants.COL_ID, item.getId());
			generator.writeObjectField(Constants.COL_APPRAISAL_DATE, item.getAppraisalDate());
			generator.writeStringField(Constants.COL_STRENGHTS, item.getStrenghts());
			generator.writeStringField(Constants.COL_IMPROVED, item.getImproved());
			generator.writeStringField(Constants.COL_STATUS, item.getStatus());
			generator.writeStringField(Constants.COL_ADDITIONAL_FEEDBACK, item.getAdditionalFeedback());
			generator.writeStringField(Constants.COL_EMPLOYEE_WISH, item.getEmployeeWish());
			generator.writeStringField(Constants.COL_MANAGER_OPINION, item.getManagerOpinion());
			generator.writeObjectField(Constants.COL_CREATED, item.getCreated());
			generator.writeObjectField(Constants.COL_UPDATED, item.getUpdated());
			generator.writeEndObject();
		}
		generator.writeEndArray();
	}
}
