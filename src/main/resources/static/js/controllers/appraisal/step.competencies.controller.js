app.controller('stepCompetenciesController', function($scope, $rootScope,
		$localStorage, competencieServices, ratingServices) {

	$rootScope.user = $localStorage.user;
	$scope.appraisal = $localStorage.currentAppraisal;
	$scope.mode = "";

	ratingServices.getAll().then(function(response) {
		$scope.ratings = response.data;
	});

	competencieServices.getByAppraisal($scope.appraisal.id).then(
			function(response) {
				$scope.competencies = response.data;
			}, function(err) {
				console.log(err.response);
			});

	$scope.save = function(model) {
		var competency = {
				label:model.label,
				meaning:model.meaning,
				comment:model.comment,
				rating:{
					id:model.rating.id
				},
				annualAppraisal:{
					id:$scope.appraisal.id
				}
		}
		console.log(competency);
		competencieServices.save(competency).then(
				function(response) {
					$scope.succes = "Competency added successfully!";
					$scope.mode = "";
					$scope.competencieSelected = {};
					competencieServices.getByAppraisal($scope.appraisal.id)
							.then(function(response) {
								$scope.competencies = response.data;
							}, function(err) {
								console.log(err.response);
							});
				}, function(err) {
					console.log(err);
				});
	};

	$scope.update = function(id, model) {
		var competencyToEdit = {
				id:id,
				label:model.label,
				meaning:model.meaning,
				comment:model.comment,
				rating:{
					id:model.rating.id
				},
				annualAppraisal:{
					id:$scope.appraisal.id
				}
		}
		console.log(model);
		competencieServices.update(id, competencyToEdit).then(
				function(response) {
					$scope.succes = "Competency updated successfully!";
					$scope.mode = "";
					$scope.competencie = {};
					competencieServices.getByAppraisal($scope.appraisal.id)
							.then(function(response) {
								$scope.competencies = response.data;
							}, function(err) {
								console.log(err);
							});
				}, function(err) {
					console.log(err);
				});
	};

	$scope.remove = function(id) {
		competencieServices.remove(id).then(
				function(response) {
					$scope.succes = "Competency deleted successfully!";
					competencieServices.getByAppraisal($scope.appraisal.id)
							.then(function(response) {
								$scope.competencies = response.data;
							}, function(err) {
								console.log(err);
							});
				}, function(err) {
					console.log(err);
				});
	};

	$scope.editCompetencie = function(obj) {
		$scope.competencieSelected = obj;
		$scope.mode = "update";
	}

	$scope.createCompetencie = function() {
		$scope.mode = "create";
	}
});