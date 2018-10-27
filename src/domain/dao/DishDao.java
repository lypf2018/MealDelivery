package domain.dao;

import util.MySQLJDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.bean.Dish;

/**
 * @author dailu
 *  Category DAO class, including add, edit, delete, show methods of dish in database.
 *
 */

public class DishDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	public List<Dish> selectDish() {
		List<Dish> list = new ArrayList<Dish>();
		mySQLJDBC.setPreparedSql("select * from dish order by did;");
		ResultSet rs = mySQLJDBC.excuteQuery();
		try {
			while(rs.next()) {
				Dish dish = new Dish();
				dish.setId(rs.getInt("did"));
				dish.setName(rs.getString("name"));
				dish.setDes(rs.getString("description"));
				dish.setDCId(rs.getInt("categoryid"));
				dish.setPic(rs.getString("picture"));
				dish.setPrice(rs.getDouble("price"));
				list.add(dish);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		mySQLJDBC.close();
//		for(Category cate : list) {
//			System.out.println(cate.getId());
//			System.out.println(cate.getName());
//			System.out.println(cate.getDes());
//			System.out.println("-------------------------");
//		}
		return list;
	}
	
}
