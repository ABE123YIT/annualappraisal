app.service('competencieServices', function($http) {
	var that = this;
	that.baseUrl = "/competencie";

	that.getAll = function() {
		return $http.get(that.baseUrl + "/");
	};
	
	that.getByAppraisal = function(appraisal_id) {
		return $http.get(that.baseUrl + "/appraisal/" + appraisal_id);
	};

	that.get = function(id) {
		return $http.get(that.baseUrl + "/" + id);
	};

	that.update = function(id, model) {
		return $http.put(that.baseUrl + "/" + id, model);
	};
	
	that.updateList = function(models) {
		return $http.put(that.baseUrl + "/update", models);
	};

	that.remove = function(id) {
		return $http.get(that.baseUrl + "/delete/" + id);
	};

	that.save = function(model) {
		return $http.post(that.baseUrl + "/save", model);
	};
	
});