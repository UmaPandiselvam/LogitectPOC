package com.logitechpoc.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.logitechpoc.R;
import com.logitechpoc.common.DevicesBO;

public class DeviceAdapter extends BaseAdapter {
	
	/* created by UmamaheswariP_09/10/2015 */

	Context ctx;
	DevicesBO devicesBean;
	Holder viewHolder;

	public DeviceAdapter(Context ctx, DevicesBO data) {
		this.ctx = ctx;
		this.devicesBean = data;
	}

	@Override
	public int getCount() {
		return devicesBean.getDevices().size();
	}

	@Override
	public Object getItem(int i) {
		return null;
	}

	@Override
	public long getItemId(int i) {
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) ctx
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.device_row, viewGroup, false);
			viewHolder = new Holder();
			viewHolder.txtDeviceName = (TextView) view
					.findViewById(R.id.deviceName);
			viewHolder.txtDeviceModel = (TextView) view
					.findViewById(R.id.deviceModel);
			viewHolder.txtDeviceType = (TextView) view
					.findViewById(R.id.deviceType);
			view.setTag(viewHolder);
		} else {
			viewHolder = (Holder) view.getTag();
		}

		DevicesBO.Devices deviceInfo = devicesBean.getDevices().get(position);
		viewHolder.txtDeviceName.setText(deviceInfo.getName());
		viewHolder.txtDeviceModel.setText(deviceInfo.getModel());
		viewHolder.txtDeviceType.setText(deviceInfo.getDeviceType());

		if (position % 2 == 1) {
			view.setBackgroundColor(Color.GRAY);
		} else {
			view.setBackgroundColor(Color.LTGRAY);
		}

		return view;
	}

	class Holder {
		TextView txtDeviceName;
		TextView txtDeviceType;
		TextView txtDeviceModel;
	}
}