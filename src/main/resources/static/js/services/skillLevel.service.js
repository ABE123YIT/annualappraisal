app.service('skillLevelServices', function($http) {
	var that = this;
	that.baseUrl = "/skill_level";

	that.getAll = function() {
		return $http.get(that.baseUrl + "/");
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
		console.log("levelService");
		console.log(model);
		return $http.post(that.baseUrl + "/save", model);
	};
});