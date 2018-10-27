package domain.dao;

import util.MySQLJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.bean.Dish;

/**
 * @author dailu
 *  Admin_Dish DAO class, including add, edit, delete, show methods of dish in database.
 *
 */

public class AdminDishDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();

	/**
	 * select all dish from database
	 * pageSize -> records per page
	 * pageCount -> total number of pages
	 * rowCount -> total number of records in db
	 * pageNow -> current page, which is a parameter that we get from jsp page
	 */
	
	public List<Dish> selectDish(int id) {
		List<Dish> list = new ArrayList<Dish>();
		if(id == 0) {
			mySQLJDBC.setPreparedSql("select * from dish order by did;");
		}else {
			mySQLJDBC.setPreparedSql("select * from dish where did = ?;", id);
		}	
		ResultSet rs = mySQLJDBC.excuteQuery();
		try {
			while(rs.next()) {
				int dish_id = rs.getInt("did");
				String dish_name = rs.getString("name");
				String dish_des = rs.getString("description");
				String dish_pic = rs.getString("picture");
				double dish_price = rs.getDouble("price");
				int dish_cat_id = rs.getInt("categoryid");
				Dish dish = new Dish();
				dish.setId(dish_id);
				dish.setName(dish_name);
				dish.setDes(dish_des);
				dish.setPic(dish_pic);
				dish.setPrice(dish_price);
				dish.setDCId(dish_cat_id);
				list.add(dish);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		mySQLJDBC.close();
		return list;
	}
	
	
	/**
	 * insert a new dish into database
	 * check if dish name is null, if not null, execute insert operation
	 */
	
	public int insertDish(Dish dish) {
		// dish name cannot be null
		int rows = 0;
//		System.out.println("---------------Insert_Dish---------------");
//		System.out.println(dish.getName());
//		System.out.println(dish.getDes());
//		System.out.println(dish.getPic());
//		System.out.println(dish.getPrice());
//		System.out.println(dish.getDCId());
		if (dish.getName() != null) {
			mySQLJDBC.setPreparedSql("insert into dish(name, description, picture, price, categoryid) values(?,?,?,?,?);",
					dish.getName(),dish.getDes(),dish.getPic(),dish.getPrice(),dish.getDCId());
			rows = mySQLJDBC.executeUpdate();
			mySQLJDBC.close();
		}
		mySQLJDBC.close();
		System.out.println("insert affect rows = "+rows);
		return rows;
	}
	
	/**
	 * delete a dish from database
	 * check if dish_id exists, if dish exists, execute delete operation
	 */
	
	public int deleteDish(int dish_id) {
		int rows = 0;
		mySQLJDBC.setPreparedSql("select * from dish where did = ?;", dish_id);
		ResultSet rs = mySQLJDBC.excuteQuery();
		try {
			rs.last();
			if(rs.getRow() == 1) {
				mySQLJDBC.setPreparedSql("delete from dish where did = ?;",dish_id);
				rows = mySQLJDBC.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		mySQLJDBC.close();
		System.out.println("delete affect rows = "+rows);
		return rows;
	}
}
