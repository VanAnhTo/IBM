package domain.detail.task;

public class DashboardDetail {
	private String sprintDate;
	private String currentProject;
	private String team;
	private String sprintId;

	public DashboardDetail(String sprintDate, String currentProject, String team) {
		this.sprintDate = sprintDate;
		this.currentProject = currentProject;
		this.team = team;
	}

	public DashboardDetail() {

	}
	
	public String getSprintId() {
		return sprintId;
	}

	public void setSprintId(String sprintId) {
		this.sprintId = sprintId;
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

	public void setSprintDate(String sprintDate) {
		this.sprintDate = sprintDate;
	}

	public void setTeam(String team) {
		this.team = team;
	}
}
