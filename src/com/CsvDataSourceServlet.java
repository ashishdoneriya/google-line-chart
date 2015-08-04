package com;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.google.visualization.datasource.DataSourceServlet;
import com.google.visualization.datasource.base.DataSourceException;
import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.google.visualization.datasource.query.Query;
import com.google.visualization.datasource.util.CsvDataSourceHelper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/csv")
public class CsvDataSourceServlet extends DataSourceServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public DataTable generateDataTable(Query query, HttpServletRequest request)
			throws DataSourceException {
		DataTable dataTable = null;
		String csv = "2014-01-01 12:12:12,12000000000,14000000\n2014-01-01 13:13:13,9.2,12\n2014-01-01 14:14:14,2.0,32";
		List<ColumnDescription> columnsList = new ArrayList<ColumnDescription>();
		columnsList.add(new ColumnDescription("date", ValueType.DATETIME, "Time"));
		columnsList.add(new ColumnDescription("172.26.49.85", ValueType.NUMBER, "172.26.49.85"));
		columnsList.add(new ColumnDescription("192.168.2.1", ValueType.NUMBER, "192.168.2.1"));
		try {
			dataTable = CsvDataSourceHelper.read(new StringReader(csv), columnsList, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataTable;
	}

}
