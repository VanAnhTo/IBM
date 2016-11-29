package domain.detail.task;

public class TaskDetail {
	private String taskName;
	private String timeEstimate;
	private String timeTracking;
	private String workDay;
	private String dueDate;
	private String status;
	private String timeCode;
	private String taskGroup;

	public TaskDetail(String taskName) {
		this.taskName = taskName;
	}

	public TaskDetail(String taskName, String timeEstimate, String timeTracking, String dueDate, String status, String timeCode, String taskGroup) {
		this.taskName = taskName;
		this.timeEstimate = timeEstimate;
		//this.workDay = dayOfWeek;
		this.timeTracking = timeTracking;
		this.dueDate =dueDate;
		this.status = status;
		this.timeCode = timeCode;
		this.taskGroup = taskGroup;
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
	public String getTimeCode() {
		return timeCode;
	}
	
	public String getTaskGroup() {
		return taskGroup;
	}
}
