/*
 * SpagoBI, the Open Source Business Intelligence suite
 * � 2005-2015 Engineering Group
 *
 * This file is part of SpagoBI. SpagoBI is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 2.1 of the License, or any later version. 
 * SpagoBI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details. You should have received
 * a copy of the GNU Lesser General Public License along with SpagoBI. If not, see: http://www.gnu.org/licenses/.
 * The complete text of SpagoBI license is included in the COPYING.LESSER file. 
 */
package it.eng.spagobi.utilities.service;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import it.eng.spagobi.utilities.assertion.Assert;

/**
 * @author Andrea Gioia (andrea.gioia@eng.it)
 *
 */
public class JSONResponse implements IServiceResponse {

	int statusCode;
	String content;
	String callback;
	
	
	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public static int ACKNOWLEDGE = 200;
	public static int SUCCESS = 200;
	public static int FAILURE = 500;
	
		
	JSONResponse() {}
	
	public JSONResponse(int statusCode, JSONObject content, String callback) {
		this(statusCode, content);
		this.callback = callback;
	}
	
	public JSONResponse(int statusCode, JSONArray content, String callback) {
		this(statusCode, content);
		this.callback = callback;
	}

	public JSONResponse(int statusCode, String content, String callback) {
		this(statusCode, content);
		this.callback = callback;
	}

	
	public JSONResponse(int statusCode, JSONObject content) {
		setStatusCode( statusCode );
		setContent( content.toString() );
	}
	
	public JSONResponse(int statusCode, JSONArray content) {
		setStatusCode( statusCode );
		setContent( content.toString() );
	}

	public JSONResponse(int statusCode, String content) {
		setStatusCode( statusCode );
		JSONObject o = null;
		try {
			o = new JSONObject("{text: " + content + "}");
		} catch (JSONException e) {
			e.printStackTrace();
			Assert.assertUnreachable("Default json object generated to wrap a simple text response is not well formed");
		}
		setContent( o.toString() );
	}

	private void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	private void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() throws IOException {
		String str = "";
		if(callback != null) str += callback + "(";
		str += content;
		if(callback != null) str += ");";
		return str;
	}

	

	
	public String getContentType() {		
		String contentType;
		
		contentType = callback != null? "text/javascript": "application/x-json";
		contentType += "; charset=utf-8";
		
		return contentType;
	}

	public boolean isInline() {
		return true;
	}
	
	public String getFileName() {
		return "response";
	}
}
