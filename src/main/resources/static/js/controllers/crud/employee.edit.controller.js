app.controller('employeeEditController', function($scope, employeeServices, $stateParams) {
	$scope.manageres = [];
	$scope.selectedManager = {};
	employeeServices.get($stateParams.id).then(
			function(response) {
				$scope.employeeToEdit = response.data;
				$scope.employeeToEdit.startDate = new Date($scope.employeeToEdit.startDate);
			});
	
	employeeServices.getManagers().then(function success(response) {
		$scope.manageres = response.data;
		for(var m of $scope.manageres){
			if($stateParams.managerId == m.id){
				$scope.selectedManager = m;
			}
		}
	}, function error(err) {
		console.log(err.data);
	});
	
	
	$scope.update = function() {
		if($scope.selectedManager){
			$scope.employeeToEdit.manager = $scope.selectedManager;
		}
		employeeServices.update($scope.employeeToEdit.id, $scope.employeeToEdit).then(function(data) {
		$scope.succes = "Employee updated successfully!";
		}, function(err) {
			console.log(err.data);
		});
	};
});