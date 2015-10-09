package com.logitechpoc.common;

import android.app.Application;
import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

import com.google.gson.Gson;

/* created by UmamaheswariP_09/10/2015 */

public class LogitechPOCApp extends Application {
	public Context ctx;

	public LogitechPOCApp(Context context) {
		ctx = context;
	}

	public String loadJSONFromAsset(String fileName) {
		String json = null;
		try {
			InputStream is = ctx.getAssets().open(fileName);
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			json = new String(buffer, "UTF-8");
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return json;
	}

	public String getToJSON(Object src) {
		Gson gDataBean = new Gson();
		return gDataBean.toJson(src);
	}

	public Object getFromJSON(String responseValue, Class<?> classname) {
		Gson gDataBean = new Gson();
		return gDataBean.fromJson(responseValue, classname);
	}
}
