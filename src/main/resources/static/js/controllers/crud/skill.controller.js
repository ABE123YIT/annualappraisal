app.controller('skillController', function($scope, skillServices, skillLevelServices) {
	
	$scope.currentPage = 0;
    $scope.pageSize = 5;
    $scope.skills = [];
    $scope.skill = {};
    $scope.skillLevel = {};

	$scope.save = function(model) {
		skillServices.save(model).then(function(response) {
			$scope.succes = "Skill added successfully!";
			$scope.skill = {};
			skillServices.getAll().then(function(resp) {
				$scope.skills = resp.data;
				$scope.totalItems = $scope.skills.length;
				$scope.numberOfPages=function(){
			        return Math.ceil($scope.skills.length/$scope.pageSize);                
			    }
			}, function(err) {
				console.log(err);
			});
		}, function(err) {
			console.log(err);
		});
	};
	
	$scope.saveLevel = function(model) {
		var level = {
				ranking:model.ranking,
				meaning:model.meaning,
				skill:{
					id:model.skill.id
				}
		}
		skillLevelServices.save(level).then(function(response) {
			$scope.succes = "Level added successfully!";
			$scope.skillLevel = {};
			skillServices.getAll().then(function(resp) {
				console.log(resp.data);
				$scope.skills = resp.data;
				$scope.totalItems = $scope.skills.length;
				$scope.numberOfPages=function(){
			        return Math.ceil($scope.skills.length/$scope.pageSize);                
			    }
			}, function(err) {
				console.log(err);
			});
		}, function(err) {
			console.log(err);
		});
	};

	$scope.update = function(id, model) {
		skillServices.update(id, model).then(function(response) {
			$scope.succes = "Skill updated successfully!";
			skillServices.getAll().then(function(resp) {
				$scope.skills = resp.data;
				$scope.totalItems = $scope.skills.length;
				$scope.numberOfPages=function(){
			        return Math.ceil($scope.skills.length/$scope.pageSize);                
			    }
			}, function(err) {
				console.log(err);
			});
		}, function(err) {
			console.log(err);
		});
	};
	
	$scope.updateLevel = function(id, model) {
		var levelToEdit = {
				ranking:model.ranking,
				meaning:model.meaning,
				skill:{
					id:model.skill.id
				}
		}
		skillLevelServices.update(id, levelToEdit).then(function(response) {
			$scope.succes = "Level updated successfully!";
			skillServices.getAll().then(function(resp) {
				$scope.skills = resp.data;
				$scope.totalItems = $scope.skills.length;
				$scope.numberOfPages=function(){
			        return Math.ceil($scope.skills.length/$scope.pageSize);                
			    }
			}, function(err) {
				console.log(err);
			});
		}, function(err) {
			console.log(err);
		});
	};

	$scope.remove = function(id) {
		skillServices.remove(id).then(function(response) {
			$scope.succes = "Skill deleted successfully!";
			skillServices.getAll().then(function(resp) {
				$scope.skills = resp.data;
				$scope.totalItems = $scope.skills.length;
				$scope.numberOfPages=function(){
			        return Math.ceil($scope.skills.length/$scope.pageSize);                
			    }
			}, function(err) {
				console.log(err.resp);
			});
		}, function(err) {
			console.log(err.response);
		});
	};
	
	$scope.removeLevel = function(id) {
		skillLevelServices.remove(id).then(function(response) {
			$scope.succes = "Level deleted successfully!";
			skillServices.getAll().then(function(resp) {
				$scope.skills = resp.data;
				$scope.totalItems = $scope.skills.length;
				$scope.numberOfPages=function(){
			        return Math.ceil($scope.skills.length/$scope.pageSize);                
			    }
			}, function(err) {
				console.log(err.resp);
			});
		}, function(err) {
			console.log(err.response);
		});
	};

	$scope.getAll = function() {
		skillServices.getAll().then(function(response) {
			$scope.skills = response.data;
			$scope.totalItems = $scope.skills.length;
			$scope.numberOfPages=function(){
		        return Math.ceil($scope.skills.length/$scope.pageSize);                
		    }
			console.log($scope.skills);
		}, function(err) {
			console.log(err);
		});
	};

	$scope.setModal = function(obj) {
		$scope.selectedSkill = obj;
	}
	
	$scope.setLevelAddModal = function(obj) {
		$scope.skillLevel.skill = obj;
	}
	
	$scope.setLevelModal = function(level,skill) {
		$scope.skillLevelSelected = level;
		$scope.skillLevelSelected.skill = skill;
	}
	
});