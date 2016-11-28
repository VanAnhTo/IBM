package domain.builder.task;

import domain.detail.task.TaskDetail;

public class TaskDetailBuilder {
	private String taskName;
	private String timeEstimate;
	private String timeTracking;
	private String workDay;
	private String dueDate;
	private String status;
	
	public TaskDetailBuilder withTaskName(String taskName) {
		this.taskName = taskName;
		return this;
	}

	public TaskDetailBuilder withTimeEstimate(String timeEstimate) {
		this.timeEstimate = timeEstimate;
		return this;
	}

	public TaskDetailBuilder withTimeTracking(String timeTracking, String dayOfWeek) {
		this.timeTracking = timeTracking;
		this.workDay = dayOfWeek;
		return this;
	}
	
	public TaskDetailBuilder withDueDate(String dueDate) {
		this.dueDate = dueDate;
		return this;
	}
	
	public TaskDetailBuilder withStatus(String status) {
		this.status = status;
		return this;
	}

	public TaskDetail build() {
		return new TaskDetail(taskName, timeEstimate, timeTracking, workDay, dueDate, status);
	}

}
