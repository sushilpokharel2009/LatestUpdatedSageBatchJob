package com.uvk.readwrite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.capitalone.sage.batch.bean.ReconDTO;

public class DatabaseItemReader implements ItemReader<ReconDTO> {

	private int nextVendorIndex;

	private List<ReconDTO> vendors = new ArrayList<ReconDTO>();

	DatabaseItemReader() {
		initialize();
	}

	private void initialize() {

		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			// protocol://ipaddress:portnumber/databasename
			String url = "jdbc:mysql://localhost:3306/shubhaDB";
			Connection conn = DriverManager.getConnection(url, "root", "");
			Statement stmt = conn.createStatement();
			ResultSet rs;
			
				rs = stmt.executeQuery("SELECT id, accountNumber, routingNumber from Sage100BJ");
				while (rs.next()) {
					ReconDTO vendor = new ReconDTO();
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String accountNumber = rs.getString("accountNumber");
					String routingNumber = rs.getString("routingNumber");

					vendor.setId(id);
					vendor.setName(name);
					vendor.setBankAccountNumber(accountNumber);
					vendor.setRoutingNumber(routingNumber);

					System.out.println("vendor : " + vendor);

					vendors.add(vendor);
				}

			/*
			 * ResultSet rs2;
			 * 
			 * rs2 =
			 * stmt.executeQuery("SELECT id, accountNumber, routingNumber from Test3");
			 * while ( rs2.next() ) { Vendor vendor = new Vendor(); int id =
			 * rs2.getInt("id"); String accountNumber = rs2.getString("accountNumber");
			 * String routingNumber = rs2.getString("routingNumber");
			 * 
			 * vendor.setId(id); vendor.setAccountNumber(accountNumber);
			 * vendor.setRoutingNumber(routingNumber);
			 * 
			 * System.out.println("vendor : "+vendor);
			 * 
			 * vendors.add(vendor); }
			 */

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		nextVendorIndex = 0;
	}

	public ReconDTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		ReconDTO vendor = null;

		if (nextVendorIndex < vendors.size()) {
			vendor = vendors.get(nextVendorIndex);
			nextVendorIndex++;
		}

		return vendor;
	}

	/*
	 * public static void main(String[] args) { DatabaseItemReader dr = new
	 * DatabaseItemReader(); dr.initialize();
	 * 
	 * //System.out.println("vendor list size: "+dr.vendors.size()); }
	 */
}
