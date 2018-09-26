/**
 * 
 */
package domain.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.bean.Customer;
import util.MySQLJDBC;

/**
 * @author lypf2018
 * Customer DAO class, including methods to access customer in database.
 *
 */
public class CustomerDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	/**
	 * customer registration method.
	 * If customer email exists, customer cannot be registered.
	 * 
	 * @param customer customer to be registered
	 * @return register status, either true for success or false for failure
	 */
	public boolean register(Customer customer) {
		if (customerEmailExist(customer)) {
			return false;
		} else {
			return insertCustomer(customer);
		}
	}
	
	/**
	 * verify whether customer email exists or not.
	 * 
	 * @param customer customer to be verified
	 * @return existence status, either true for success or false for failure
	 */
	private boolean customerEmailExist(Customer customer) {
		boolean customerEmailExist = false;
		mySQLJDBC.setPreparedSql("select cid from customer where email=?;", customer.getEmail());
		ResultSet resultSet = mySQLJDBC.excuteQuery();
		try {
			customerEmailExist = resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerEmailExist;
	}

	/**
	 * insert customer information into database.
	 * 
	 * @param customer customer to be inserted
	 * @return insert status, either true for success or false for failure
	 */
	private boolean insertCustomer(Customer customer) {
		if (customer.getEmail() != null && customer.getEmail().length() > 0) {
			mySQLJDBC.setPreparedSql("insert into customer(email,password,firstname,lastname,street,city,state,zip,phone) values(?,?,?,?,?,?,?,?,?);",
					customer.getEmail(), customer.getPassword(), customer.getFirstName(), customer.getLastName(),
					customer.getStreet(), customer.getCity(), customer.getState(), customer.getZip(), customer.getPhone());
			mySQLJDBC.executeUpdate();
			return true;
		}
		return false;
	}

	/**
	 * Validate customer's email and password.
	 * If information matches in database, return a customer object.
	 * Otherwise, return null.
	 * 
	 * @param customer customer information including email and password
	 * @return either (1) customer object 
	 *         or (2) null.
	 */
	public Customer validateCustomer(Customer customer) {
		mySQLJDBC.setPreparedSql("select cid,firstname,lastname,street,city,state,zip,phone from customer where email=? and password=?", customer.getEmail(), customer.getPassword());
		ResultSet resultSet = mySQLJDBC.excuteQuery();
		try {
			if ((resultSet != null) && (resultSet.next())) {
				customer.setId(resultSet.getInt("cid"));
				customer.setFirstName(resultSet.getString("firstname"));
				customer.setLastName(resultSet.getString("lastname"));
				customer.setStreet(resultSet.getString("street"));
				customer.setCity(resultSet.getString("city"));
				customer.setState(resultSet.getString("state"));
				customer.setZip(resultSet.getString("zip"));
				customer.setPhone(resultSet.getString("phone"));
				return customer;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Before releasing resources, execute mySQLJDBC.close() method to ensure
	 * this.preparedStatement and this.connection has been closed 
	 */
	protected void finalize() throws Throwable {
		mySQLJDBC.close();
		super.finalize();
	}

}
