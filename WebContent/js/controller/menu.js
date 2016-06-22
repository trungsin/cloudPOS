  angular.module('Menu', []).
	controller('MenuController',function($scope, $http){
		//$scope.items = [];
		//var menu = this;
		$scope.findByName = function(){
			console.log('force',$scope.name);
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