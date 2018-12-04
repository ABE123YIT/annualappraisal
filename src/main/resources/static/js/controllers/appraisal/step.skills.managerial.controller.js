app.controller('stepManagerialSkillsController', function($scope, $rootScope, $localStorage, skillEvaluationServices) {
	$rootScope.user = $localStorage.user;
	$scope.appraisal = $localStorage.currentAppraisal;
	$scope.managerialskills = [];
	
	$scope.getAll = function() {
		skillEvaluationServices.getByAppraisalAndType($scope.appraisal.id, "Managerial").then(function(response) {
			$scope.managerialskills = response.data;
		}, function(err) {
			console.log(err);
		});
	};
	
	$scope.save = function() {
		var models= [];
		console.log($scope.managerialskills);
		for(var i = 0; i < $scope.managerialskills.length; i++){
			for(var j = 0; j < $scope.managerialskills[i].skillLevelBeans.length; j++){
				if($scope.managerialskills[i].skillLevelBeans[j].checked){
					var obj = {
							annualAppraisal : {
								id : $scope.appraisal.id
							},
							skillLevel : {
								id : $scope.managerialskills[i].skillLevelBeans[j].id
							}
						};
					models.push(obj);
				}
			}
		 }
		
		skillEvaluationServices.saveAll(models, $scope.appraisal.id, "Managerial").then(function(response) {
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
		console.log($scope.managerialskills);
	};
});