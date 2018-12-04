var app = angular.module("appraisalApp", [ 'ngAnimate', 'ui.router', 'ngMaterial', 'ngStorage' ]);

app.config(function($stateProvider, $urlRouterProvider) {
	// chemin par defaut pour vue accueil
	$urlRouterProvider.otherwise('/login');

	$stateProvider.state('login', {
		url : '/login',
		templateUrl : 'views/login.template.html',
		controller : 'loginController'
	});
	// employee
	$stateProvider.state('employeeSave', {
		url : '/employee/save',
		templateUrl : 'views/crud/employee.create.template.html',
		controller : 'employeeCreateController'
	});

	$stateProvider.state('employeeEdit', {
		url : '/employee/edit/:id/:managerId',
		templateUrl : 'views/crud/employee.edit.template.html',
		controller : 'employeeEditController'
	});

	$stateProvider.state('employeeList', {
		url : '/employee/list',
		templateUrl : 'views/crud/employee.list.template.html',
		controller : 'employeeListController'
	});
	
	$stateProvider.state('profil', {
		url : '/employee/profil',
		templateUrl : 'views/crud/employee.profil.template.html',
		controller : 'profilController'
	});
	
	$stateProvider.state('team', {
		url : '/team/manager',
		templateUrl : 'views/crud/manager.team.template.html',
		controller : 'managerTeamController'
	});
	
	$stateProvider.state('myAppraisals', {
		url : '/myAppraisals',
		templateUrl : 'views/appraisal/myappraisals.template.html',
		controller : 'myappraisalsController'
	});

	// feedback
	$stateProvider.state('feedback', {
		url : '/feedback',
		templateUrl : 'views/crud/feedback.template.html',
		controller : 'feedbackController'
	});
	
	// rating
	$stateProvider.state('rating', {
		url : '/rating',
		templateUrl : 'views/crud/rating.template.html',
		controller : 'ratingController'
	});

	// skill
	$stateProvider.state('skill', {
		url : '/skill',
		templateUrl : 'views/crud/skill.template.html',
		controller : 'skillController'
	});

	// annual session
	$stateProvider.state('annualsession', {
		url : '/annualsession',
		templateUrl : 'views/crud/annualsession.template.html',
		controller : 'annualsessionController'
	});

	// appraisal
	$stateProvider.state('appraisalSteps', {
		url : '/appraisal',
		templateUrl : 'views/appraisal/appraisal.steps.template.html',
		controller : 'appraisalStepsController'
	});
	
	$stateProvider.state('stepHome', {
		url : '/appraisal/home',
		templateUrl : 'views/appraisal/step.home.template.html',
		controller : 'stepHomeController'
	});
	
	$stateProvider.state('stepCompetencies', {
		url : '/appraisal/competencies',
		templateUrl : 'views/appraisal/step.competencies.template.html',
		controller : 'stepCompetenciesController'
	});

	$stateProvider.state('stepFeedbacks', {
		url : '/appraisal/feedbacks',
		templateUrl : 'views/appraisal/step.feedbacks.template.html',
		controller : 'stepFeedbacksController'
	});

	$stateProvider.state('stepLastObjectives', {
		url : '/appraisal/lastobjectives',
		templateUrl : 'views/appraisal/step.objective.prev.template.html',
		controller : 'stepLastObjectivesController'
	});

	$stateProvider.state('stepObjectives', {
		url : '/appraisal/objectives',
		templateUrl : 'views/appraisal/step.objectives.template.html',
		controller : 'stepObjectivesController'
	});

	$stateProvider.state('stepSoftSkills', {
		url : '/appraisal/softskills',
		templateUrl : 'views/appraisal/step.skills.soft.template.html',
		controller : 'stepSoftSkillsController'
	});

	$stateProvider.state('stepManagerialSkills', {
		url : '/appraisal/managerialskills',
		templateUrl : 'views/appraisal/step.skills.managerial.template.html',
		controller : 'stepManagerialSkillsController'
	});

	$stateProvider.state('stepSynthesis', {
		url : '/appraisal/synthesis',
		templateUrl : 'views/appraisal/step.skills.synthesis.template.html',
		controller : 'stepSynthesisController'
	});

	$stateProvider.state('stepWish', {
		url : '/appraisal/wish',
		templateUrl : 'views/appraisal/step.wish.template.html',
		controller : 'stepWishController'
	});
	
	$stateProvider.state('navHeader', {
		url : '/navHeader',
		templateUrl : 'views/menu/nav.header.template.html',
		controller : 'navHeaderController'
	});
	
	$stateProvider.state('navSidebar', {
		url : '/navSidebar',
		templateUrl : 'views/menu/nav.sidebar.template.html',
		controller : 'navSidebarController'
	});
	
});
