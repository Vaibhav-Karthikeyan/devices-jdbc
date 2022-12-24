package com.masai.app.Dao;

import com.masai.app.entity.Devices;
public interface DeviceDao {
	public int createDevice(Devices device);
	
	public int deleteDevice(int no);
	
	public Devices findDevice(int no);
}
