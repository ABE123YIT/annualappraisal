app.controller('employeeListController', function($scope,  employeeServices, searchNameFilter, searchManagerFilter) {
	
	$scope.currentPage = 0;
    $scope.pageSize = 4;
    $scope.employees = [];
    
    $scope.keyword = "";
    $scope.managerKeyword = "";
	
	$scope.get = function() {
		employeeServices.getAll().then(
				function(response) {
					console.log(response);
					$scope.employees = response.data;
					$scope.totalItems = $scope.employees.length;
					$scope.numberOfPages=function(){
				        return Math.ceil($scope.employees.length/$scope.pageSize);                
				    }
				}, function(err) {
					console.log(err.data);
				});
	};


	$scope.remove = function(id) {
		employeeServices.remove(id).then(function(response) {
			$scope.succes = "Employee deleted successfully";
		}, function(err) {
			console.log(err.data);
		});
	};
	
	$scope.$watch('keyword', function (newVal, oldVal) {
		$scope.filtered = searchNameFilter($scope.employees, newVal);
		$scope.totalItems = $scope.filtered.length;
		$scope.numberOfPages=function(){
	        return Math.ceil($scope.totalItems/$scope.pageSize);                
	    }
}, true);
	
	$scope.$watch('managerKeyword', function (newVal, oldVal) {
		$scope.filtered = searchManagerFilter($scope.employees, newVal);
		$scope.totalItems = $scope.filtered.length;
		$scope.numberOfPages=function(){
	        return Math.ceil($scope.totalItems/$scope.pageSize);                
	    }
}, true);

});
