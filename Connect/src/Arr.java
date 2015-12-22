import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
public class Arr {

	
        List<Person> List() throws SQLException {
		// TODO Auto-generated method stub
		
		List<Person> persons = new ArrayList<Person>();
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new", "root", "ςυνγρεεψε7");

		 st = con.createStatement();

			rs = st.executeQuery("select * from person");
           
			int i=0;
			
			while (rs.next()) {
				Person p=ret(rs);
			
				persons.add(p);
			
				System.out.println(persons.get(i).getN());
				i++;
			}
			
			
			return persons;
			

		} finally {
			st.close();
			rs.close();
		}
		
		


	
	
	}
	
	
	
	



	static Person ret(ResultSet rs) throws SQLException{
		String name=rs.getString("name");
		
	String sur=rs.getString("surname");
	
	int age=rs.getInt("age");
	
	Person p=new Person(name,sur,age);
	return p;
		
		
		
		
		
		
	}
}
