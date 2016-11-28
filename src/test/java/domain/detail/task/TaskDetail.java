package domain.detail.task;

public class TaskDetail {
	private String taskName;
	private String timeEstimate;
	private String timeTracking;
	private String workDay;
	private String dueDate;
	private String status;

	public TaskDetail(String taskName) {
		this.taskName = taskName;
	}

	public TaskDetail(String taskName, String timeEstimate, String dayOfWeek, String timeTracking, String dueDate, String status) {
		this.taskName = taskName;
		this.timeEstimate = timeEstimate;
		this.workDay = dayOfWeek;
		this.timeTracking = timeTracking;
		this.dueDate =dueDate;
		this.status = status;
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
	
	public String getStatus() {
		return status;
	}
}
