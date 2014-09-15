//Source file: D:\\work\\downLoadDocument\\DownLoadDocumentManager.java

package com.itsci.downLoad_document;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.itsci.fill_register_profile.RegisterBean;
import com.itsci.utility.ExceptionUtil;
import com.itsci.utility.MySQLConnectionPool;

public class DownLoadDocumentManager {
	public CourseTrainingBean theCourseTrainingBean;
	Vector<CourseTrainingBean> courseTrainingVector;

	private static DownLoadDocumentManager instance = null;

	/**
	 * @roseuid 53C243CE029C
	 */
	public DownLoadDocumentManager() {

	}

	public static DownLoadDocumentManager getInstance() {
		if (instance == null) {
			return instance = new DownLoadDocumentManager();
		}
		return instance;
	}

	public void initDownloadManager(CourseTrainingBean courseTrainingBean) {
		this.theCourseTrainingBean = courseTrainingBean;
	}

	public synchronized boolean addCourseTraining(String courseName) {
		this.theCourseTrainingBean.setCourseTrainingName(courseName);

		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementCourseTraining = null;
		String sqlCourseTraining = "INSERT INTO coursetraining(courseName) VALUES (?)";

		try {
			conn.setAutoCommit(false);
			statementCourseTraining = conn.prepareStatement(sqlCourseTraining);
			statementCourseTraining.setString(1,
					this.theCourseTrainingBean.getCourseName());
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

	public synchronized boolean addRegister(String registerNo,
			String courseRegisterStartDate, int courseRegisterDuration,
			String paymentStartDate, int paymentDuration,
			String trainingStartDate, int courseDuration,
			int courseRegisterCosts, int courseID) {
		RegisterBean register = new RegisterBean(registerNo,
				courseRegisterStartDate, courseRegisterDuration,
				paymentStartDate, paymentDuration, trainingStartDate,
				courseDuration, courseRegisterCosts);
		this.theCourseTrainingBean.getRegister().add(register);
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementRegister = null;
		String sqlRegister = "INSERT INTO register(registerNo, courseRegisterStartDate, courseRegisterDuration, paymentStartDate, paymentDuration, trainingStartDate, courseDuration, courseRegisterCosts, CourseTraining_ID) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			conn.setAutoCommit(false);
			statementRegister = conn.prepareStatement(sqlRegister);
			statementRegister.setString(1, register.getRegisterNo());
			statementRegister.setString(2,
					register.getCourseRegisterStartDate());
			statementRegister.setInt(3, register.getCourseRegisterDuration());
			statementRegister.setString(4, register.getPaymentStartDate());
			statementRegister.setInt(5, register.getPaymentDuration());
			statementRegister.setString(6, register.getTrainingStartDate());
			statementRegister.setInt(7, register.getCourseDuration());
			statementRegister.setInt(8, register.getCourseRegisterCosts());
			statementRegister.setInt(9, courseID);
			statementRegister.executeUpdate();

			conn.commit();
			register = null;
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
	
	public synchronized void removeDocument(String docID, String path,
			String docName) {

		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementDeleteDocument = null;
		String sql = "DELETE FROM trainingdocument "
				+ " WHERE trainingdocument.TrainingDocument_ID = " + docID + "";

		try {
			conn.setAutoCommit(false);
			statementDeleteDocument = conn.prepareStatement(sql);
			int b = statementDeleteDocument.executeUpdate();
			System.out.println("Delete : " + sql);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			statementDeleteDocument.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filename = path + File.separator + docName;
		File deleteFile = new File(filename);
		deleteFile.delete();

	}
	
	public synchronized boolean isVerifyCourseTraining(String courseName) {
		String queryCourseName = null;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementVerify = null;
		String sqlVerify = "SELECT * FROM coursetraining;";
		try {
			statementVerify = conn.prepareStatement(sqlVerify);
			ResultSet rs = statementVerify.executeQuery();
			while (rs.next()) {
				queryCourseName = rs.getString("courseName");
				if (queryCourseName.equals(courseName)) {
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

	public synchronized int searchCourseId(String courseName) {
		int courseTrainingID = 0;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementSearchCourseId = null;
		String sqlVerify = "SELECT * FROM coursetraining WHERE courseName = '"
				+ courseName + "';";
		try {
			statementSearchCourseId = conn.prepareStatement(sqlVerify);
			ResultSet rs = statementSearchCourseId.executeQuery();
			while (rs.next()) {
				courseTrainingID = rs.getInt("CourseTraining_ID");
				this.theCourseTrainingBean.setCourseTrainingName(rs
						.getString("courseName"));

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
	
	public synchronized Vector<CourseTrainingBean> listCourseTraining() {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statement_listCputseTraining = null;
		String sql_queryCourse = "SELECT * FROM coursetraining;";

		Vector<CourseTrainingBean> courseTrainingVector = new Vector<CourseTrainingBean>();
		try {
			statement_listCputseTraining = conn
					.prepareStatement(sql_queryCourse);
			ResultSet rs = statement_listCputseTraining.executeQuery();
			while (rs.next()) {
				CourseTrainingBean courseTraining = new CourseTrainingBean();
				courseTraining
						.setCourseTrainingName(rs.getString("courseName"));
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

	public synchronized Vector<TrainingDocumentBean> listAllDocument(
			String courseID) {

		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statement_listCputseTraining = null;
		String sql_queryCourse = "SELECT * FROM trainingdocument where trainingdocument.CourseTraining_ID = "
				+ courseID + ";";
		// courseTrainingVector = new Vector<CourseTrainingBean>();
		Vector<TrainingDocumentBean> list = new Vector<TrainingDocumentBean>();
		courseTrainingVector = listCourseTraining();
		try {
			statement_listCputseTraining = conn
					.prepareStatement(sql_queryCourse);
			ResultSet rs = statement_listCputseTraining.executeQuery();
			for (int i = 0; i < courseTrainingVector.size(); i++) {
				while (rs.next()) {

					TrainingDocumentBean trainingDocumentBean = new TrainingDocumentBean();
					trainingDocumentBean.setDocumentName(rs
							.getString("documentName"));
					trainingDocumentBean.setDocumentPath(rs
							.getString("documentPath"));
					trainingDocumentBean.setDocumentId(rs
							.getInt("TrainingDocument_ID"));
					courseTrainingVector.elementAt(i)
							.getTrainingDocumentVector()
							.add(trainingDocumentBean);
					list.add(trainingDocumentBean);
				}
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
		return list;
	}

	public Vector<TrainingDocumentBean> downloadTrainingDocument(
			Vector<TrainingDocumentBean> trainingDoc) {

		Vector<TrainingDocumentBean> pathToLoadFile = new Vector<TrainingDocumentBean>();

		for (int i = 0; i < trainingDoc.size(); i++) {
			String docPath = trainingDoc.elementAt(i).getDocumentPath();
			// String text =
			// "D:\\\\work\\\\3.2556\\\\AutomateTest\\\\gitWorkspace\\\\WebIndyThaiTester\\\\WebContent\\\\";
			String text = "D:\\\\workSpace\\\\WebIndyThaiTester\\\\WebContent\\\\";

			String[] temp = docPath.split(text);

			String f = temp[1].replace("\\", "/");

			System.out.println(f + "/"
					+ trainingDoc.elementAt(i).getDocumentName());
			TrainingDocumentBean t = new TrainingDocumentBean();
			t.setDocumentId(trainingDoc.elementAt(i).getDocumentId());
			t.setDocumentName(trainingDoc.elementAt(i).getDocumentName());
			t.setDocumentPath(f + "/"
					+ trainingDoc.elementAt(i).getDocumentName());
			pathToLoadFile.add(t);

		}
		return pathToLoadFile;
	}

	public boolean uploadTrainingDocument(String documentName,
			String documentPath, int courseId) {
		TrainingDocumentBean document = new TrainingDocumentBean();
		document.setDocumentName(documentName);
		document.setDocumentPath(documentPath);

		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementUpDocument = null;
		String sqlUpLoadTrainingDocument = "INSERT INTO trainingdocument(documentName, documentPath,CourseTraining_ID) "
				+ "VALUES (?,?,?);";

		try {
			conn.setAutoCommit(false);
			statementUpDocument = conn
					.prepareStatement(sqlUpLoadTrainingDocument);
			statementUpDocument.setString(1, document.getDocumentName());
			statementUpDocument.setString(2, document.getDocumentPath());
			statementUpDocument.setInt(3, courseId);

			statementUpDocument.executeUpdate();
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
				statementUpDocument.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized int sumOfRegister(int courseTrainingID) {
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

	public synchronized String createRegisterNo(int registerAmount) {
		return this.theCourseTrainingBean.getCourseName()  + "0"
				+ (registerAmount + 1);
	}

}
