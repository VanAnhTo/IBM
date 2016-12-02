package domain.builder.task;

import domain.detail.task.TaskDetail;

public class TaskDetailBuilder {
	private String taskName;
	private String timeEstimate;
	private String timeTracking;
	private String dueDate;
	private String statusBefore;
	private String timeCode;
	private String taskGroup;
	private String status;
	
	private String statusAfter;
	
	public TaskDetailBuilder withTaskName(String taskName) {
		this.taskName = taskName;
		return this;
	}

	public TaskDetailBuilder withTimeEstimate(String timeEstimate) {
		this.timeEstimate = timeEstimate;
		return this;
	}
	/*public TaskDetailBuilder withTimeTracking(String timeTracking, String dayOfWeek) {
		this.timeTracking = timeTracking;
		this.workDay = dayOfWeek;
		return this;
	}*/
	public TaskDetailBuilder withTimeTracking(String timeTracking) {
		this.timeTracking = timeTracking;
		return this;
	}
	
	public TaskDetailBuilder withDueDate(String dueDate) {
		this.dueDate = dueDate;
		return this;
	}
	
	public TaskDetailBuilder withStatusBefore(String statusBefore) {
		this.statusBefore = statusBefore;
		return this;
	}
	
	public TaskDetailBuilder withStatusAfter(String statusAfter) {
		this.statusAfter = statusAfter;
		return this;
	}
	
	public TaskDetailBuilder withTimeCode(String timeCode) {
		this.timeCode = timeCode;
		return this;
	}
	
	public TaskDetailBuilder withTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
		return this;
	}
	
	public TaskDetailBuilder withStatus(String status) {
		this.status = status;
		return this;
	}

	public TaskDetail build() {
		return new TaskDetail(taskName, timeEstimate, timeTracking, dueDate, statusBefore, timeCode, taskGroup, statusAfter, status);
	}

}
