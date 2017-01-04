package interfaces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.detail.task.DashboardDetail;
import domain.detail.task.Task;

public class TextDataSource implements ExternalDataSource {

	String FILENAME = "E:/datatest/data.txt";
	BufferedReader br = null;
	FileReader fr = null;

	@Override
	public DashboardDetail readDashboardDetailFromExternalDatasource() throws Exception {
		try {
			DashboardDetail dashBoardDetail = new DashboardDetail();
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			br = new BufferedReader(new FileReader(FILENAME));
			List<String> result = new ArrayList<>();

			while ((sCurrentLine = br.readLine()) != null) {
				String sub = sCurrentLine.substring(sCurrentLine.indexOf(": ") + 1);
				result.add(sub);
			}
			dashBoardDetail.setSprintDate(result.get(1));
			dashBoardDetail.setTeam(result.get(0));
			return dashBoardDetail;

		} catch (IOException e) {
			e.printStackTrace();
			return null;

		}
	}

	@Override
	public List<Task> readTaskListFromExternalDatasource() throws Exception {

		try {
			List<Task> listTask = new ArrayList<Task>();
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			br = new BufferedReader(new FileReader(FILENAME));
			Task task = new Task();
			List<String> result = new ArrayList<>();

			while ((sCurrentLine = br.readLine()) != null) {
				String sub = sCurrentLine.substring(sCurrentLine.indexOf(": ") + 1);
				result.add(sub);
			}

			task.setTaskName(result.get(2));
			task.setTimeEstimate(result.get(3));
			task.setDueDate(result.get(4));
			task.setTaskGroup(result.get(5));
			task.setTimeCode(result.get(6));
			task.setTimeTracking(result.get(7));
			task.setStatusBefore(result.get(8));
			task.setStatusAfter(result.get(9));

			listTask.add(task);

			return listTask;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
	}

	@Override
	public List<DashboardDetail> readListDashboardDetailFromExternalDatasource() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
