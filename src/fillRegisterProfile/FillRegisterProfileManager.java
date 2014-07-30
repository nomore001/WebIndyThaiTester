package fillRegisterProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import utility.ExceptionUtil;
import utility.MySQLConnectionPool;

public class FillRegisterProfileManager {
	public RegisterBean theRegisterBean;

	private static FillRegisterProfileManager instance = null;

	public static FillRegisterProfileManager getInstance() {
		if (instance == null) {
			return instance = new FillRegisterProfileManager();
		}
		return instance;
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

		return userStatus;
	}

	public synchronized TraineeBean searchTraineeByUsername(String username) {
		TraineeBean trainee = new TraineeBean();
		Connection conn = MySQLConnectionPool.getConnection();
		try {
			String query = "SELECT * FROM login l join trainee t on (l.Trainee_ID=t.Trainee_ID) "
					+ "join address a on (t.Trainee_ID = a.Trainee_ID) "
					+ "join traineeoccupation tocc on (t.Trainee_ID = tocc.Trainee_ID) "
					+ "join occupation o on (tocc.Occupation_ID = o.Occupation_ID) "
					+ "where username = '" + username + "'";

			// create the java statement
			PreparedStatement st = conn.prepareStatement(query);

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			int traineeID = 0;

			Vector<OccupationBean> occupationVector = new Vector<OccupationBean>();
			OccupationBean occ1 = new OccupationBean(false, "Tester");
			OccupationBean occ2 = new OccupationBean(false, "Administrator");
			OccupationBean occ3 = new OccupationBean(false, "Programmer");
			OccupationBean occ4 = new OccupationBean(false, "System analyst");
			OccupationBean occ5 = new OccupationBean(false, "Other");
			occupationVector.add(occ1);
			occupationVector.add(occ2);
			occupationVector.add(occ3);
			occupationVector.add(occ4);
			occupationVector.add(occ5);

			while (rs.next()) {
				LoginBean loginBean = new LoginBean();
				loginBean.setUsername(rs.getString("username"));
				loginBean.setPassword(rs.getString("password"));

				AddressBean addressBean = new AddressBean();
				addressBean.setWorkplace(rs.getString("workplace"));
				addressBean.setAddressNo(rs.getString("addressNo"));
				addressBean.setStreet(rs.getString("street"));
				addressBean.setSubDistrict(rs.getString("subDistrict"));
				addressBean.setDistrict(rs.getString("district"));
				addressBean.setProvince(rs.getString("province"));
				addressBean.setZipcode(rs.getString("zipcode"));

				traineeID = rs.getInt("Trainee_ID");
				System.out.println("Trinee_ID : " + traineeID);

				int occID = rs.getInt("Occupation_ID");
				String occName = rs.getString("occName");

				if (occID <= 4) {
					for (int j = 1; j <= 4; j++) {
						if (occID == j) {
							occupationVector.get(j - 1).setSelected(true);
							break;
						}
					}
				} else {
					occupationVector.get(4).setSelected(true);
					trainee.setOther(occName);
				}

				trainee.setOccVector(occupationVector);

				trainee.setTitle(rs.getString("title"));
				trainee.setName(rs.getString("name"));
				trainee.setEducation(rs.getString("education"));
				trainee.setTelNo(rs.getString("telNo"));
				trainee.setEmail(rs.getString("email"));
				trainee.setTraineeStatus(rs.getString("traineeStatus"));
				trainee.setRegisterDate(rs.getString("registerDate"));
				trainee.setTraineePayment(rs.getString("traineePayment"));

				trainee.setLogin(loginBean);
				trainee.setAddress(addressBean);
			}
			st.close();

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trainee;
	}

	public void initFillRegisterProfileManager(RegisterBean registerBean) {
		this.theRegisterBean = registerBean;
	}

	public synchronized int sumOfTrainee(RegisterBean registerBean) {
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

	public synchronized String createFrangmentPayment(RegisterBean registerBean) {
		int sumOfTrainee = this.sumOfTrainee(registerBean);
		registerBean.getCourseRegisterCosts();
		String traineePayment = registerBean.getCourseRegisterCosts() + "."
				+ (sumOfTrainee + 1);

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
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementDeleteRow = null;
		String del_sql = "DELETE FROM trainee WHERE trainee.name ='" + name
				+ "';";
		try {
			statementDeleteRow = conn.prepareStatement(del_sql);
			statementDeleteRow.execute();

		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementDeleteRow.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}

		return false;
	}

	public synchronized RegisterBean getRegisterNow() {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementGetRegisterNow = null;
		String sqlGetRegisterNow = "SELECT registerNo, DATE_FORMAT(courseRegisterStartDate, '%d/%m/%Y') AS courseRegisterStartDate, "
				+ "courseRegisterDuration, DATE_FORMAT(paymentStartDate, '%d/%m/%Y') AS paymentStartDate, "
				+ "paymentDuration, DATE_FORMAT(trainingStartDate, '%d/%m/%Y') AS trainingStartDate, "
				+ "courseRegisterCosts FROM register WHERE CURDATE() BETWEEN courseRegisterStartDate AND DATE_FORMAT(DATE_ADD(courseRegisterStartDate,INTERVAL courseRegisterDuration DAY), '%Y-%m-%d');";
		try {
			statementGetRegisterNow = conn.prepareStatement(sqlGetRegisterNow);
			ResultSet rs = statementGetRegisterNow.executeQuery();
			while (rs.next()) {
				this.theRegisterBean.setRegisterNo(rs.getString("registerNo"));
				this.theRegisterBean.setCourseRegisterStartDate(rs
						.getString("courseRegisterStartDate"));
				this.theRegisterBean.setCourseRegisterDuration(rs
						.getInt("courseRegisterDuration"));
				this.theRegisterBean.setPaymentStartDate(rs
						.getString("paymentStartDate"));
				this.theRegisterBean.setPaymentDuration(rs
						.getInt("paymentDuration"));
				this.theRegisterBean.setTrainingStartDate(rs
						.getString("trainingStartDate"));
				this.theRegisterBean.setCourseRegisterCosts(rs
						.getInt("courseRegisterCosts"));
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

	public synchronized boolean addTrainee(TraineeBean traineeBean) {
		int registerID = this.searchRegisterId(theRegisterBean.getRegisterNo());
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementTrainee = null;
		PreparedStatement statementOccupation = null;

		String sqlTrainee = "INSERT INTO trainee(title, name, education, telNo, email, traineeStatus, registerDate, traineePayment, Register_ID) VALUES (?,?,?,?,?,?,?,?,?);";
		String sqlOccupation = "";

		try {
			conn.setAutoCommit(false);
			statementTrainee = conn.prepareStatement(sqlTrainee);
			statementTrainee.setString(1, traineeBean.getTitle());
			statementTrainee.setString(2, traineeBean.getName());
			statementTrainee.setString(3, traineeBean.getEducation());
			statementTrainee.setString(4, traineeBean.getTelNo());
			statementTrainee.setString(5, traineeBean.getEmail());
			statementTrainee.setString(6, traineeBean.getTraineeStatus());
			statementTrainee.setString(7, traineeBean.getRegisterDate());
			statementTrainee.setString(8, traineeBean.getTraineePayment());
			statementTrainee.setInt(9, registerID);
			statementTrainee.executeUpdate();

			conn.commit();
			return true;
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				statementTrainee.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized boolean addAddress(TraineeBean traineeBean) {
		int traineeID = this.searchMaxTraineeId();

		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementAddress = null;
		String sqlAddress = "INSERT INTO address(workplace, addressNo, street, subDistrict, district, province, zipcode, Trainee_ID) VALUES (?,?,?,?,?,?,?,?);";

		try {
			conn.setAutoCommit(false);
			statementAddress = conn.prepareStatement(sqlAddress);
			statementAddress.setString(1, traineeBean.getAddress()
					.getWorkplace());
			statementAddress.setString(2, traineeBean.getAddress()
					.getAddressNo());
			statementAddress.setString(3, traineeBean.getAddress().getStreet());
			statementAddress.setString(4, traineeBean.getAddress()
					.getSubDistrict());
			statementAddress.setString(5, traineeBean.getAddress()
					.getDistrict());
			statementAddress.setString(6, traineeBean.getAddress()
					.getProvince());
			statementAddress
					.setString(7, traineeBean.getAddress().getZipcode());
			statementAddress.setInt(8, traineeID);
			statementAddress.executeUpdate();

			conn.commit();
			return true;
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				statementAddress.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized boolean addLogin(TraineeBean traineeBean) {
		int traineeID = this.searchMaxTraineeId();

		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementLogin = null;
		String sqlLogin = "INSERT INTO login(username, password, status, Trainee_ID) VALUES (?,?,?,?);";

		try {
			conn.setAutoCommit(false);
			statementLogin = conn.prepareStatement(sqlLogin);
			statementLogin.setString(1, traineeBean.getLogin().getUsername());
			statementLogin.setString(2, traineeBean.getLogin().getPassword());
			statementLogin.setString(3, traineeBean.getLogin().getStatus());
			statementLogin.setInt(4, traineeID);
			statementLogin.executeUpdate();

			conn.commit();
			return true;
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				statementLogin.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized int searchMaxTraineeId() {
		int traineeId = 0;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementSearchTraineeID = null;
		String sqlSearchTraineeID = "select max(Trainee_ID) as Trainee_ID from trainee;";
		try {
			statementSearchTraineeID = conn
					.prepareStatement(sqlSearchTraineeID);
			ResultSet rs = statementSearchTraineeID.executeQuery();
			while (rs.next()) {
				traineeId = rs.getInt("Trainee_ID");

			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementSearchTraineeID.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return traineeId;
	}

	public synchronized int searchTraineeId(String username) {
		int traineeId = 0;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementSearchTraineeID = null;
		String sqlSearchTraineeID = "select * from login l join trainee t on (l.Trainee_ID=t.Trainee_ID) where username = '"
				+ username + "';";
		try {
			statementSearchTraineeID = conn
					.prepareStatement(sqlSearchTraineeID);
			ResultSet rs = statementSearchTraineeID.executeQuery();
			while (rs.next()) {
				traineeId = rs.getInt("Trainee_ID");

			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementSearchTraineeID.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return traineeId;
	}

	public synchronized int searchRegisterId(String registerNo) {
		int registerId = 0;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementSearchRegisterID = null;
		String sqlSearchRegisterID = "select * from register where registerNo = '"
				+ registerNo + "';";
		try {
			statementSearchRegisterID = conn
					.prepareStatement(sqlSearchRegisterID);
			ResultSet rs = statementSearchRegisterID.executeQuery();
			while (rs.next()) {
				registerId = rs.getInt("Register_ID");

			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementSearchRegisterID.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return registerId;
	}

	public synchronized boolean isOccExist(String job) {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementIsOccExist = null;
		String sqlIsOccExist = "SELECT * FROM occupation WHERE occName = '"
				+ job + "';";
		try {
			statementIsOccExist = conn.prepareStatement(sqlIsOccExist);
			ResultSet rs = statementIsOccExist.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementIsOccExist.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized boolean addOccupation(TraineeBean traineeBean) {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementOccupation = null;
		String sqlOccupation = "INSERT INTO occupation(occName) VALUES (?);";

		try {
			conn.setAutoCommit(false);
			statementOccupation = conn.prepareStatement(sqlOccupation);
			statementOccupation.setString(1, traineeBean.getOther());
			statementOccupation.executeUpdate();

			conn.commit();
			return true;
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				statementOccupation.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized boolean addTraineeOccupation(TraineeBean traineeBean) {
		int occupationID = 0;
		int traineeID = this.searchTraineeId(traineeBean.getLogin()
				.getUsername());

		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementTraineeOccupation = null;
		String sqlTraineeOccupation = "INSERT INTO traineeoccupation(Trainee_ID, Occupation_ID) VALUES (?,?);";

		try {
			conn.setAutoCommit(false);
			for (int i = 0; i < traineeBean.getOccVector().size(); i++) {
				if (traineeBean.getOccVector().get(i).getSelected()) {
					if (i == 4) {
						occupationID = this.searchOccupationId(traineeBean
								.getOther());
					} else {
						occupationID = this.searchOccupationId(traineeBean
								.getOccVector().get(i).getOccName());
					}
					statementTraineeOccupation = conn
							.prepareStatement(sqlTraineeOccupation);
					statementTraineeOccupation.setInt(1, traineeID);
					statementTraineeOccupation.setInt(2, occupationID);
					statementTraineeOccupation.executeUpdate();
				}
			}
			conn.commit();
			return true;
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				statementTraineeOccupation.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized int searchOccupationId(String occName) {
		int occupationId = 0;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementSearchOccupationId = null;
		String sqlSearchOccupationId = "SELECT * FROM occupation WHERE occName = '"
				+ occName + "';";
		try {
			statementSearchOccupationId = conn
					.prepareStatement(sqlSearchOccupationId);
			ResultSet rs = statementSearchOccupationId.executeQuery();
			while (rs.next()) {
				occupationId = rs.getInt("Occupation_ID");
			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementSearchOccupationId.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return occupationId;
	}

	public synchronized int searchCourseTrainingIdByUsername(String username) {
		int courseTrainingId = 0;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementSearchCourseTrainingId = null;
		String sqlSearchCourseTrainingId = "select c.CourseTraining_ID from trainee t join login l on (t.Trainee_ID = l.Trainee_ID) "
				+ "join register r on (t.Register_ID = r.Register_ID) "
				+ "join coursetraining c on (r.CourseTraining_ID = c.CourseTraining_ID) "
				+ "where username = '" + username + "';";
		try {
			statementSearchCourseTrainingId = conn
					.prepareStatement(sqlSearchCourseTrainingId);
			ResultSet rs = statementSearchCourseTrainingId.executeQuery();
			while (rs.next()) {
				courseTrainingId = rs.getInt("CourseTraining_ID");
			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementSearchCourseTrainingId.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return courseTrainingId;
	}

	public synchronized Vector<TraineeBean> listTraineeByRegisterId(
			int registerID) {

		Vector<TraineeBean> trainee = new Vector<TraineeBean>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementListTrainee = null;
		String sql_selectTrainee = "SELECT title,name,education,telNO,email,traineeStatus,DATE_FORMAT(registerDate, '%d/%m/%Y')as registerDate,traineePayment  FROM trainee WHERE Register_ID="
				+ registerID + ";";

		try {
			statementListTrainee = conn.prepareStatement(sql_selectTrainee);
			ResultSet rs = statementListTrainee.executeQuery();

			while (rs.next()) {
				TraineeBean traineeBean = new TraineeBean();
				traineeBean.setTitle(rs.getString("title"));
				traineeBean.setName(rs.getString("name"));
				traineeBean.setEducation(rs.getString("education"));
				traineeBean.setTelNo(rs.getString("telNo"));
				traineeBean.setEmail(rs.getString("email"));
				traineeBean.setTraineeStatus(rs.getString("traineeStatus"));
				traineeBean.setRegisterDate(rs.getString("registerDate"));
				traineeBean.setTraineePayment(rs.getString("traineePayment"));

				trainee.add(traineeBean);
			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementListTrainee.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return trainee;

	}

	public synchronized Vector<RegisterBean> listAllRegister(int courseID) {
		Vector<RegisterBean> registervector = new Vector<RegisterBean>();
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementListRegister = null;
		String sql_selectRegister = "SELECT registerNo, DATE_FORMAT(courseRegisterStartDate, '%d/%m/%Y') AS courseRegisterStartDate, "
				+ "courseRegisterDuration, DATE_FORMAT(paymentStartDate, '%d/%m/%Y') AS paymentStartDate, "
				+ "paymentDuration, DATE_FORMAT(trainingStartDate, '%d/%m/%Y') AS trainingStartDate,courseDuration,"
				+ "courseRegisterCosts FROM register WHERE CourseTraining_ID="
				+ courseID + ";";
		try {
			statementListRegister = conn.prepareStatement(sql_selectRegister);
			ResultSet rs = statementListRegister.executeQuery();
			while (rs.next()) {
				this.theRegisterBean = new RegisterBean();
				this.theRegisterBean.setRegisterNo(rs.getString("registerNo"));
				this.theRegisterBean.setCourseRegisterStartDate(rs
						.getString("courseRegisterStartDate"));
				this.theRegisterBean.setCourseRegisterDuration(rs
						.getInt("courseRegisterDuration"));
				this.theRegisterBean.setPaymentStartDate(rs
						.getString("paymentStartDate"));
				this.theRegisterBean.setPaymentDuration(rs
						.getInt("paymentDuration"));
				this.theRegisterBean.setTrainingStartDate(rs
						.getString("trainingStartDate"));
				this.theRegisterBean.setCourseDuration(rs
						.getInt("courseDuration"));
				this.theRegisterBean.setCourseRegisterCosts(rs
						.getInt("courseRegisterCosts"));

				registervector.add(theRegisterBean);
			}

		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementListRegister.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}

		return registervector;

	}

	public synchronized boolean editTrainee(TraineeBean traineeBean) {
		int traineeID = this.searchTraineeId(traineeBean.getLogin()
				.getUsername());

		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementEditTrainee = null;
		String sqlEditTrainee = "UPDATE trainee SET title = ?, name = ?, education = ?, telNo = ?, email = ? WHERE Trainee_ID = ?;";

		try {
			this.editAddress(traineeBean.getAddress(), traineeID);
			this.editOccupation(traineeBean, traineeID);
			conn.setAutoCommit(false);
			statementEditTrainee = conn.prepareStatement(sqlEditTrainee);
			statementEditTrainee.setString(1, traineeBean.getTitle());
			statementEditTrainee.setString(2, traineeBean.getName());
			statementEditTrainee.setString(3, traineeBean.getEducation());
			statementEditTrainee.setString(4, traineeBean.getTelNo());
			statementEditTrainee.setString(5, traineeBean.getEmail());
			statementEditTrainee.setInt(6, traineeID);
			statementEditTrainee.executeUpdate();
			conn.commit();
			return true;
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				statementEditTrainee.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized boolean editAddress(AddressBean address, int traineeID) {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementEditAddress = null;
		String sqlEditAddress = "UPDATE address SET workplace = ?, addressNo = ?, street = ?, subDistrict = ?, district = ?, province = ?, zipcode = ? WHERE Trainee_ID = ?;";

		try {
			conn.setAutoCommit(false);

			statementEditAddress = conn.prepareStatement(sqlEditAddress);
			statementEditAddress.setString(1, address.getWorkplace());
			statementEditAddress.setString(2, address.getAddressNo());
			statementEditAddress.setString(3, address.getStreet());
			statementEditAddress.setString(4, address.getSubDistrict());
			statementEditAddress.setString(5, address.getDistrict());
			statementEditAddress.setString(6, address.getProvince());
			statementEditAddress.setString(7, address.getZipcode());
			statementEditAddress.setInt(8, traineeID);
			statementEditAddress.executeUpdate();

			conn.commit();
			return true;
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				statementEditAddress.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized boolean editOccupation(TraineeBean trainee,
			int traineeID) {
		try {
			this.removeOccupation(traineeID);
			if (trainee.getOther() != "") {
				boolean isOccExist = this.isOccExist(trainee.getOther());
				if (!isOccExist) {
					this.addOccupation(trainee);
				}
			}
			this.addTraineeOccupation(trainee);
			return true;
		} catch (Exception ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		}
		return false;
	}

	public synchronized boolean removeOccupation(int traineeID) {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementRemoveOccupation = null;
		String sqlRemoveOccupation = "DELETE FROM traineeoccupation WHERE Trainee_ID = ?;";

		try {
			conn.setAutoCommit(false);

			statementRemoveOccupation = conn
					.prepareStatement(sqlRemoveOccupation);
			statementRemoveOccupation.setInt(1, traineeID);
			statementRemoveOccupation.executeUpdate();

			conn.commit();
			return true;
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				statementRemoveOccupation.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public void editTraineeStatus(String traineeName, String traineeStatus) {

		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementEditStatus = null;
		String sqlEditStatus = "UPDATE trainee SET traineeStatus='"
				+ traineeStatus + "' WHERE name='" + traineeName + "';";
		
		try {
			conn.setAutoCommit(false);
			statementEditStatus = conn.prepareStatement(sqlEditStatus);
			statementEditStatus.executeUpdate();
			conn.commit();
			
			
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
			try {
				conn.rollback();
			} catch (SQLException e) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		} finally {
			try {
				statementEditStatus.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		
		
	}

}
