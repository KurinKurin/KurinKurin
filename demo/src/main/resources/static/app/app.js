'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngResource',
  'ngMaterial',
  'myApp.home',
  'myApp.view1',
  'myApp.view2',
  'myApp.view3',
  'myApp.view4',
  'myApp.agendar',
  'myApp.login',
  'myApp.signUp',  
  'myApp.services',
  'myApp.version'
])

.config(['$locationProvider', '$routeProvider','$httpProvider', function($locationProvider, $routeProvider, $httpProvider) {
  $locationProvider.hashPrefix('!');
  $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
  $routeProvider.otherwise({redirectTo: '/home'});
}])

.controller('logout', ['$scope','$rootScope', '$http','$location', function( $scope, $rootScope, $http, $location){ 
   $scope.logout = function () {
                    $http.post('/logout', {}).success(function () {
                        $rootScope.authenticated = false;
                        $location.path("/");
                    }).error(function (data) {
                        $rootScope.authenticated = false;
                    });
                }; 
 }]);
