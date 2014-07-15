package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.MySQLConnectionPool;
import fillRegisterProfile.LoginBean;
import fillRegisterProfile.TraineeBean;

public class LoginManager {

	public boolean isVerifyLogin(LoginBean login) {
		boolean isLogin = false;
		String user = "admin";
		String pass = "admin";
		if (login.getUsername().equals(user)) {
			if (login.getPassword().equals(pass)) {
				isLogin = true;
			}
		}
		return isLogin;
	}

	public String searchUserAccessStatus(String username) {

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
				String cn = rs.getString("courseName");
				System.out.println(cn);
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
		return null;
	}

	public TraineeBean searchTraineeByUsername(String username) {
		TraineeBean tn = new TraineeBean();
		Connection conn = MySQLConnectionPool.getConnection();
		try {
			String query = "SELECT * FROM login where username = '" + username
					+ "'";

			// create the java statement

			PreparedStatement st = conn.prepareStatement(query);

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			int traineeID = 0;
			while (rs.next()) {
				traineeID = rs.getInt("Trainee_ID");
				System.out.println(traineeID);
			}
			// st.close();

			query = "SELECT * FROM trainee where Trainee_ID = " + traineeID
					+ "";
			ResultSet rs2 = st.executeQuery(query);

			while (rs2.next()) {
				String traineeTitle = rs2.getString("title");
				String traineeName = rs2.getString("name");
				String traineeEducation = rs2.getString("education");
				tn.setTitle(traineeTitle);
				tn.setName(traineeName);
				tn.setEducation(traineeEducation);
				System.out.println(traineeName);
			}
			st.close();

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ***************************
		// int i = 0;
		// while (i < traineeVector.size()) {
		// if (username.equals(traineeVector.elementAt(i).getLogin()
		// .getUsername())) {
		// return traineeVector.elementAt(i);
		// }
		// i++;
		// }
		// return null;
		return tn;
	}
}
