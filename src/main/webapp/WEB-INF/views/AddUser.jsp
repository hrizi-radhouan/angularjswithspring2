<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="serviceModule" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Users using ajax</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
</head>
<body ng-controller="AngularJSPostController">
	<h2 align="center">Welcome to AJAX</h2>
	<div align="center">
	

		<c:forEach items="${variablesListModel.getListVaraibles()}" var="row">
	
		<label>${row.getName()} :<input type="checkbox" id="${row.getId()}" name="${row.getName()}" value="${row.getName()}"
			ng-click="doAjaxPost('${row.getId()}','${row.getName()}','${row.getMiniBudget()}','${row.getMaxBudget()}')"><br /></label>
		
		</c:forEach>
		
		
	</div>
	
	
	<div id="disp" align="center">
	<table border="2px"><tr><td>Variable</td><td>Mini Budget</td><td>Max Budget</td></tr></table>
	</div>
	
	<div >
	<script type="text/javascript">
	
	var serviceModule = angular.module('serviceModule', []);
	
	serviceModule.controller("AngularJSPostController", function($scope, $http) {
		
		$scope.variable = "AngularJS POST Spring MVC Example:";	
		$scope.doAjaxPost = function doAjaxPost(id,nameVariable,miniBudget,maxBudget) {
			
			if(event.target.checked){
				
				var json ={};
				json['id']=id;
				json['name']=nameVariable;
				json['miniBudget']=miniBudget;
				json['maxBudget']=maxBudget;
				var response = $http.post('AddUser.htm', json);
			
				response.success(function(fromServerjson, status, headers, config) {
					
			    	var myTable ="<table border=\"2px\"><tr><td>Variable</td><td>Mini Budget</td><td>Max Budget</td></tr>";
					
					var variables = fromServerjson.split(";")
					var myRes="";
					
					for(item in  variables){
					variable = variables[item];
						var res = variable.split(":");
						var name = "<tr><td>"+res['1']+"</td>";
						var miniBudget = "<td>"+res['2']+"</td>";
						var maxBudget = "<td>"+res['3']+"</td></tr>";
						myRes=name+miniBudget+maxBudget+myRes;
					}
				var finalRes=myTable+myRes+"</table>" 
					$('#disp').html(finalRes);
					});
				
				response.error(function(fromServerjson, status, headers, config) {alert( "Exception details: " + JSON.stringify({data: fromServerjson}));});
				
			}else{
				
				

				var json ={};
				json['id']=id;
				json['name']=nameVariable;
				json['miniBudget']=miniBudget;
				json['maxBudget']=maxBudget;
				var response = $http.post('DeleUser.htm', json);
				
				
				response.success(function(fromServerjson, status, headers, config) {
					
					
					
			    	var myTable ="<table border=\"2px\"><tr><td>Variable</td><td>Mini Budget</td><td>Max Budget</td></tr>";
					
					var variables = fromServerjson.split(";")
					var myRes="";
					
					for(item in  variables){
					variable = variables[item];
						var res = variable.split(":");
						var name = "<tr><td>"+res['1']+"</td>";
						var miniBudget = "<td>"+res['2']+"</td>";
						var maxBudget = "<td>"+res['3']+"</td></tr>";
						myRes=name+miniBudget+maxBudget+myRes;
					}
				var finalRes=myTable+myRes+"</table>" 
					$('#disp').html(finalRes);
					});
				
				response.error(function(fromServerjson, status, headers, config) {alert( "Exception details: " + JSON.stringify({data: fromServerjson}));});
			}
		}
		});
	
</script>
	
	

	</div>

</body>
</html>