package domain.detail.task;

public class Task {

	private String taskName;
	private String timeEstimate;
	private String timeTracking;
	private String workDay;
	private String dueDate;
	private String statusBefore;
	private String statusAfter;
	private String timeCode;
	private String taskGroup;
	private String sprintDate;
	private String currentProject;
	private String team;

	public Task(String taskName, String timeEstimate, String timeTracking, String dueDate, String status,
			String timeCode, String taskGroup, String sprintDate, String currentProject, String team, String statusAfter) {
		this.taskName = taskName;
		this.timeEstimate = timeEstimate;
		this.timeTracking = timeTracking;
		this.dueDate = dueDate;
		this.statusBefore = status;
		this.statusAfter = statusAfter;
		this.timeCode = timeCode;
		this.taskGroup = taskGroup;
		this.sprintDate = sprintDate;
		this.currentProject = currentProject;
		this.team = team;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public void setTimeEstimate(String timeEstimate) {
		this.timeEstimate = timeEstimate;
	}

	public void setTimeTracking(String timeTracking) {
		this.timeTracking = timeTracking;
	}

	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}


	public String getStatusBefore() {
		return statusBefore;
	}

	public void setStatusBefore(String statusBefore) {
		this.statusBefore = statusBefore;
	}

	public void setTimeCode(String timeCode) {
		this.timeCode = timeCode;
	}

	public void setTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
	}

	public void setSprintDate(String sprintDate) {
		this.sprintDate = sprintDate;
	}

	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	public void setStatusAfter(String statusAfter) {
		this.statusAfter = statusAfter;
	}
	

	public String getSprintDate() {
		return sprintDate;
	}

	public String getCurrentProject() {
		return currentProject;
	}

	public String getTeam() {
		return team;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getTaskName() {
		return taskName;
	}

	public String getTimeEstimate() {
		return timeEstimate;
	}

	public String getTimeTracking() {
		return timeTracking;
	}

	public String getWorkDay() {
		return workDay;
	}


	public String getTimeCode() {
		return timeCode;
	}

	public String getTaskGroup() {
		return taskGroup;
	}
	
	public String getStatusAfter() {
		return statusAfter;
	}

}
