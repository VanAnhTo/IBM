package interfaces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.detail.task.DashboardDetail;
import domain.detail.task.Task;

public class TextMultiDataSource implements ExternalDataSource {
	String FILENAME = "E:/datatest/multidata.txt";
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
			String[] arr = null;
			int i = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				if (i > 1) {
					String sub = sCurrentLine.substring(sCurrentLine.indexOf(": ") + 1);
					arr = sub.split("\\|");
					task.setTaskName(arr[0]);
					task.setTimeEstimate(arr[1]);
					task.setDueDate(arr[2]);
					task.setTaskGroup(arr[3]);
					task.setTimeCode(arr[4]);
					task.setTimeTracking(arr[5]);
					task.setStatusBefore(arr[6]);
					task.setStatusAfter(arr[7]);
					listTask.add(task);
				}
				i++;
			}
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
