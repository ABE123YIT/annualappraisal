app.controller('profilController', function($scope, $localStorage, employeeServices) {
	$scope.employee = {};
	$scope.managerName = "";
	employeeServices.get($localStorage.user.id).then(
			function(response) {
				$scope.employee = response.data;
				$scope.employee.startDate = new Date($scope.employee.startDate);
				if($scope.employee.manager){
					$scope.managerName = $scope.employee.manager.firstName + ' ' + $scope.employee.manager.lastName;					
				}
			});
	
	$scope.update = function() {
		employeeServices.update($scope.employee.id, $scope.employee).then(function(data) {
		$scope.succes = "Employee updated successfully!";
		}, function(err) {
			console.log(err.data);
		});
	};
});