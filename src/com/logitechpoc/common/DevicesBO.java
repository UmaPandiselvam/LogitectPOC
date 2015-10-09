package com.logitechpoc.common;

import java.util.ArrayList;

/* created by UmamaheswariP_09/10/2015 */

public class DevicesBO {
	ArrayList<Devices> devices;

	public DevicesBO() {
		devices = new ArrayList<Devices>();
	}

	public ArrayList<Devices> getDevices() {
		return devices;
	}

	public void setDevices(ArrayList<Devices> devices) {
		this.devices = devices;
	}

	public class Devices {
		private String deviceType;
		private String model;
		private String name;

		public Devices() {
			deviceType = "";
			model = "";
			name = "";
		}

		public String getDeviceType() {
			return deviceType;
		}

		public void setDeviceType(String deviceType) {
			this.deviceType = deviceType;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
