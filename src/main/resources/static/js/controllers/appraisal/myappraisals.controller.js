app.controller('myappraisalsController', function($scope, $rootScope, $localStorage, appraisalServices, $state) {
	$rootScope.user = $localStorage.user;
	
	
	appraisalServices.getEmployeeAppraisals($rootScope.user.id).then(
			function(response) {
				$scope.appraisals = response.data;
			}, function(err) {
				console.log(err);
			});
	
	$scope.showAppraisal = function(id) {
		appraisalServices.get(id).then(function(response) {
			$localStorage.currentAppraisal = response.data;
			$state.go("stepHome", {}, {});
		}, function(err) {
			console.log(err);
		});
	};
});