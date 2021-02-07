<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.lang.*,
    java.util.Iterator,
    java.util.ArrayList, 
    java.sql.*, 
     javax.sql.*, javax.naming.*,com.accident.mariadb.*, 
    java.io.UnsupportedEncodingException, java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>특정 연도 사고정보</title>
</head>
<style>
#chartdiv {
	width: 100%;
	height: 500px;
}

#secssion {
margin-top:8%;
}
</style>


<script src="https://cdn.amcharts.com/lib/4/core.js"></script>
<script src="https://cdn.amcharts.com/lib/4/charts.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/animated.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>


<!-- Chart code -->
<script>
	
<%AccidentDAO dao = new AccidentDAO();
String year = (String) request.getAttribute("data2");
int yearin = Integer.parseInt(year);

ArrayList<AccidentDTO> vec = new ArrayList<AccidentDTO>();
vec = dao.selectAccident(yearin);
out.print(yearin);%>
	am4core
			.ready(function() {

				// Themes begin
				am4core.useTheme(am4themes_animated);
				// Themes end

				var chart = am4core.create("chartdiv", am4charts.XYChart);
				chart.hiddenState.properties.opacity = 0; // this creates initial fade-in
<%Iterator iterator = vec.iterator();
while (iterator.hasNext()) {
	AccidentDTO dto = (AccidentDTO) iterator.next();%>
	chart.data = [ {
					target : "교통사고 횟수",
					num :
<%=dto.getAccident()%>
	}, {
					target : "사망자",
					num :
<%=dto.getDeath()%>
	}, {
					target : "부상자",
					num :
<%=dto.getInjury()%>
	} ];
<%}%>
	var categoryAxis = chart.xAxes
						.push(new am4charts.CategoryAxis());
				categoryAxis.renderer.grid.template.location = 0;
				categoryAxis.dataFields.category = "target";
				categoryAxis.renderer.minGridDistance = 40;
				categoryAxis.fontSize = 11;

				var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
				valueAxis.min = 0;
				valueAxis.max = 4000;
				valueAxis.strictMinMax = true;
				valueAxis.renderer.minGridDistance = 30;

				var series = chart.series.push(new am4charts.ColumnSeries());
				series.dataFields.categoryX = "target";
				series.dataFields.valueY = "num";
				series.columns.template.tooltipText = "{valueY.value}";
				series.columns.template.tooltipY = 0;
				series.columns.template.strokeOpacity = 0;

				// as by default columns of the same series are of the same color, we add adapter which takes colors from chart.colors color set
				series.columns.template.adapter.add("fill", function(fill,
						target) {
					return chart.colors.getIndex(target.dataItem.index);
				});

			}); // end am4core.ready()
</script>
<body>
<center>
	<h1 id="secssion">연도별 전체 사고량</h1>
	<h3>2000~2019</h3>
	<div id="chartdiv"></div>
	<a href="Accident_main.html" value="메인화면으로"></a>
	<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='./Accident_Main.html'">메뉴로 돌아가기</button>
</center>
</body>
</html>