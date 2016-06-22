<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Menu</title>
<script type="text/javascript"  src="js/angular/angular.js"></script>
<!--<script type="text/javascript" src="js/controller/menu.js"></script>-->

<script type="text/javascript">
angular.module('Menu', []).
controller('MenuController',function($scope, $http){
	//$scope.items = [];
	//var menu = this;
		$scope.name = '<s:property value="menu.name"/>';
		$scope.description = '<s:property value="menu.description"/>';
		$scope.price = '<s:property value="menu.price"/>';
		$scope.price_extend = '<s:property value="menu.price_extend"/>';
		console.log($scope.name);
	$scope.findByName = function(){
		console.log('force:',$scope.name);
		$http({
			  method  : 'POST',
			  url     : 'findMenuAction',
			  headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			  transformRequest: function(obj) {
			        var str = [];
			        for(var p in obj)
			        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        return str.join("&");
			    },
			  data    : {findName: $scope.name,target:"list"},  // pass in data as strings
			  headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
			 })
		.success(
                function(data, status, headers, config) {
                        $scope.menus = data;
                        console.log(data);
                        
                }).error(function(data, status, headers, config) {
                               
        });
	}
});
</script>
</head>
<body ng-app="Menu">
<div ng-controller="MenuController">

<s:form action="save" method="get">
	<s:push value="menu">
		<s:hidden name="id"></s:hidden>
		<s:textfield name="name" ng-name="name" ng-change="findByName();" ng-model="name" label="Menu Name" />
		<s:textarea name="description" ng-model="description" label="Description" />
		<s:textfield name="price" ng-model="price" label="Price"></s:textfield>
		<s:textfield name="price_extend" ng-model="price_extend" label="Price Extend"></s:textfield>	
		<s:submit />
	</s:push>
</s:form>
	<div class="content">
	
	<table class="menuTable" cellpadding="5px">
		<tr class="even">
			<th>Name Menu</th>
			<th>Menu Price</th>
			<th>User update</th>
			<th>Last update</th>
		</tr>
		<tr ng-repeat="menu in menus">
		    <td>
			    <s:url action="updateMenu" var="urlEdit">
			    	<s:param name="id">{{ menu.id }}</s:param>
			    </s:url>
		    	<a href="<s:url value="/updateMenu?id" />{{ menu.id }}" >{{ menu.name }}</a>
		    </td>
		    <td>{{ menu.price }}</td>
		    <td>{{ menu.update_user }}</td>
		    <td>{{ menu.update_time }}</td>
		</tr>
	</table>
	</div>
</div>

</body>
</html>