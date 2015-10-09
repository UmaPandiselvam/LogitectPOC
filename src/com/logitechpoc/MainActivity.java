package com.logitechpoc;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ListView;

import com.logitechpoc.adapter.DeviceAdapter;
import com.logitechpoc.common.DataMember;
import com.logitechpoc.common.DevicesBO;
import com.logitechpoc.common.LogitechPOCApp;

/* created by UmamaheswariP_09/10/2015 */

public class MainActivity extends Activity {
	private ProgressDialog pDialog;
	LogitechPOCApp logApplication;
	ListView devicelstView;
	DeviceAdapter deviceAdapter;

	DevicesBO data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		process();
	}

	private void process() {
		showpDialog();

		runOnUiThread(new Runnable() {
			public void run() {
				PopulateTheView();
			}
		});
	}

	private void init() {
		logApplication = new LogitechPOCApp(MainActivity.this);
		devicelstView = (ListView) findViewById(R.id.lstView);

		pDialog = new ProgressDialog(this);
		pDialog.setMessage("Loading...");
		pDialog.setCancelable(false);

	}

	private void showpDialog() {
		if (!pDialog.isShowing())
			pDialog.show();
	}

	private void hidepDialog() {
		if (pDialog.isShowing())
			pDialog.dismiss();
	}

	private final Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			final int what = msg.what;
			switch (what) {
			case DataMember.PARSE_DEVICE: {
				PopulateTheView();
			}
				break;
			}
		}
	};

	public void PopulateTheView() {
		String jsonValues = logApplication
				.loadJSONFromAsset(DataMember.JSON_FILE_NAME);
		Log.d("JSONValues: ", "data: " + jsonValues);
		data = (DevicesBO) logApplication.getFromJSON(jsonValues,
				DevicesBO.class);
		Log.d("DeviceSize: ", "data:" + data.getDevices().size());

		for (DevicesBO.Devices d : data.getDevices()) {
			Log.d("----", "# --------------");
			Log.d("Name :", "# " + d.getName());
			Log.d("Type :", "# " + d.getDeviceType());
			Log.d("Model:", "# " + d.getModel());
			Log.d("----", "# --------------");
		}
		deviceAdapter = new DeviceAdapter(MainActivity.this, data);
		devicelstView.setAdapter(deviceAdapter);
		hidepDialog();
	}

}
