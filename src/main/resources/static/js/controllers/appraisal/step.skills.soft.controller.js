app.controller('stepSoftSkillsController', function($scope, $rootScope, $localStorage, skillEvaluationServices) {
	$rootScope.user = $localStorage.user;
	$scope.appraisal = $localStorage.currentAppraisal;
	$scope.softskills = [];
	
	$scope.getAll = function() {
		skillEvaluationServices.getByAppraisalAndType($scope.appraisal.id, "Soft").then(function(response) {
			$scope.softskills = response.data;
		}, function(err) {
			console.log(err);
		});
	};
	
	$scope.save = function() {
		var models= [];
		console.log($scope.softskills);
		for(var i = 0; i < $scope.softskills.length; i++){
			for(var j = 0; j < $scope.softskills[i].skillLevelBeans.length; j++){
				if($scope.softskills[i].skillLevelBeans[j].checked){
					var obj = {
							annualAppraisal : {
								id : $scope.appraisal.id
							},
							skillLevel : {
								id : $scope.softskills[i].skillLevelBeans[j].id
							}
						};
					models.push(obj);
				}
			}
		 }
		
		skillEvaluationServices.saveAll(models, $scope.appraisal.id, "Soft").then(function(response) {
			$scope.getAll();
		}, function(err) {
			console.log(err);
		});
	};
	
	$scope.check = function(levels, level){
		for(var i = 0; i < levels.length; i++){
			levels[i].checked = false;
		}
		level.checked = true;
		console.log($scope.softskills);
	};
	
});