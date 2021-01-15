<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.lang.*,java.util.*, java.sql.*, 
     javax.sql.*, javax.naming.*,com.accident.mariadb.*, 
	 java.io.UnsupportedEncodingException, java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>전체 연도 사고량</title>
<style>
#chartdiv {
	width: 100%;
	height: 500px;
}

#secssion {
margin-top:8%;
}

</style>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>


<script src="https://cdn.amcharts.com/lib/4/core.js"></script>
<script src="https://cdn.amcharts.com/lib/4/charts.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/animated.js"></script>

<%
ArrayList<AccidentDTO> vec = new ArrayList<AccidentDTO>();
vec = (ArrayList<AccidentDTO>) request.getAttribute("data_allAccident");
%>

<script>
	am4core.ready(function() {

		am4core.useTheme(am4themes_animated);
		
		var chart = am4core.create("chartdiv", am4charts.XYChart);
		chart.scrollbarX = new am4core.Scrollbar();

<%
Iterator iterator = vec.iterator();
while (iterator.hasNext()) {
	AccidentDTO dto = (AccidentDTO)iterator.next();
	int year = dto.getYear();
	int accident = dto.getAccident();	
	
%>

	chart.data.push({"year" : "<%=year%>",
		"accident" : "<%=accident%>"})

<%	
}
%>
		// Create axes
		var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
		categoryAxis.dataFields.category = "year";
		categoryAxis.renderer.grid.template.location = 0;
		categoryAxis.renderer.minGridDistance = 30;
		categoryAxis.renderer.labels.template.horizontalCenter = "right";
		categoryAxis.renderer.labels.template.verticalCenter = "middle";
		categoryAxis.renderer.labels.template.rotation = 270;
		categoryAxis.tooltip.disabled = true;
		categoryAxis.renderer.minHeight = 110;

		var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
		valueAxis.renderer.minWidth = 50;

		// Create series
		var series = chart.series.push(new am4charts.ColumnSeries());
		series.sequencedInterpolation = true;
		series.dataFields.valueY = "accident";
		series.dataFields.categoryX = "year";
		series.tooltipText = "[{categoryX}: bold]{valueY}[/]";
		series.columns.template.strokeWidth = 0;

		series.tooltip.pointerOrientation = "vertical";

		series.columns.template.column.cornerRadiusTopLeft = 10;
		series.columns.template.column.cornerRadiusTopRight = 10;
		series.columns.template.column.fillOpacity = 0.8;

		// on hover, make corner radiuses bigger
		var hoverState = series.columns.template.column.states.create("hover");
		hoverState.properties.cornerRadiusTopLeft = 0;
		hoverState.properties.cornerRadiusTopRight = 0;
		hoverState.properties.fillOpacity = 1;

		series.columns.template.adapter.add("fill", function(fill, target) {
			return chart.colors.getIndex(target.dataItem.index);
		});

		// Cursor
		chart.cursor = new am4charts.XYCursor();

	}); // end am4core.ready()
</script>


</head>
<body>
<center>
	<h1 id="secssion">연도별 전체 사고량</h1>
	<h3>2000~2019</h3>
	<div id="chartdiv"></div>
	<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='./Accident_Main.html'">메뉴로 돌아가기</button>
</center>
</body>
</html>