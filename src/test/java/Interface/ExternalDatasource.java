package Interface;

import java.util.List;

import domain.detail.task.DashboardDetail;
import domain.detail.task.Task;

public interface ExternalDatasource {
	public DashboardDetail readDashboardDetailFromExternalDatasource() throws Exception;

	public List<Task> readTaskListFromExternalDatasource() throws Exception;
}
