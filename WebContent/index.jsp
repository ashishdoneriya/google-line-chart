<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onload="drawVisualization()">
	<div id="chart_div" style="width:400; height:300;"></div>
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript">
	// Load the Visualization API library and the piechart library.
 	google.load('visualization', '1.0', {'packages':['corechart', 'table', 'orgchart', 'line']});

//	google.setOnLoadCallback(drawVisualization);
	function drawVisualization() {
		var query = new google.visualization.Query('csv?djasdhshj=sdfsdf&');
		query.send(handleQueryResponse);
	}
	
	function handleQueryResponse(response) {
	    if (response.isError()) {
	        alert('Error in query: ' + response.getMessage() + ' ' + response.getDetailedMessage());
	        return;
	    }
	    var data = response.getDataTable();
	    var table = new google.visualization.LineChart(document.getElementById('chart_div'));
	      var options = {
	    	        hAxis: {
	    	          title: 'Time'
	    	        },
	    	        vAxis: {
	    	          title: 'Popularity',
	    	          format: 'short'
	    	        }
	    	      };
	    table.draw(data, options);
	}
	</script>
</body>
</html>