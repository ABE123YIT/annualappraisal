app.controller('stepFeedbacksController', function($scope, $rootScope,
		$localStorage, appraisalfeedbackServices, appraisalServices) {
	$rootScope.user = $localStorage.user;
	$scope.appraisal = $localStorage.currentAppraisal;

	appraisalfeedbackServices.getByAppraisal($scope.appraisal.id).then(
			function(response) {
				$scope.appraisalfeedbacks = response.data;
			}, function(err) {
				console.log(err);
			});

	$scope.save = function() {
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
		
		appraisalServices.update($scope.appraisal.id, obj).then(
				function(response) {
							appraisalServices.get($scope.appraisal.id).then(function(response) {
								$localStorage.currentAppraisal = response.data;
								$scope.appraisal = $localStorage.currentAppraisal;
							}, function(err) {
								console.log(err);
							});
				}, function(err) {
					console.log(err);
				});
		console.log($scope.appraisalfeedbacks);
		var objs= [];
		for(var i = 0; i < $scope.appraisalfeedbacks.length; i++){
			 var obj = {
						id:$scope.appraisalfeedbacks[i].id,
						comment:$scope.appraisalfeedbacks[i].comment,
						annualAppraisal:{
							id:$scope.appraisal.id
										},
						feedback:{
							id:$scope.appraisalfeedbacks[i].feedback.id
								}
					};
			 objs.push(obj);
		 }
		console.log(objs);
		appraisalfeedbackServices.saveAll(objs).then(
				function(response) {
					appraisalfeedbackServices.getByAppraisal($scope.appraisal.id).then(
							function(response) {
								$scope.appraisalfeedbacks = response.data;
								console.log($scope.appraisalfeedbacks);
							}, function(err) {
								console.log(err);
							});
				}, function(err) {
					console.log(err);
				});
	}

});