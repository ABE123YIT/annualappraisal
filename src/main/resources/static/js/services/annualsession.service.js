app.service('annualsessionServices', function($http) {
	var that = this;
	that.baseUrl = "/annual_session";

	that.getAll = function() {
		return $http.get(that.baseUrl + "/");
	};

	that.get = function(id) {
		return $http.get(that.baseUrl + "/" + id);
	};
	
	that.getByLabel = function(label) {
		return $http.get(that.baseUrl + "/label/" + label);
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
});