app.service('skillEvaluationServices', function($http) {
	var that = this;
	that.baseUrl = "/skill_evaluation";

	that.getAll = function() {
		return $http.get(that.baseUrl + "/");
	};

	that.get = function(id) {
		return $http.get(that.baseUrl + "/" + id);
	};
	
	that.getByAppraisalAndType = function(id, type) {
		return $http.get(that.baseUrl + "/appraisal/" + id + "/" + type);
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
	
	that.saveAll = function(models, id, type) {
		return $http.post(that.baseUrl + "/saveAll/" + id + "/" + type, models);
	};
});