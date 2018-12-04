app.controller('stepObjectivesController', function($scope, $rootScope, $localStorage,
		objectiveServices) {
	$rootScope.user = $localStorage.user;
	$scope.appraisal = $localStorage.currentAppraisal;
	$scope.mode = "";

	objectiveServices.getByAppraisal($scope.appraisal.id).then(
			function(response) {
				$scope.objectives = response.data;
			}, function(err) {
				console.log(err);
			});

	$scope.save = function(model) {
		var obj = {
			label : model.label,
			indicator : model.indicator,
			mean : model.mean,
			deadline : model.deadline,
			annualAppraisal : {
				id : $scope.appraisal.id
			}
		}
		console.log(obj);
		objectiveServices.save(obj).then(
				function(response) {
					$scope.succes = "Objective added successfully!";
					$scope.mode = "";
					$scope.objectiveSelected = {};
					objectiveServices.getByAppraisal($scope.appraisal.id).then(
							function(response) {
								$scope.objectives = response.data;
							}, function(err) {
								console.log(err);
							});
				}, function(err) {
					console.log(err);
				});
	};

	$scope.update = function(id, model) {
		var objToEdit = {
			id : id,
			label : model.label,
			indicator : model.indicator,
			mean : model.mean,
			deadline : model.deadline,
			annualAppraisal : {
				id : $scope.appraisal.id
			}
		}
		objectiveServices.update(id, objToEdit).then(
				function(response) {
					$scope.succes = "Objective updated successfully!";
					$scope.mode = "";
					$scope.objective = {};
					objectiveServices.getByAppraisal($scope.appraisal.id).then(
							function(response) {
								$scope.objectives = response.data;
							}, function(err) {
								console.log(err);
							});
				}, function(err) {
					console.log(err);
				});
	};

	$scope.remove = function(id) {
		objectiveServices.remove(id).then(
				function(response) {
					$scope.succes = "Objective deleted successfully!";
					objectiveServices.getByAppraisal($scope.appraisal.id).then(
							function(response) {
								$scope.objectives = response.data;
							}, function(err) {
								console.log(err);
							});
				}, function(err) {
					console.log(err);
				});
	};

	$scope.editObjective = function(obj) {
		$scope.objectiveSelected = obj;
		$scope.objectiveSelected.deadline = new Date(obj.deadline);
		$scope.mode = "update";
	}

	$scope.createObjective = function() {
		$scope.mode = "create";
	}
});