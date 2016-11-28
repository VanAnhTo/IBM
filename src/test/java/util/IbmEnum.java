package util;

public class IbmEnum {

	public enum Status {
		START_WORKING("com.ibm.team.workitem.taskWorkflow.action.startWorking"),
		INVALIDATE("com.ibm.team.workitem.taskWorkflow.action.a2"),
		STOP_WORKING("com.ibm.team.workitem.taskWorkflow.action.stopWorking"), 
		COMPLETE("com.ibm.team.workitem.taskWorkflow.action.resolve"),
		REOPEN("com.ibm.team.workitem.taskWorkflow.action.reopen");
		public String value;

		private Status(String value) {
			this.value = value;
		}
	}
}
