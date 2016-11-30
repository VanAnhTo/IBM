package domain.builder.task;

import domain.detail.task.DashboardDetail;

public class DashBoardBuilder {
	private String sprintDate;
	private String currentProject;
	private String team;
	
	public DashBoardBuilder withSprintDate(String sprintDate) {
		this.sprintDate = sprintDate;
		return this;
	}
	
	public DashBoardBuilder withCurrentProject(String currentProject) {
		this.currentProject = currentProject;
		return this;
	}

	public DashBoardBuilder withTeam(String team) {
		this.team = team;
		return this;
	}
	
	public DashboardDetail build() {
		return new DashboardDetail(sprintDate, currentProject, team);
	}
}
