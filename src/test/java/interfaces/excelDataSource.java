package interfaces;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import domain.detail.task.DashboardDetail;
import domain.detail.task.Task;
import util.ExcelCommon_POI;

public class excelDataSource implements externalDataSource {

	@Override
	public DashboardDetail readDashboardDetailFromExternalDatasource() throws Exception {
		DashboardDetail dashBoardDetail = new DashboardDetail();
		XSSFSheet taskSheet = ExcelCommon_POI.setExcelFile("src/test/resources/data/task.xlsx", "task");
		int rowDashboard = 2;
		int columDashboard = 1;
		dashBoardDetail.setTeam(ExcelCommon_POI.getCellData(rowDashboard, columDashboard++, taskSheet));
		dashBoardDetail.setSprintDate(ExcelCommon_POI.getCellData(rowDashboard, columDashboard++, taskSheet));
		return dashBoardDetail;
	}

	@Override
	public List<Task> readTaskListFromExternalDatasource() throws Exception {
		XSSFSheet taskSheet = ExcelCommon_POI.setExcelFile("src/test/resources/data/task.xlsx", "task");
		int startRowTask = taskSheet.getFirstRowNum() + 5;
		int endRowTask = taskSheet.getLastRowNum();

		List<Task> listTask = new ArrayList<Task>();

		for (int indexR = startRowTask; indexR <= endRowTask; indexR++) {
			Task task = new Task();
			int startColum = 1;
			task.setTaskName(ExcelCommon_POI.getCellData(indexR, startColum++, taskSheet));
			task.setTimeEstimate(ExcelCommon_POI.getCellData(indexR, startColum++, taskSheet));
			task.setDueDate(ExcelCommon_POI.getCellData(indexR, startColum++, taskSheet));
			task.setTaskGroup(ExcelCommon_POI.getCellData(indexR, startColum++, taskSheet));
			task.setTimeCode(ExcelCommon_POI.getCellData(indexR, startColum++, taskSheet));
			task.setTimeTracking(ExcelCommon_POI.getCellData(indexR, startColum++, taskSheet));
			task.setStatusBefore(ExcelCommon_POI.getCellData(indexR, startColum++, taskSheet));
			task.setStatusAfter(ExcelCommon_POI.getCellData(indexR, startColum++, taskSheet));
			listTask.add(task);
		}
		return listTask;
	}

}
