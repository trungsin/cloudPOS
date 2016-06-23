<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Menu</title>
<title>Getting Started With ngGrid Example</title>  
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!-- Angular Material requires Angular.js Libraries -->
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-aria.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script>
    <script src="js/json2.js"></script>
  
<script type="text/javascript">

angular.module('SetBill',['ngMaterial'])
.controller('TableController', function ($scope, $http,$filter) {
	//Id table
  	$scope.grid = [[1,2,3],[4,5,6],[7,8,9]];
  	//list menu in bill
  	$scope.listMenuBill = [];
  	//list menu have not set to bill
    $scope.listFilterMenu = [];
    //list id menu selected to set bill
    $scope.listFilterMenuSelected = [];

    //function to controller when sale select table
    $scope.selectTable = function(item){
  	console.log(item);
  	var id = item.item; // 345
  	console.log(id);
	$http({
			  method  : 'POST',
			  url     : 'gettable',
			  headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			  transformRequest: function(obj) {
			        var str = [];
			        for(var p in obj)
			        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        return str.join("&");
			    },
			  data    : {id_table: id},  // pass in data as strings
			  headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
			 })
		.success(
	          function(data, status, headers, config) {
		          console.log(data);
	              $scope.menus = data;
	              $scope.listMenuBill = data.billList;
	              $scope.listFilterMenu = data.menuFilterList;
	              $scope.billDiscount = $scope.menus.bill.discount;
	                  
	          }).error(function(data, status, headers, config) {
	                         
	  });//end $http 
  	};//End $scope.selectTable

  	
	$scope.updateBill = function(){
		var tempmenus = $scope.listFilterMenuSelected;
		var tempId = 0;
		var foundItem; 
		var menu_bill_create;
		for (var i = 0; i < tempmenus.length; i++) 
		{
			tempId = tempmenus[i];
			foundItem = $filter('filter')($scope.listFilterMenu, { id: tempId  }, true)[0];
			var idx = $scope.listFilterMenu.indexOf(foundItem);
		      
		    // is currently selected
		    if (idx > -1) {
		    	 $scope.listFilterMenu.splice(idx, 1);
		    }
		    menu_bill_create = {
			    	"bill_id": $scope.menus.bill.id,
			    	"menu_id": foundItem.id,
			    	"menu": foundItem,
			    	"bill":$scope.menus.bill
			    };
		    console.log( menu_bill_create);
		    if($scope.listMenuBill==null)
		    	$scope.listMenuBill = [];
		    $scope.listMenuBill.push(menu_bill_create);
		    //console.log( menu_bill_create);
			console.log( $scope.listMenuBill);
		}
		$scope.listFilterMenuSelected = [];
	};//end scope.updateBill
	
	//function find menu
	$scope.findByNameMenu = function(){
		console.log('force:',$scope.namemenu);
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
			  data    : {findName: $scope.namemenu,target:"list"},  // pass in data as strings
			  headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
			 })
		.success(
                function(data, status, headers, config) {
                        $scope.listFilterMenu = data;
                        console.log(data);
                        
                }).error(function(data, status, headers, config) {
                               
        }); // end http
	};// end findByNameMenu

	//function controll when sale click select a menu
	$scope.toggleSelection = function toggleSelection(menu_id) {
	      var idx = $scope.listFilterMenuSelected.indexOf(menu_id);
	      
	      // is currently selected
	      if (idx > -1) {
	        $scope.listFilterMenuSelected.splice(idx, 1);
	      }
	      
	      // is newly selected
	      else {
	        $scope.listFilterMenuSelected.push(menu_id);
	      }
	      console.log($scope.listFilterMenuSelected);
	 };//toggleSelection
	 $scope.saveBill = function()
	 {
		 console.log(JSON.stringify($scope.listMenuBill));
		 $http({
			  method  : 'POST',
			  url     : 'saveBillAction',
			  headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			  transformRequest: function(obj) {
			        var str = [];
			        for(var p in obj)
			        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        return str.join("&");
			    },
			  data    : {strJson: JSON.stringify($scope.listMenuBill),target:"list"},  // pass in data as strings
			  headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
			 })
		.success(
               function(data, status, headers, config) {
                       $scope.listFilterMenu = data;
                       console.log(data);
                       
               }).error(function(data, status, headers, config) {
                              
       });
     };//end function saveBill
});
</script>
</head>
<body ng-app="SetBill" ng-controller="TableController" ng-cloak>


<div layout="row" layout-sm	="column">
  <div flex>
    <table class="menuTable" cellpadding="5px">
    	<tr> <th colspan="2"> BILL INFORMATION: </th></tr>
    	<s:form>
		<tr class="even">
			<th>Table:</th> <td>{{ menus.bill.post }}</td>
		</tr>
		<tr class="even">
			<th>User:</th> <td>{{ menus.bill.user_id }}</td>
		</tr>
		<tr class="even">
			<th>Create Time:</th> <td>{{ menus.bill.create_date }}</td>
		</tr>
		<tr class="even">
			<th>Discount:</th> <td><input name="billDiscount" type="text" ng-name="billDiscount" ng-model="billDiscount" value="{{ menus.bill.discount }}"/> </td>
		</tr>
		<tr class="even">
			<th>Total:</th> <td>{{ menus.bill.total }}</td>
		</tr>	
		</s:form>
    </table>
    <br>
    Bill Setted:
    <table class="menuTable" cellpadding="5px">
		<tr class="even">
			<th>Name Menu</th>
			<th>Menu Price</th>
			<th>User update</th>
			<th>Last update</th>
		</tr>
		<tr ng-repeat="bill in listMenuBill">
		    <td>
			    <s:url action="updateMenu" var="urlEdit">
			    	<s:param name="id">{{ bill.menu.id }}</s:param>
			    </s:url>
		    	<a href="<s:url value="/updateMenu?id" />{{ bill.menu.id }}" >{{ bill.menu.name }}</a>
		    </td>
		    <td>{{ bill.menu.price }}</td>
		    <td>{{ bill.menu.update_user }}</td>
		    <td>{{ bill.menu.update_time }}</td>
		</tr>
		<tr>
			<td colspan="4" >
				<button type="button" ng-click="saveBill();">Save Bill</button>
			</td>
		</tr>
	</table>
	List Menu To SELECT: <input name="namemenu" ng-name="namemenu" ng-change="findByNameMenu();" ng-model="namemenu" />
	<table class="menuTable" cellpadding="5px">
		<tr>
			<td colspan="5"><button type="button" ng-click="updateBill();">Add to bill!</button></td>
		</tr>
		<tr class="even">
			<th>Select</th>
			<th>Name Menu</th>
			<th>Menu Price</th>
			<th>User update</th>
			<th>Last update</th>
		</tr>
		<tr ng-repeat="menu in listFilterMenu">
			<td>
				<input type="checkbox" name="selectedMenus[]" value="{{ menu.id }}" ng-click="toggleSelection(menu.id)">
			</td>
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
		<tr>
			<td colspan="5"><button type="button" ng-click="updateBill();">Add to bill!</button></td>
		</tr>
	</table>
	<br>
    
  </div>
  <div flex>
  	<s:label>Select Table to set bill</s:label>
    <section  layout-fill layout="column">
    <div ng-repeat="row in grid" flex layout="row">
      <div ng-repeat="item in row" data-id ="{{ item }}" ng-click="selectTable(this);"  flex layout="row" layout-align="center center" layout-margin class="box">
        <h1 class="md-title">{{ item }}</h1>
      </div>
    </div>

  </section>

  </div>
</div>
  </body>

</html>