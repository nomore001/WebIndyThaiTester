//Source file: D:\\work\\downLoadDocument\\CourseTrainingBean.java

package downLoadDocument;

import java.util.Vector;

import fillRegisterProfile.RegisterBean;

public class CourseTrainingBean {
	private String courseTrainingName;
	private int courseTrainingDuration;
	public TrainingDocumentBean theTrainingDocumentBean;
	public Vector<RegisterBean> register = new Vector<RegisterBean>();

	/**
	 * @roseuid 53C243810087
	 */
	public CourseTrainingBean() {

	}

	public String getCourseTrainingName() {
		return courseTrainingName;
	}

	public void setCourseTrainingName(String courseTrainingName) {
		this.courseTrainingName = courseTrainingName;
	}

	public int getCourseTrainingDuration() {
		return courseTrainingDuration;
	}

	public void setCourseTrainingDuration(int courseTrainingDuration) {
		this.courseTrainingDuration = courseTrainingDuration;
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
