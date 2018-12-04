app.controller('stepWishController', function($scope, $rootScope, $localStorage, appraisalServices) {
	$rootScope.user = $localStorage.user;
	$scope.appraisal = $localStorage.currentAppraisal;
	
	$scope.update = function() {
		var obj = {
				id : $scope.appraisal.id,
				strenghts : $scope.appraisal.strenghts,
				appraisalDate : $scope.appraisal.appraisalDate,
				improved : $scope.appraisal.improved,
				status : $scope.appraisal.status,
				additionalFeedback : $scope.appraisal.additionalFeedback,
				employeeWish : $scope.appraisal.employeeWish,
				managerOpinion : $scope.appraisal.managerOpinion,
				created : $scope.appraisal.created,
				updated : $scope.appraisal.updated,
				employee : {
					id : $scope.appraisal.employee.id
				},
				annualSession : {
					id : $scope.appraisal.annualSession.id
				}
			}
		console.log($scope.appraisal);
		appraisalServices.update($scope.appraisal.id, obj).then(
				function(response) {
					$scope.succes = "Appraisal updated successfully!";
							appraisalServices.get($scope.appraisal.id).then(function(response) {
								$localStorage.currentAppraisal = response.data;
								$scope.appraisal = $localStorage.currentAppraisal;
							}, function(err) {
								console.log(err);
							});
				}, function(err) {
					console.log(err);
				});
	};
});