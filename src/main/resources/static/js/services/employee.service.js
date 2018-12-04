app.service('employeeServices', function($http) {
	var that = this;
	that.baseUrl = "/employee";

	that.getAll = function() {
		return $http.get(that.baseUrl + "/");
	};

	that.getTeam = function(managerId) {
		return $http.get(that.baseUrl + "/team/" + managerId);
	};

	that.getManagers = function() {
		return $http.get(that.baseUrl + "/managers");
	};

	that.get = function(id) {
		return $http.get(that.baseUrl + "/" + id);
	};

	that.update = function(id, model) {
		return $http.put(that.baseUrl + "/" + id, model);
	};

	that.remove = function(id) {
		return $http.get(that.baseUrl + "/delete/" + id);
	};

	that.save = function(model) {
		return $http.post(that.baseUrl + "/save", model);
	};

	that.login = function(login) {
		return $http.get(that.baseUrl + "/login/" + login);
	};
});