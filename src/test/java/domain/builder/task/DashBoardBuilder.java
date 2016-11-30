package domain.builder.task;

import domain.detail.task.DashboardDetail;

public class DashBoardBuilder {
	private String sprintDate;
	
	public DashBoardBuilder withSprintDate(String sprintDate) {
		this.sprintDate = sprintDate;
		return this;
	}

	public DashboardDetail build() {
		return new DashboardDetail(sprintDate);
	}
}
