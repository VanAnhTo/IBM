package domain.detail.task;

public class DashboardDetail {
	private String sprintDate;
	

	private String currentProject;
	private String team;

	public DashboardDetail(String sprintDate, String currentProject, String team) {
		this.sprintDate = sprintDate;
		this.currentProject = currentProject;
		this.team = team;
	}

	public DashboardDetail() {
	}

	public String getSprintDate() {
		return sprintDate;
	}
	
	public void setSprintDate(String sprintDate) {
		this.sprintDate = sprintDate;
	}


	public String getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}

	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}

}
