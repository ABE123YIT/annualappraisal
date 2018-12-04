app.controller('loginController', function($scope, $rootScope, $localStorage, employeeServices, $state) {
	$localStorage.user = {};
	$rootScope.user = {};
	$scope.login=function(){
		employeeServices.login($scope.userLogin).then(function(response) {
			if(response.data.id== undefined){
				$scope.error="Authentication failed !"
			}else {
				$localStorage.user=response.data;
				$rootScope.user = $localStorage.user;
				console.log($scope);
				if($localStorage.user.isManager==true){
					$state.go("team", {}, {});
				}else{
					$state.go("profil", {}, {});
				}
			}
		}, function(err) {
			console.log(err);
		});
	}
});