package interfaces;

import java.util.List;

import domain.detail.task.DashboardDetail;
import domain.detail.task.Task;

public interface ExternalDataSource {
	
	public DashboardDetail readDashboardDetailFromExternalDatasource() throws Exception;
	public List<Task> readTaskListFromExternalDatasource() throws Exception;
	public List<DashboardDetail> readListDashboardDetailFromExternalDatasource() throws Exception;
}
