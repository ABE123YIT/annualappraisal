app.controller('annualsessionController', function($scope, annualsessionServices) {
	
	$scope.currentPage = 0;
    $scope.pageSize = 5;
    $scope.annualsessions = [];

	$scope.save = function(model) {
		annualsessionServices.save(model).then(function(response) {
			$scope.succes = "Session added successfully!";
			$scope.annualSession = {};
			annualsessionServices.getAll().then(function(resp) {
				$scope.annualsessions = resp.data;
				$scope.totalItems = $scope.annualsessions.length;
				$scope.numberOfPages=function(){
			        return Math.ceil($scope.annualsessions.length/$scope.pageSize);                
			    }
			}, function(err) {
				console.log(err.resp);
			});
		}, function(err) {
			console.log(err.response);
		});
	};

	$scope.update = function(id, model) {
		annualsessionServices.update(id, model).then(function(response) {
			$scope.succes = "Session updated successfully!";
			annualsessionServices.getAll().then(function(resp) {
				$scope.annualsessions = resp.data;
				$scope.totalItems = $scope.annualsessions.length;
				$scope.numberOfPages=function(){
			        return Math.ceil($scope.annualsessions.length/$scope.pageSize);                
			    }
			}, function(err) {
				console.log(err.resp);
			});
		}, function(err) {
			console.log(err.response);
		});
	};

	$scope.remove = function(id) {
		annualsessionServices.remove(id).then(function(response) {
			$scope.succes = "Session deleted successfully!";
			annualsessionServices.getAll().then(function(resp) {
				$scope.annualsessions = resp.data;
				$scope.totalItems = $scope.annualsessions.length;
				$scope.numberOfPages=function(){
			        return Math.ceil($scope.annualsessions.length/$scope.pageSize);                
			    }
			}, function(err) {
				console.log(err.resp);
			});
		}, function(err) {
			console.log(err.response);
		});
	};

	$scope.getAll = function() {
		annualsessionServices.getAll().then(function(response) {
			$scope.annualsessions = response.data;
			$scope.totalItems = $scope.annualsessions.length;
			$scope.numberOfPages=function(){
		        return Math.ceil($scope.annualsessions.length/$scope.pageSize);                
		    }
		}, function(err) {
			console.log(err.response);
		});
	};

	$scope.setModal = function(obj) {
		$scope.selectedSession = obj;
		$scope.selectedSession.startDate = new Date($scope.selectedSession.startDate);
		$scope.selectedSession.endDate = new Date($scope.selectedSession.endDate);
	}
	
});
