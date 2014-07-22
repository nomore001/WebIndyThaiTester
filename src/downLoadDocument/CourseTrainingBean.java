//Source file: D:\\work\\downLoadDocument\\CourseTrainingBean.java

package downLoadDocument;

import java.util.Vector;

import fillRegisterProfile.RegisterBean;

public class CourseTrainingBean {
	private String courseName;
	private int courseDuration;
	public TrainingDocumentBean theTrainingDocumentBean;
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

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseTrainingDuration(int courseTrainingDuration) {
		this.courseDuration = courseTrainingDuration;
	}

	public TrainingDocumentBean getTheTrainingDocumentBean() {
		return theTrainingDocumentBean;
	}

	public void setTheTrainingDocumentBean(
			TrainingDocumentBean theTrainingDocumentBean) {
		this.theTrainingDocumentBean = theTrainingDocumentBean;
	}

	public Vector<RegisterBean> getRegister() {
		return register;
	}

	public void setRegister(Vector<RegisterBean> register) {
		this.register = register;
	}

}
