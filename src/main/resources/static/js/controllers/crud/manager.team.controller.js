app.controller('managerTeamController', function($scope, $rootScope, $localStorage, $state,
		employeeServices, appraisalServices, searchNameFilter) {

	$scope.currentPage = 0;
	$scope.pageSize = 10;
	$scope.employees = [];
	$scope.appraisals = [];

	$scope.keyword = "";
	$rootScope.user = $localStorage.user;

	$scope.get = function() {
		employeeServices.getTeam($localStorage.user.id).then(function(response) {
			console.log(response);
			$scope.employees = response.data;
			$scope.totalItems = $scope.employees.length;
			$scope.numberOfPages = function() {
				return Math.ceil($scope.employees.length / $scope.pageSize);
			}
		}, function(err) {
			console.log(err.data);
		});
	};

	$scope.getAppraisals = function(employee_id, date) {
		appraisalServices.getAppraisalsHistory(employee_id, date).then(
				function(response) {
					$scope.appraisals = response.data;
				}, function(err) {
					console.log(err);
				});
	};

	$scope.createAppraisal = function(session_id, employee_id) {
		var model = {
				status:"In progress",
			employee : {
				id : employee_id
			},
			annualSession : {
				id : session_id
			}
		}
		appraisalServices.save(model).then(function(response) {
			$localStorage.currentAppraisal = response.data;
			$('#appraisalsModal').modal('hide');
			$state.go("stepHome", {}, {});
		}, function(err) {
			console.log(err);
		});
	};

	$scope.showAppraisal = function(id) {
		appraisalServices.get(id).then(function(response) {
			$localStorage.currentAppraisal = response.data;
			$('#appraisalsModal').modal('hide');
			$state.go("stepHome", {}, {});
		}, function(err) {
			console.log(err);
		});
	};

	$scope.$watch('keyword', function(newVal, oldVal) {
		$scope.filtered = searchNameFilter($scope.employees, newVal);
		$scope.totalItems = $scope.filtered.length;
		$scope.numberOfPages = function() {
			return Math.ceil($scope.totalItems / $scope.pageSize);
		}
	}, true);

});
