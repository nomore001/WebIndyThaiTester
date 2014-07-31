
package evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fillRegisterProfile.FillRegisterProfileManager;
import fillRegisterProfile.RegisterBean;
import utility.ExceptionUtil;
import utility.MySQLConnectionPool;

public class EvaluationManager {
	public EvaluationBean theEvaluationBean;

	private static EvaluationManager instance = null;

	public static EvaluationManager getInstance() {
		if (instance == null) {
			return instance = new EvaluationManager();
		}
		return instance;
	}

	public synchronized boolean addEvaluation(EvaluationBean evaluation,
			int traineeID) {
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementEvaluation = null;

		String sqlEvaluation = "INSERT INTO evaluation(evaluationName, Trainee_ID) VALUES (?,?);";

		try {
			statementEvaluation = conn.prepareStatement(sqlEvaluation);
			statementEvaluation.setString(1, evaluation.getEvaluationName());
			statementEvaluation.setInt(2, traineeID);
			statementEvaluation.executeUpdate();

			int evaluationID = this.searchEvaluationID(traineeID);

			for (int i = 0; i < evaluation.getTopicVector().size(); i++) {
				boolean addTopic = this.addTopic(evaluation.getTopicVector().get(i), evaluationID);
				if(addTopic){
					int topicID = this.searchTopicID(evaluation.getTopicVector().get(i).getTopicName(), evaluationID);
					if(i == (evaluation.getTopicVector().size()-1)){
						this.addSuggestion(evaluation.getTopicVector().get(i).getSuggestion(), topicID);
					}else{
						for(int j=0 ; j<evaluation.getTopicVector().get(i).getChoiceVector().size() ; j++){
							this.addChoice(evaluation.getTopicVector().get(i).getChoiceVector().get(j), topicID);
						}
					}
				}
			}

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
				statementEvaluation.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized boolean addTopic(TopicBean topic, int evaluationID) {

		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementTopic = null;

		String sqlTopic = "INSERT INTO topic(topicName, Evaluation_ID) VALUES (?,?);";

		try {
			statementTopic = conn.prepareStatement(sqlTopic);
			statementTopic.setString(1, topic.getTopicName());
			statementTopic.setInt(2, evaluationID);
			statementTopic.executeUpdate();

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
				statementTopic.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized boolean addSuggestion(SuggestionBean suggestion,
			int topicID) {

		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementSuggestion = null;

		String sqlSuggestion = "INSERT INTO suggestion(answerSuggestion, Topic_ID) VALUES (?,?);";

		try {
			statementSuggestion = conn.prepareStatement(sqlSuggestion);
			statementSuggestion.setString(1, suggestion.getAnswerSuggestion());
			statementSuggestion.setInt(2, topicID);
			statementSuggestion.executeUpdate();

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
				statementSuggestion.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized boolean addChoice(ChoiceBean choice, int topicID) {

		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementChoice = null;

		String sqlChoice = "INSERT INTO choice(choiceQuestion, selectedValue, Topic_ID) VALUES (?,?,?);";

		try {
			statementChoice = conn.prepareStatement(sqlChoice);
			statementChoice.setString(1, choice.getChoiceQuestion());
			statementChoice.setInt(2, choice.getSelectedValue());
			statementChoice.setInt(3, topicID);
			statementChoice.executeUpdate();

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
				statementChoice.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return false;
	}

	public synchronized int searchEvaluationID(int traineeID) {
		int evaluationID = 0;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementSearchEvaluationID = null;
		String sqlSearchEvaluationID = "select * from evaluation where Trainee_ID = ?;";
		try {
			statementSearchEvaluationID = conn
					.prepareStatement(sqlSearchEvaluationID);
			statementSearchEvaluationID.setInt(1, traineeID);
			ResultSet rs = statementSearchEvaluationID.executeQuery();
			while (rs.next()) {
				evaluationID = rs.getInt("Evaluation_ID");

			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementSearchEvaluationID.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return evaluationID;
	}

	public synchronized int searchTopicID(String topicName, int evaluationID) {
		int topicID = 0;
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementSearchEvaluationID = null;
		String sqlSearchEvaluationID = "select * from topic where topicName = ? and Evaluation_ID = ?;";
		try {
			statementSearchEvaluationID = conn
					.prepareStatement(sqlSearchEvaluationID);
			statementSearchEvaluationID.setString(1, topicName);
			statementSearchEvaluationID.setInt(2, evaluationID);

			ResultSet rs = statementSearchEvaluationID.executeQuery();
			while (rs.next()) {
				topicID = rs.getInt("Topic_ID");

			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementSearchEvaluationID.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return topicID;
	}

	public synchronized double[] calculateTotalAllEvaluation(RegisterBean registerBean, int sumOfTrainee) {
		int sumOfTopic = 0;
		double[] totalAllEvaluation = null ;
		
		FillRegisterProfileManager fillRegisterMng = FillRegisterProfileManager
				.getInstance();
		
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementSumOfTopic = null;
		String sqlSumOfTopic = "select count(Topic_ID) as countTopic "
				+ "from topic t join evaluation e on(t.Evaluation_ID = e.Evaluation_ID) "
				+ "join trainee tn on (e.Trainee_ID = tn.Trainee_ID) "
				+ "join register r on (tn.Register_ID = r.Register_ID) "
				+ "where r.registerNo = '"+registerBean.getRegisterNo()+"';";
		try {
			statementSumOfTopic = conn
					.prepareStatement(sqlSumOfTopic);

			ResultSet rs = statementSumOfTopic.executeQuery();
			
			while (rs.next()) {
				sumOfTopic = rs.getInt("countTopic");
			}
			
			totalAllEvaluation = new double[sumOfTopic-1];
			
			for(int i=0 ; i<sumOfTrainee ; i++){
				int traineeID = fillRegisterMng.searchTraineeId(registerBean.getTraineeVector().get(i).getLogin().getUsername());
				int evaluationID = this.searchEvaluationID(traineeID);
				double[] topicChoice = this.calculateAllTopic(evaluationID);
				for(int j=0 ; j<topicChoice.length ; j++){
					totalAllEvaluation[j] += topicChoice[j];
				}
			}
			for(int k=0 ; k<totalAllEvaluation.length ; k++){
				totalAllEvaluation[k] = totalAllEvaluation[k]/sumOfTrainee;
			}
			
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementSumOfTopic.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		
		return totalAllEvaluation;
	}
	
	public synchronized double[] calculateAllTopic(int evaluationID){
		int sumOfTopic = this.sumOfTopic(evaluationID);
		double[] totalSelectedValue = new double[sumOfTopic-1];
				
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementTopic = null;
		String sqlTopic = "select * from topic where Evaluation_ID = "+evaluationID+";";
		try {
			statementTopic = conn
					.prepareStatement(sqlTopic);

			ResultSet rs = statementTopic.executeQuery();
			
			int i = 0;
			while (rs.next()) {
				if(i<(sumOfTopic-1)){
					int topicID = rs.getInt("Topic_ID");
					totalSelectedValue[i] = this.calculateValueSelected(topicID);
				}
				i++;
			}
			
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementTopic.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		
		return totalSelectedValue;
	}
	
	public synchronized double calculateValueSelected(int topicID){
		double sumSelectedValue = 0.0;
		
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementChoice = null;
		String sqlChoice = "select * from choice where Topic_ID = "+topicID+";";
		try {
			statementChoice = conn
					.prepareStatement(sqlChoice);

			ResultSet rs = statementChoice.executeQuery();
			int i = 0;
			while (rs.next()) {
				int selectedValue = rs.getInt("selectedValue");
				sumSelectedValue = sumSelectedValue + selectedValue;
				i++;
			}
			
			sumSelectedValue = sumSelectedValue/i;
			
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementChoice.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return sumSelectedValue;
	}
	
	public synchronized int sumOfTopic(int evaluationID) {
		int sumOfTopic = 0;
		
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementSumOfTopic = null;
		String sqlSumOfTopic = "select count(Topic_ID) as countTopic from topic where Evaluation_ID = "+evaluationID+";";
		try {
			statementSumOfTopic = conn
					.prepareStatement(sqlSumOfTopic);

			ResultSet rs = statementSumOfTopic.executeQuery();
			while (rs.next()) {
				sumOfTopic = rs.getInt("countTopic");

			}
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementSumOfTopic.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		return sumOfTopic;
	}

	public String totalSuggestion(RegisterBean registerBean, int sumOfTrainee) {
		int sumOfTopic = 0;
		String totalSuggestion = "";
		
		Connection conn = MySQLConnectionPool.getConnection();
		PreparedStatement statementSumOfTopic = null;
		String sqlSumOfTopic = "select count(Topic_ID) as countTopic "
				+ "from topic t join evaluation e on(t.Evaluation_ID = e.Evaluation_ID) "
				+ "join trainee tn on (e.Trainee_ID = tn.Trainee_ID) "
				+ "join register r on (tn.Register_ID = r.Register_ID) "
				+ "where r.registerNo = '"+registerBean.getRegisterNo()+"';";
		try {
			statementSumOfTopic = conn
					.prepareStatement(sqlSumOfTopic);

			ResultSet rs = statementSumOfTopic.executeQuery();
			
			while (rs.next()) {
				sumOfTopic = rs.getInt("countTopic");
			}
			
			int sizeTopic = sumOfTopic-1;
			for(int i=0 ; i<sumOfTrainee ; i++){
				totalSuggestion += registerBean.getTraineeVector().elementAt(i).getEvaluation().getTopicVector().elementAt(sizeTopic).getSuggestion().getAnswerSuggestion() + "\n";
			}
			
		} catch (SQLException ex) {
			ExceptionUtil.messageException(new Throwable(), ex);
		} finally {
			try {
				statementSumOfTopic.close();
				conn.close();
			} catch (SQLException ex) {
				ExceptionUtil.messageException(new Throwable(), ex);
			}
		}
		
		return totalSuggestion;
	}

}
