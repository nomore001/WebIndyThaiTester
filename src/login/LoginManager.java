package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.MySQLConnectionPool;
import fillRegisterProfile.LoginBean;
import fillRegisterProfile.TraineeBean;

public class LoginManager {
	private static LoginManager instance = null;

	public synchronized static LoginManager getInstance() {
		if (instance == null) {
			return instance = new LoginManager();
		}
		return instance;
	}

	public synchronized boolean verifyLogin(LoginBean login) {

		String query = "SELECT * FROM login where username = '"
				+ login.getUsername() + "' and password = '"+login.getPassword()+"';";

		Connection conn = MySQLConnectionPool.getConnection();
		try {

			// create the java statement

			PreparedStatement st = conn.prepareStatement(query);

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			String username = null;
			String password = null;
			while (rs.next()) {

				username = rs.getString("username");
				password = rs.getString("password");
				System.out.println(username + password);

			}

			if (login.getUsername().equals(username)) {
				if (login.getPassword().equals(password)) {
					return true;
				}
			}
			st.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public synchronized String searchUserAccessStatus(String username) {
		String userStatus = null;
		Connection conn = MySQLConnectionPool.getConnection();
		try {
			String query = "SELECT * FROM login where username = '" + username
					+ "'";

			// create the java statement

			PreparedStatement st = conn.prepareStatement(query);

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {
				userStatus = rs.getString("status");

			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// --------------------------------------
		// for (int i = 0; i < this.getTraineeVector().size(); i++) {
		// if (this.getTraineeVector().elementAt(i).getLogin().getUsername()
		// .equals(username)) {
		// return this.getTraineeVector().elementAt(i).getLogin()
		// .getStatus();
		// }
		// }
		return userStatus;
	}

	public synchronized TraineeBean searchTraineeByUsername(String username) {
		TraineeBean trainee = new TraineeBean();
		Connection conn = MySQLConnectionPool.getConnection();
		try {
			String query = "SELECT * FROM login l join trainee t on (l.Trainee_ID=t.Trainee_ID) where username = '"+username+"'";

			// create the java statement

			PreparedStatement st = conn.prepareStatement(query);

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			int traineeID = 0;
			while (rs.next()) {
				LoginBean loginBean = new LoginBean();
				loginBean.setUsername(rs.getString("username"));
				loginBean.setPassword(rs.getString("password"));
				traineeID = rs.getInt("Trainee_ID");
				System.out.println(traineeID);
				String traineeTitle = rs.getString("title");
				String traineeName = rs.getString("name");
				String traineeEducation = rs.getString("education");
				
				trainee.setLogin(loginBean);
				trainee.setTitle(traineeTitle);
				trainee.setName(traineeName);
				trainee.setEducation(traineeEducation);
				System.out.println(traineeName);
			}
			st.close();

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return trainee;
	}
}
