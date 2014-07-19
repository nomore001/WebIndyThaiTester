//Source file: D:\\work\\downLoadDocument\\DownLoadDocumentManager.java

package downLoadDocument;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import utility.ExceptionUtil;
import utility.MySQLConnectionPool;
import fillRegisterProfile.RegisterBean;

public class DownLoadDocumentManager {
	public CourseTrainingBean theCourseTrainingBean;
	Vector<CourseTrainingBean> courseTrainingVector;
	/**
	 * @roseuid 53C243CE029C
	 */
	public DownLoadDocumentManager() {
		
	}
	
	public DownLoadDocumentManager(CourseTrainingBean courseTrainingBean) {
		this.theCourseTrainingBean = courseTrainingBean;
	}

	public Vector<CourseTrainingBean> listCourseTraining() {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statement_listCputseTraining = null;
		String sql_queryCourse = "SELECT * FROM coursetraining;";
			
		Vector<CourseTrainingBean> courseTrainingVector = new Vector<CourseTrainingBean>();
		try {
			statement_listCputseTraining = conn.prepareStatement(sql_queryCourse);
			ResultSet rs  = statement_listCputseTraining.executeQuery();
			while (rs.next()) {
				CourseTrainingBean courseTraining = new CourseTrainingBean();
				courseTraining.setCourseTrainingName(rs.getString("courseName"));
				courseTraining.setCourseTrainingDuration(rs.getInt("courseDuration"));
				courseTrainingVector.add(courseTraining);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement_listCputseTraining.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return courseTrainingVector;
	}
	
	/**
	 * @return java.util.Vector
	 * @roseuid 53C244BB03CC
	 */
	public Vector listAllDocument() {
		return null;
	}

	/**
	 * @return java.lang.String
	 * @roseuid 53C244CC009B
	 */
	public String downloadTrainingDocument() {
		return null;
	}

	public int sumOfRegister(int courseTrainingID) {
		int sumOfRegister = 0;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statement_sumOfRegister = null;
		String sql_sumOfRegister = "select COUNT(Register_ID) as SumOfRegister from register where CourseTraining_ID = "
				+ courseTrainingID + ";";
		try {
			statement_sumOfRegister = conn.prepareStatement(sql_sumOfRegister);
			ResultSet rs = statement_sumOfRegister.executeQuery();
			while (rs.next()) {
				sumOfRegister = rs.getInt("SumOfRegister");
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
		return sumOfRegister;
	}

	public synchronized boolean addCourseTraining(String courseName, int courseDuration) {
		this.theCourseTrainingBean.setCourseTrainingName(courseName);
		this.theCourseTrainingBean.setCourseTrainingDuration(courseDuration);
		
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementCourseTraining = null;
		String sqlCourseTraining = "INSERT INTO coursetraining(courseName, courseDuration) "
				+ "VALUES (?,?)";

		try {
			conn.setAutoCommit(false); 
			statementCourseTraining = conn.prepareStatement(sqlCourseTraining); 
			statementCourseTraining.setString(1, this.theCourseTrainingBean.getCourseName()); 
			statementCourseTraining.setInt(2, this.theCourseTrainingBean.getCourseDuration()); 
			statementCourseTraining.executeUpdate();
			
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
				statementCourseTraining.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized boolean addRegister(String registerNo, String courseRegisterStartDate, 
			int courseRegisterDuration, String paymentStartDate, int paymentDuration, 
			String trainingStartDate, int courseRegisterCosts, int courseID) {
		RegisterBean register = new RegisterBean(registerNo, courseRegisterStartDate, 
				courseRegisterDuration, paymentStartDate, paymentDuration, trainingStartDate, 
				courseRegisterCosts);
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementRegister = null;
		String sqlRegister = "INSERT INTO register(registerNo, courseRegisterStartDate, courseRegisterDuration, paymentStartDate, paymentDuration, trainingStartDate, courseRegisterCosts, CourseTraining_ID) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		try {
			conn.setAutoCommit(false); 
			statementRegister = conn.prepareStatement(sqlRegister); 
			statementRegister.setString(1, register.getRegisterNo()); 
			statementRegister.setString(2, register.getCourseRegisterStartDate()); 
			statementRegister.setInt(3, register.getCourseRegisterDuration()); 
			statementRegister.setString(4, register.getPaymentStartDate()); 
			statementRegister.setInt(5, register.getPaymentDuration()); 
			statementRegister.setString(6, register.getTrainingStartDate()); 
			statementRegister.setInt(7, register.getCourseRegisterCosts()); 
			statementRegister.setInt(8, courseID); 
			statementRegister.executeUpdate(); 
			
			conn.commit();
			register = null; 
			this.theCourseTrainingBean = null; 
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
				statementRegister.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public boolean isVerifyCourseTraining(String courseName, int courseDuration) {
		String queryCourseName = null;
		int queryCourseDuratin = 0;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementVerify = null;
		String sqlVerify = "SELECT * FROM coursetraining;";
		try {
			statementVerify = conn.prepareStatement(sqlVerify);
			ResultSet rs = statementVerify.executeQuery();
			while (rs.next()) {
				queryCourseName = rs.getString("courseName");
				queryCourseDuratin = rs.getInt("courseDuration");
				if (queryCourseName.equals(courseName)
						&& queryCourseDuratin == courseDuration) {
					return true;
				}
			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementVerify.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public int searchCourseId(String courseName, int courseDuration) {
		int courseTrainingID = 0;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementSearchCourseId = null;
		String sqlVerify = "SELECT * FROM coursetraining WHERE courseName = '"
				+ courseName + "' and courseDuration = " + courseDuration + ";";
		try {
			statementSearchCourseId = conn.prepareStatement(sqlVerify);
			ResultSet rs = statementSearchCourseId.executeQuery();
			while (rs.next()) {
				courseTrainingID = rs.getInt("CourseTraining_ID");
				this.theCourseTrainingBean.setCourseTrainingName(rs.getString("courseName"));
				this.theCourseTrainingBean.setCourseTrainingDuration(rs.getInt("courseDuration"));
			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementSearchCourseId.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return courseTrainingID;
	}

	public String createRegisterNo(int registerAmount) {
		return this.theCourseTrainingBean.getCourseName()
				+ (registerAmount + 1);
	}
}
