<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.lang.*,java.util.*, java.sql.*, 
     javax.sql.*, javax.naming.*,com.accident.mariadb.*, 
    java.io.UnsupportedEncodingException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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

</head>
<body>
<%
ArrayList<AccidentDTO> vec = new ArrayList<AccidentDTO>();
vec = (ArrayList<AccidentDTO>)request.getAttribute("data2");
%>
<script>

am4core.ready(function() {

am4core.useTheme(am4themes_animated);

// Create chart instance
var chart = am4core.create("chartdiv", am4charts.XYChart);




   <%
   Iterator iterator = vec.iterator();
   while (iterator.hasNext()) {
      AccidentDTO dto = (AccidentDTO)iterator.next();
      int year = dto.getYear();
      int death = dto.getDeath();
   %>
  chart.data.push({"year" : "<%=year%>",
		"death" : "<%=death%>"})
   <%
   }
%>
 
// Create axes
var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
dateAxis.renderer.grid.template.location = 0;
dateAxis.renderer.minGridDistance = 50;

var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

// Create series
var series = chart.series.push(new am4charts.LineSeries());
series.dataFields.valueY = "death";
series.dataFields.dateX = "year";
series.strokeWidth = 3;
series.fillOpacity = 0.5;

// Add vertical scrollbar
chart.scrollbarY = new am4core.Scrollbar();
chart.scrollbarY.marginLeft = 0;

// Add cursor
chart.cursor = new am4charts.XYCursor();
chart.cursor.behavior = "zoomY";
chart.cursor.lineX.disabled = true;

}); // end am4core.ready()
</script>

<!-- HTML -->
<center>
<h1 id="secssion">연도별 전체 사망 수</h1>
<h3>2000~2019</h3>
<div id="chartdiv"></div>
<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='./Accident_Main.html'">메뉴로 돌아가기</button>
</center>