app.controller('feedbackController', function($scope, feedbackServices) {
	
	$scope.currentPage = 0;
    $scope.pageSize = 5;
    $scope.feedbacks = [];

	$scope.save = function(model) {
		feedbackServices.save(model).then(function(response) {
			$scope.succes = "Feedback added successfully!";
			$scope.feedback = {};
			feedbackServices.getAll().then(function(resp) {
				$scope.feedbacks = resp.data;
				$scope.totalItems = $scope.feedbacks.length;
				$scope.numberOfPages=function(){
			        return Math.ceil($scope.feedbacks.length/$scope.pageSize);                
			    }
			}, function(err) {
				console.log(err.resp);
			});
		}, function(err) {
			console.log(err.response);
		});
	};

	$scope.update = function(id, model) {
		feedbackServices.update(id, model).then(function(response) {
			$scope.succes = "Feedback updated successfully!";
			feedbackServices.getAll().then(function(resp) {
				$scope.feedbacks = resp.data;
				$scope.totalItems = $scope.feedbacks.length;
				$scope.numberOfPages=function(){
			        return Math.ceil($scope.feedbacks.length/$scope.pageSize);                
			    }
			}, function(err) {
				console.log(err.resp);
			});
		}, function(err) {
			console.log(err.response);
		});
	};

	$scope.remove = function(id) {
		feedbackServices.remove(id).then(function(response) {
			$scope.succes = "Feedback deleted successfully!";
			feedbackServices.getAll().then(function(resp) {
				$scope.feedbacks = resp.data;
				$scope.totalItems = $scope.feedbacks.length;
				$scope.numberOfPages=function(){
			        return Math.ceil($scope.feedbacks.length/$scope.pageSize);                
			    }
			}, function(err) {
				console.log(err.resp);
			});
		}, function(err) {
			console.log(err.response);
		});
	};

	$scope.getAll = function() {
		feedbackServices.getAll().then(function(response) {
			$scope.feedbacks = response.data;
			$scope.totalItems = $scope.feedbacks.length;
			$scope.numberOfPages=function(){
		        return Math.ceil($scope.feedbacks.length/$scope.pageSize);                
		    }
		}, function(err) {
			console.log(err.response);
		});
	};

	$scope.setModal = function(obj) {
		$scope.selectedFeedback = obj;
	}
	
});