package com.masai.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.masai.app.Dao.DeviceDao;
import com.masai.app.entity.Devices;

public class DeviceService implements DeviceDao {
	
	private String url = "jdbc:mysql://localhost:3306/device";
    private String uname = "root";
    private String pass = "root";
	public int createDevice(Devices device) {
		int i=0;
		try
		{
	    String query= "insert into Devices values(?,?,?,?,?,?,?,?,?,?)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(url, uname, pass);
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,device.getId());
        st.setString(2, device.getBrand());
        st.setString(3,device.getCamera_spec());
        st.setString(4, device.getMemory_spec());
        st.setString(5,device.getModel());
        st.setString(6,device.getOs_sspec());
        st.setFloat(7, device.getPrice());
        st.setString(8, device.getProcessor_spec());
        st.setString(9, device.getSize_spec());
        st.setString(10, device.getType());
        i = st.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int deleteDevice(int no) {
		try
		{
	    String query= "delete from Devices  where id= "+no;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        return st.executeUpdate(query);
		}		
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Devices findDevice(int no) {
		Devices device=new Devices();
		try
		{
	    String query= "select * from Devices where id= "+no;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next()) {
        Devices devices=new Devices(rs.getInt("id"),rs.getString("model"),rs.getString("brand"),rs.getString("type"),rs.getFloat("price"),rs.getString("camera_spec"),rs.getString("processor_spec"),rs.getString("memory_spec"),rs.getString("os_sspec"),rs.getString("size_spec"));
		return devices;
        }
        }
		catch(Exception e) {
			e.printStackTrace();
		}
		return device;
	}
}
