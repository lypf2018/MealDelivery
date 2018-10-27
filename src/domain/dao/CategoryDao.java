package domain.dao;

import util.MySQLJDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.bean.Category;

/**
 * @author dailu
 *  Category DAO class, including add, edit, delete, show methods of dish in database.
 *
 */

public class CategoryDao {
	private MySQLJDBC mySQLJDBC = new MySQLJDBC();
	
	public List<Category> selectCategory() {
		List<Category> list = new ArrayList<Category>();
		mySQLJDBC.setPreparedSql("select * from category order by catid;");
		ResultSet rs = mySQLJDBC.excuteQuery();
		try {
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("catid"));
				category.setName(rs.getString("name"));
				category.setDes(rs.getString("description"));
				list.add(category);
				
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
