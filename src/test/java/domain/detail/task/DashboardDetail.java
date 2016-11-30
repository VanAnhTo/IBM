package domain.detail.task;

public class DashboardDetail {
	private String sprintDate;
	private String currentProject;
	private String team;
	
	public DashboardDetail(String sprintDate, String currentProject,String team) {
		this.sprintDate = sprintDate;
		this.currentProject = currentProject;
		this.team = team;
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
}
