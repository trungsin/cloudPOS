angular
  .module('SetBill',['ngMaterial'])
  .controller('TableController', ['$scope', function ($scope) {
    $scope.grid = [[1,2,3],[4,5,6],[7,8,9]];
    $scope.selectTable = function(item){
    	console.log(item);
    	var id = item.item; // 345
    	console.log(id);
    };
  }
    
  ]);