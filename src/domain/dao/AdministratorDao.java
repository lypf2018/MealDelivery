/**
 * 
 */
package domain.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.bean.Administrator;
import util.MySQLJDBC;

/**
 * @author lypf2018
 * Administrator DAO class, including methods to access Administrator in database.
 *
 */
public class AdministratorDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	/**
	 * Validate administrator's username and password.
	 * If information matches in database, return a administrator object.
	 * Otherwise, return null.
	 * 
	 * @param administrator administrator information including username and password
	 * @return either (1) administrator object 
	 *         or (2) null.
	 */
	public Administrator validateAdministrator(Administrator administrator) {
		mySQLJDBC.setPreparedSql("select aid from admin where username=? and password=?", administrator.getUsername(), administrator.getPassword());
		ResultSet resultSet = mySQLJDBC.excuteQuery();
		try {
			if ((resultSet != null) && (resultSet.next())) {
				administrator.setId(resultSet.getInt("aid"));
				return administrator;
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
