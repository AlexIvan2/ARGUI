'use strict';

var App = angular.module('myApp',['ui.router', 'ngTable']);

App.config(['$stateProvider', '$urlRouterProvider', '$qProvider', function($stateProvider, $urlRouterProvider, $qProvider){

    $urlRouterProvider.otherwise("/subscribersViewForm");

    $stateProvider
        .state('subscribersViewForm', {
            url: "/subscribersViewForm",
            templateUrl: "subscribersViewForm.jsp"
        })
        .state('transactionsViewForm', {
            url: "/transactionsViewForm",
            templateUrl: "transactionsViewForm.jsp"
        });

    $qProvider.errorOnUnhandledRejections(false);

}]);
