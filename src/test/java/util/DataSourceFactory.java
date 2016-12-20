package util;

import java.io.IOException;

import interfaces.TextMultiDataSource;
import interfaces.XmlByXpathDataSource;
import interfaces.ExcelDataSource;
import interfaces.ExternalDataSource;
import interfaces.XmlDataSource;

public class DataSourceFactory {

	public static ExternalDataSource createDataSource() throws IOException {
		// TODO Auto-generated method stub
		ExternalDataSource source = null;
		String dataSource = PropertiesStore.getProperty("datasource");
		switch (dataSource) {
		case "excel":
			source = new ExcelDataSource();
			break;
		case "xml":
			source = new XmlDataSource();
			break;
		case "xpath":
			source = new XmlByXpathDataSource();
			break;
		case "txt":
			source = new TextMultiDataSource();
			break;
		default:
			source = new ExcelDataSource();
			break;
		}
		return source;
	}

}
