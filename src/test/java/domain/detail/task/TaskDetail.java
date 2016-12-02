package domain.detail.task;

public class TaskDetail {
	private String taskName;
	private String timeEstimate;
	private String timeTracking;
	private String workDay;
	private  String dueDate;
	private String statusBefore;
	private String timeCode;
	private String taskGroup;
	private String statusAfter;
	
	private String status;

	public String getStatus() {
		return status;
	}

	public TaskDetail(String taskName) {
		this.taskName = taskName;
	}

	public TaskDetail(String taskName, String timeEstimate, String timeTracking, String dueDate, String statusBefore,
			String timeCode, String taskGroup, String statusAfter, String status) {
		this.taskName = taskName;
		this.timeEstimate = timeEstimate;
		this.timeTracking = timeTracking;
		this.dueDate = dueDate;
		this.statusBefore = statusBefore;
		this.timeCode = timeCode;
		this.taskGroup = taskGroup;
		this.statusAfter = statusAfter;
		this.status = status;
	}

	public String getStatusAfter() {
		return statusAfter;
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

	public String getStatusBefore() {
		return statusBefore;
	}

	public String getTimeCode() {
		return timeCode;
	}

	public String getTaskGroup() {
		return taskGroup;
	}
}
