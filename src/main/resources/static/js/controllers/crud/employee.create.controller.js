app.controller('employeeCreateController', function($scope, employeeServices) {
	
	employeeServices.getManagers().then(function success(response) {
		$scope.managers = response.data;
	}, function error(err) {
		console.log(err.data);
	});

	$scope.save = function() {
		console.log($scope.employee);
		employeeServices.save($scope.employee).then(function(data) {
			$scope.succes = "Employee added successfully!";
			$scope.employee = null;
		}, function(err) {
			console.log(err.data);
		});
	};
	
});