app.controller('ratingController', function($scope, ratingServices) {
	
    $scope.ratings = [];

	$scope.save = function(model) {
		ratingServices.save(model).then(function(response) {
			$scope.succes = "Rating added successfully!";
			$scope.rating = {};
			ratingServices.getAll().then(function(resp) {
				$scope.ratings = resp.data;
			}, function(err) {
				console.log(err.resp);
			});
		}, function(err) {
			console.log(err.response);
		});
	};

	$scope.update = function(id, model) {
		ratingServices.update(id, model).then(function(response) {
			$scope.succes = "Rating updated successfully!";
			ratingServices.getAll().then(function(resp) {
				$scope.ratings = resp.data;
			}, function(err) {
				console.log(err.resp);
			});
		}, function(err) {
			console.log(err.response);
		});
	};

	$scope.remove = function(id) {
		ratingServices.remove(id).then(function(response) {
			$scope.succes = "Rating deleted successfully!";
			ratingServices.getAll().then(function(resp) {
				$scope.ratings = resp.data;
			}, function(err) {
				console.log(err.resp);
			});
		}, function(err) {
			console.log(err.response);
		});
	};

	$scope.getAll = function() {
		ratingServices.getAll().then(function(response) {
			$scope.ratings = response.data;
		}, function(err) {
			console.log(err.response);
		});
	};

	$scope.setModal = function(obj) {
		$scope.selectedRating = obj;
	}
	
});


app.directive('ngConfirmClick', [
    function(){
        return {
            link: function (scope, element, attr) {
                var msg = attr.ngConfirmClick || "Are you sure?";
                var clickAction = attr.confirmedClick;
                element.bind('click',function (event) {
                    if ( window.confirm(msg) ) {
                        scope.$eval(clickAction)
                    }
                });
            }
        };
}])