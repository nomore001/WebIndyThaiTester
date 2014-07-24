package fillRegisterProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.ExceptionUtil;
import utility.MySQLConnectionPool;

public class FillRegisterProfileManager {
	public RegisterBean theRegisterBean;

	private static FillRegisterProfileManager instance = null;

	public void editAddress(String workplace, String addressNo, String street,
			String subDistrict, String district, String province, String zipcode) {

	}

	public static FillRegisterProfileManager getInstance() {
		if (instance == null) {
			return instance = new FillRegisterProfileManager();
		}
		return instance;
	}

	public void initFillRegisterProfileManager(RegisterBean registerBean) {
		this.theRegisterBean = registerBean;
	}

	public void editOccupation(boolean selected) {

	}

	public void editOther(String other) {

	}

	/*
	 * public void addTrainee(Trainee trainee){
	 * 
	 * }
	 * 
	 * public Trainee searchTraineeByName(String name) {
	 * 
	 * return null; }
	 * 
	 * public Trainee searchTraineeByUsername(String username) {
	 * 
	 * return null; }
	 */

	public int sumOfTrainee(RegisterBean registerBean) {
		int sumOfTrainee = 0;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statement_sumOfRegister = null;
		String sql_sumOfRegister = "select COUNT(Trainee_ID) as SumOfTrainee from trainee t join register r on (t.Register_ID = r.Register_ID)  where registerNo = '"
				+ registerBean.getRegisterNo() + "';";
		try {
			statement_sumOfRegister = conn.prepareStatement(sql_sumOfRegister);
			ResultSet rs = statement_sumOfRegister.executeQuery();
			while (rs.next()) {
				sumOfTrainee = rs.getInt("SumOfTrainee");
			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statement_sumOfRegister.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return sumOfTrainee;
	}

	public String createFrangmentPayment(int sumOfTrainee) {
		String traineePayment = "";
		sumOfTrainee = sumOfTrainee + 1;

		return traineePayment;
	}

	public double[] calculateTotalAllEvaluation(int countTrainee) {

		return null;
	}

	public String totalSuggestion(int sumOfTrainee) {
		String totalSuggestion = "";

		return totalSuggestion;
	}

	public double[] calculateGraph(double[] totalTopic) {
		double[] totalGraph = new double[totalTopic.length];
		double sumTopic = 0.0;

		return totalGraph;
	}

	/*
	 * public Vector<Trainee> listTrainee() { return null; }
	 */
	public boolean removeInvalidTrainee(String name) {

		return false;
	}

	public synchronized boolean verifyLogin(LoginBean login) {

		String query = "SELECT * FROM login where username = '"
				+ login.getUsername() + "';";

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

	public String searchUserAccessStatus(String username) {

		return null;
	}

	public RegisterBean getRegisterNow() {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementGetRegisterNow = null;
		String sqlGetRegisterNow = "SELECT registerNo, DATE_FORMAT(courseRegisterStartDate, '%d/%m/%Y') AS courseRegisterStartDate,"+
		" courseRegisterDuration, DATE_FORMAT(paymentStartDate, '%d/%m/%Y') AS paymentStartDate, paymentDuration,"+
		" DATE_FORMAT(trainingStartDate, '%d/%m/%Y') AS trainingStartDate, courseRegisterCosts FROM register "+
		"WHERE CURDATE() BETWEEN courseRegisterStartDate AND DATE_FORMAT(courseRegisterStartDate+courseRegisterDuration, '%Y-%m-%d') ;";
		try {
			statementGetRegisterNow = conn.prepareStatement(sqlGetRegisterNow);
			ResultSet rs = statementGetRegisterNow.executeQuery();
			while (rs.next()) {
				this.theRegisterBean.setRegisterNo(rs.getString("registerNo"));
				this.theRegisterBean.setCourseRegisterStartDate(rs.getString("courseRegisterStartDate"));
				this.theRegisterBean.setCourseRegisterDuration(rs.getInt("courseRegisterDuration"));
				this.theRegisterBean.setPaymentStartDate(rs.getString("paymentStartDate"));
				this.theRegisterBean.setPaymentDuration(rs.getInt("paymentDuration"));
				this.theRegisterBean.setTrainingStartDate(rs.getString("trainingStartDate"));
				this.theRegisterBean.setCourseRegisterCosts(rs.getInt("courseRegisterCosts"));
			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementGetRegisterNow.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return this.theRegisterBean;
	}
}
