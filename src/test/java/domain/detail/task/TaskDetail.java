package domain.detail.task;

public class TaskDetail {
	private String taskName;
	private String timeEstimate;
	private String timeTracking;
	private String workDay;

	public TaskDetail(String taskName) {
		this.taskName = taskName;
	}

	public TaskDetail(String taskName, String timeEstimate, String dayOfWeek, String timeTracking) {
		this.taskName = taskName;
		this.timeEstimate = timeEstimate;
		this.workDay = dayOfWeek;
		this.timeTracking = timeTracking;
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
}
