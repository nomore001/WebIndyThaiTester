package fillRegisterProfile;


public class FillRegisterProfileManager {
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

	public int sumOfTrainee() {
		return 0;
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

	public boolean verifyLogin(String username, String password) {

		return false;

	}

	public String searchUserAccessStatus(String username) {

		return null;
	}
}
