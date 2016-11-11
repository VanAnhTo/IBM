package domain.builder.task;

import domain.detail.task.TaskNameDetail;

public class TaskNamelBuilder {
	private String taskName;
	private String timeEstimate;
   
    public TaskNamelBuilder withTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }
    
    public TaskNamelBuilder withTimeEstimate(String timeEstimate) {
        this.timeEstimate = timeEstimate;
        return this;
    }
    
    public TaskNameDetail build() {
        return new TaskNameDetail(taskName,timeEstimate);
    }
   
}
