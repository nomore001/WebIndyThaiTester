//Source file: D:\\work\\downLoadDocument\\CourseTrainingBean.java

package downLoadDocument;

import java.util.Vector;

import fillRegisterProfile.RegisterBean;

public class CourseTrainingBean {
	private String courseName;
	
	private Vector<TrainingDocumentBean> trainingDocumentVector;
	public Vector<RegisterBean> register = new Vector<RegisterBean>();

	/**
	 * @roseuid 53C243810087
	 */
	public CourseTrainingBean() {

	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseTrainingName(String courseTrainingName) {
		this.courseName = courseTrainingName;
	}

	public Vector<RegisterBean> getRegister() {
		return register;
	}

	public void setRegister(Vector<RegisterBean> register) {
		this.register = register;
	}

	public Vector<TrainingDocumentBean> getTrainingDocumentVector() {
		return trainingDocumentVector;
	}

	public void setTrainingDocumentVector(Vector<TrainingDocumentBean> trainingDocumentVector) {
		this.trainingDocumentVector = trainingDocumentVector;
	}

}
