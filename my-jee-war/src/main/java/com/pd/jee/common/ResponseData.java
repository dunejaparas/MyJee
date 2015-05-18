package com.pd.jee.common;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response")
public class ResponseData {

    @XmlElement
    protected Status code;

    @XmlElement
    protected String error;

    @XmlElement
    private Object[] parameters;

    public ResponseData(final Status code, final String error,
	    final Object... parameters) {
	this.code = code;
	this.error = error;
	this.parameters = parameters;
    }

    public ResponseData() {
    }

    public Status getCode() {
	return code;
    }

    public void setCode(final Status code) {
	this.code = code;
    }

    public String getError() {
	return error;
    }

    public void setError(final String error) {
	this.error = error;
    }

    public Object[] getParameters() {
	return parameters;
    }

    public void setParameters(final Object[] parameters) {
	this.parameters = parameters;
    }

}
