app.service('appraisalServices', function($http) {
	var that = this;
	that.baseUrl = "/annual_appraisal";

	that.getAll = function() {
		return $http.get(that.baseUrl + "/");
	};

	that.get = function(id) {
		return $http.get(that.baseUrl + "/" + id);
	};
	
	that.getByEmployeeAndSession = function(employee_id, session_id) {
		return $http.get(that.baseUrl + "/by/" + employee_id + "/" + session_id);
	};
	
	that.getAppraisalsHistory = function(employee_id, date) {
		return $http.get(that.baseUrl + "/history/" + employee_id + "/" + date);
	};
	
	that.getEmployeeAppraisals = function(employee_id) {
		return $http.get(that.baseUrl + "/employee/" + employee_id);
	};

	that.update = function(id, model) {
		return $http.put(that.baseUrl + "/" + id, model);
	};

	that.remove = function(id) {
		return $http.delete(that.baseUrl + "/" + id);
	};

	that.save = function(model) {
		return $http.post(that.baseUrl + "/save", model);
	};
	
});