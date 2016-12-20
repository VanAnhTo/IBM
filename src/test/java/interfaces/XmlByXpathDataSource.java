package interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import domain.detail.task.DashboardDetail;
import domain.detail.task.Task;

public class XmlByXpathDataSource implements ExternalDataSource {

	@Override
	public DashboardDetail readDashboardDetailFromExternalDatasource() throws Exception {
		try {

			DashboardDetail dashBoardDetail = new DashboardDetail();
			FileInputStream file = new FileInputStream(new File("src/test/resources/data/data.xml"));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document xmlDocument = builder.parse(file);
			XPath xPath = XPathFactory.newInstance().newXPath();

			String expression = "/workitem/teams/team/teamName";
			Node nodeTeam = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
			dashBoardDetail.setTeam(nodeTeam.getTextContent());

			expression = "/workitem/teams/team/sprints/sprint/sprintName";
			Node nodeSprint = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);
			dashBoardDetail.setSprintDate(nodeSprint.getTextContent());

			return dashBoardDetail;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Task> readTaskListFromExternalDatasource() throws Exception {
		try {
			List<Task> listTask = new ArrayList<Task>();
			FileInputStream file = new FileInputStream(new File("src/test/resources/data/data.xml"));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document xmlDocument = builder.parse(file);
			XPath xPath = XPathFactory.newInstance().newXPath();

			String expression = "/workitem/teams/team/sprints/sprint/tasks/task";
			NodeList nodeTaskList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			for (int i = 0; null != nodeTaskList && i < nodeTaskList.getLength(); i++) {
				NodeList nodeTask = nodeTaskList.item(i).getChildNodes();
				Task task = new Task();
				Element eTaskElement = (Element) nodeTask;
				task.setTaskName(eTaskElement.getElementsByTagName("taskname").item(0).getTextContent());
				task.setTimeEstimate(eTaskElement.getElementsByTagName("timeestimate").item(0).getTextContent());
				task.setDueDate(eTaskElement.getElementsByTagName("duedate").item(0).getTextContent());
				task.setTaskGroup(eTaskElement.getElementsByTagName("taskgroup").item(0).getTextContent());
				task.setTimeCode(eTaskElement.getElementsByTagName("timecode").item(0).getTextContent());
				task.setTimeTracking(eTaskElement.getElementsByTagName("timetracking").item(0).getTextContent());
				task.setStatusBefore(eTaskElement.getElementsByTagName("statusbefore").item(0).getTextContent());
				task.setStatusAfter(eTaskElement.getElementsByTagName("statusafter").item(0).getTextContent());

				listTask.add(task);
			}
			return listTask;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SAXException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
	}

}
