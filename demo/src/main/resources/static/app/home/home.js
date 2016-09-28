'use strict';

angular.module('myApp.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'home/home.html',
    controller: 'home1Ctrl'
  });
}])

.controller('home1Ctrl', [function() {
         
}]);

