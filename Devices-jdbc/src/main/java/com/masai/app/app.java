package com.masai.app;

import com.masai.app.entity.Devices;
import com.masai.app.Dao.DeviceDao;
import com.masai.app.service.DeviceService;
public class app {

	public static void main(String[] args) {
		DeviceDao dao = new DeviceService();
		Devices device=new Devices(3,"pavillion","hp","laptop",(float) 98000.00,"hd","i5 12th gen","8 gb ram","Windows 10","1 tb");
		dao.createDevice(device);
		System.out.println(dao.findDevice(1));
	}

}
