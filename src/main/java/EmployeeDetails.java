import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeDetails {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Times you want to Run the Program:");
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {

			System.out.println("1. Save\n2. Update\n3. Delete\n4. Fetch All\n5. Fetch By ID\nEnter your choice:");

			int choice = sc.nextInt();

			switch (choice) {
			case 1: {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails", "root",
							"Star#789");

					String query = "insert into employee values(?,?,?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);

					Scanner s = new Scanner(System.in);

					System.out.println("Enter Employee ID:");
					int empId = sc.nextInt();

					sc.nextLine();

					System.out.println("Enter Employee Name:");
					String name = sc.nextLine();

					System.out.println("Enter Employee Salary:");
					int salary = sc.nextInt();

					sc.nextLine();

					System.out.println("Enter Employee Phone No:");
					String phno = sc.nextLine();

					System.out.println("Enter Employee Email:");
					String email = sc.nextLine();

					System.out.println("Enter Employee Address:");
					String address = sc.nextLine();

					System.out.println("Enter Employee Company:");
					String companyName = sc.nextLine();

					ps.setInt(1, empId);
					ps.setString(2, name);
					ps.setInt(3, salary);
					ps.setString(4, phno);
					ps.setString(5, email);
					ps.setString(6, address);
					ps.setString(7, companyName);

					ps.execute();

					con.close();

					System.out.println("Data Saved");

				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
				break;

			case 2: {

				Scanner sc1 = new Scanner(System.in);
				System.out.println(
						"1. Update Name\n2. Update Salary\n3. Update Phone No\n4. Update Email\nEnter your choice:");

				System.out.println("Enter Choice");
				int choice1 = sc1.nextInt();

				switch (choice1) {
				case 1: {

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails", "root",
								"Star#789");

						String query = "update employee set name=? where empid=?";

						PreparedStatement ps = con.prepareStatement(query);

						System.out.println("Enter Employee ID:");
						int empId = sc.nextInt();

						sc.nextLine();

						System.out.println("Enter Employee Updated Name:");
						String name = sc.nextLine();

						ps.setString(1, name);
						ps.setInt(2, empId);

						ps.execute();

						con.close();

						System.out.println("Name Updated");

					} catch (ClassNotFoundException e) {

						e.printStackTrace();
					} catch (SQLException e) {

						e.printStackTrace();
					}

				}

					break;
				case 2: {

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails", "root",
								"Star#789");

						String query = "update employee set salary=? where empid=?";

						PreparedStatement ps = con.prepareStatement(query);

						System.out.println("Enter Employee ID:");
						int empId = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Employee Updated Salary:");
						int salary1 = sc.nextInt();

						ps.setInt(1, salary1);
						ps.setInt(2, empId);

						ps.execute();

						con.close();

						System.out.println("Salary Updated");

					} catch (ClassNotFoundException e) {

						e.printStackTrace();
					} catch (SQLException e) {

						e.printStackTrace();
					}

				}

					break;
				case 3: {

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails", "root",
								"Star#789");

						String query = "update employee set phno=? where empid=?";

						PreparedStatement ps = con.prepareStatement(query);

						System.out.println("Enter Employee ID:");
						int empId = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Employee Updated Phone Number:");
						String phno1 = sc.nextLine();

						ps.setString(1, phno1);
						ps.setInt(2, empId);

						ps.execute();

						con.close();

						System.out.println("Phone Number Updated");

					} catch (ClassNotFoundException e) {

						e.printStackTrace();
					} catch (SQLException e) {

						e.printStackTrace();
					}

				}

					break;

				case 4: {

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails", "root",
								"Star#789");

						String query = "update employee set email=? where empid=?";

						PreparedStatement ps = con.prepareStatement(query);

						System.out.println("Enter Employee ID:");
						int empId = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Employee Updated Email:");
						String email1 = sc.nextLine();

						ps.setString(1, email1);
						ps.setInt(2, empId);

						ps.execute();

						con.close();

						System.out.println("Email Updated");

					} catch (ClassNotFoundException e) {

						e.printStackTrace();
					} catch (SQLException e) {

						e.printStackTrace();
					}

				}
					break;

				default:
					break;
				}

			}
				break;

			case 3: {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails", "root",
							"Star#789");

					String query = "delete from employee  where empid=?";

					PreparedStatement ps = con.prepareStatement(query);

					System.out.println("Enter Employee ID:");
					int empId = sc.nextInt();

					ps.setInt(1, empId);

					ps.executeUpdate();

					con.close();

					System.out.println("Row Deleted");

				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
				break;
			case 4: {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails", "root",
							"Star#789");
					String query = "select * from employee";
					PreparedStatement ps = con.prepareStatement(query);

					ps.execute();

					ResultSet rs = ps.getResultSet();

					while (rs.next()) {

						System.out.println(rs.getInt(1));
						System.out.println(rs.getString(2));
						System.out.println(rs.getInt(3));
						System.out.println(rs.getString(4));
						System.out.println(rs.getString(5));
						System.out.println(rs.getString(6));
						System.out.println(rs.getString(7));
						System.out.println("---------------");
					}
					con.close();

					System.out.println("Data Fetched");
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
				break;
			case 5: {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdetails", "root",
							"Star#789");
					String query = "select * from employee where empid=?";
					PreparedStatement ps = con.prepareStatement(query);

					System.out.println("Enter Employee ID:");

					int empId = sc.nextInt();

					ps.setInt(1, empId);

					ps.execute();

					ResultSet rs = ps.getResultSet();

					while (rs.next()) {

						System.out.println(rs.getInt(1));
						System.out.println(rs.getString(2));
						System.out.println(rs.getInt(3));
						System.out.println(rs.getString(4));
						System.out.println(rs.getString(5));
						System.out.println(rs.getString(6));
						System.out.println(rs.getString(7));
						System.out.println("---------------");
					}
					con.close();

					System.out.println("Data Fetched");
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
				break;
			}
		}
	}
}
