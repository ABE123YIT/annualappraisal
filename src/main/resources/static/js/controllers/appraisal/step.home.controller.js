app.controller('stepHomeController', function($scope, $rootScope, $localStorage, appraisalServices) {
	$rootScope.user = $localStorage.user;
	$scope.appraisal = $localStorage.currentAppraisal;
	$scope.employee = $scope.appraisal.employee;
	$scope.manager = $scope.employee.manager;
	console.log($scope.appraisal);
	console.log($scope.employee);
	console.log($scope.manager);
});