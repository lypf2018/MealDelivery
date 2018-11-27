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
		int rows = 0;
		if (dish.getName() != null) {
			mySQLJDBC.setPreparedSql("insert into dish(name, description, picture, price, categoryid) values(?,?,?,?,?);",
					dish.getName(),dish.getDes(),dish.getPic(),dish.getPrice(),dish.getDCId());
			rows = mySQLJDBC.executeUpdate();
			mySQLJDBC.close();
		}
		mySQLJDBC.close();
		return rows;
	}
	
	/**
	 * update a previous dish info in the database
	 * check if dish_id exists, if dish exists, execute update operation
	 * check if the dish exist, if exist:
	 * 		check if any value has been changed, if not, remain the previous value
	 */
	
	public int updateDish(Dish dish) {
		int id = dish.getId();
		int rows = 0;
//		System.out.println("---------------Update_Dish---------------");
//		System.out.println(dish.getName());
//		System.out.println(dish.getDes());
//		System.out.println(dish.getPic());
//		System.out.println(dish.getPrice());
//		System.out.println(dish.getDCId());
		mySQLJDBC.setPreparedSql("select * from dish where did = ?;", id);
		ResultSet rs = mySQLJDBC.excuteQuery();
		try {
			// cannot use mySQLJDBC.executeUpdate() for select, so we use re.last()&rs.getRow() to get the length of rs
			rs.last();
			if(rs.getRow() == 1) {
				String name = dish.getName() != rs.getString("name") ? dish.getName(): rs.getString("name");
				String des = dish.getDes() != rs.getString("description") ? dish.getDes(): rs.getString("description");
				String pic = dish.getPic() != null ? dish.getPic(): rs.getString("picture");
				double price = dish.getPrice() != rs.getDouble("price") ? dish.getPrice(): rs.getDouble("price");
				int dcid = dish.getDCId() != rs.getInt("categoryid") ? dish.getDCId(): rs.getInt("categoryid");
				
				mySQLJDBC.setPreparedSql("update dish set name=?, description=?, picture=?, price=?, categoryid=? WHERE did=?;", 
						name, des, pic, price, dcid, id);
				rows = mySQLJDBC.executeUpdate();
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mySQLJDBC.close();
//		System.out.println("update affect rows = "+rows);
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
	public List<Dish> sort(String name) {
		List<Dish> list = new ArrayList<Dish>();
		if(name.equals("price")) {
			mySQLJDBC.setPreparedSql("select * from dish order by price;");
		} else if(name.equals("id")) {
			mySQLJDBC.setPreparedSql("select * from dish order by did;");
		} else if(name.equals("name")) {
			mySQLJDBC.setPreparedSql("select * from dish order by name;");
		} else if(name.equals("category")) {
			mySQLJDBC.setPreparedSql("select * from dish order by categoryid;");
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
}
