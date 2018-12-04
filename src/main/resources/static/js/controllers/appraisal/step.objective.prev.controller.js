app.controller('stepLastObjectivesController', function($scope, $rootScope, $localStorage,
		objectiveServices, ratingServices, appraisalServices, annualsessionServices) {

	$scope.objectives = [];
	$scope.lastappraisal = {};
	$rootScope.user = $localStorage.user;
	$scope.appraisal = $localStorage.currentAppraisal;
	
	$scope.employee_id = $scope.appraisal.employee.id;
	$scope.sessionLabel = $scope.appraisal.annualSession.label;
	$scope.lastSession = parseInt($scope.sessionLabel) - 1;
	
	ratingServices.getAll().then(function(response) {
		$scope.ratings = response.data;
	});
	
	annualsessionServices.getByLabel($scope.lastSession).then(function(response) {
		$scope.sessionLast = response.data;
		appraisalServices.getByEmployeeAndSession($scope.employee_id, $scope.sessionLast.id).then(function(response) {
			$scope.lastappraisal = response.data;
			console.log($scope.lastappraisal);
			if($scope.lastappraisal){
				objectiveServices.getByAppraisal($scope.lastappraisal.id).then(
						function(response) {
							$scope.objectives = response.data;
						}, function(err) {
							console.log(err);
						});
			}
		});
	});
	
	$scope.save = function() {
		var objs= [];
		for(var i = 0; i < $scope.objectives.length; i++){
			var obj = {
					id : $scope.objectives[i].id,
					label : $scope.objectives[i].label,
					indicator : $scope.objectives[i].indicator,
					mean : $scope.objectives[i].mean,
					deadline : $scope.objectives[i].deadline,
					comment : $scope.objectives[i].comment,
					annualAppraisal : {
						id : $scope.lastappraisal.id
					},
					rating : {
						id : $scope.objectives[i].rating.id
					}
				};
			 objs.push(obj);
		 }
		
		objectiveServices.saveAll(objs).then(
				function(response) {
					$scope.succes = "Objectives updated successfully!";
					objectiveServices.getByAppraisal($scope.lastappraisal.id).then(
							function(response) {
								$scope.objectives = response.data;
							}, function(err) {
								console.log(err);
							});
				}, function(err) {
					console.log(err);
				});
	};
});