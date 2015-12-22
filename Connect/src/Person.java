import java.sql.*;
import java.util.ArrayList;

public class Person {
	static String name;
	static String surname;
	static int age;

	public static void ins(Person p) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new", "root", "ςυνγρεεψε7");

			Statement st = con.createStatement();

			String y = "insert into person" + "(name,surname,age)" + "values('" + p.name + "','" + p.surname + "','"
					+ p.age + "')";

			System.out.println(y);
			st.executeUpdate(y);

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}
	
	public Person(String name,String surname,int age){
		this.name=name;
		this.surname=surname;
		this.age=age;
		
	}

	public static String getN() {
		return name;
	}

	public String getS() {
		return surname;
	}

	public int getA() {
		return age;
	}

}
