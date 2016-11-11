package domain.detail.task;

public class TaskNameDetail {
	private String taskName;
	private String timeEstimate;
	
	public TaskNameDetail(String taskName) {
		this.taskName = taskName;
	}
	
	public TaskNameDetail(String taskName, String timeEstimate) {
		this.taskName = taskName;
		this.timeEstimate = timeEstimate;
	}

	public String getTaskName() {
		return taskName;
	}
	
	public String getTimeEstimate() {
		return timeEstimate;
	}
}
