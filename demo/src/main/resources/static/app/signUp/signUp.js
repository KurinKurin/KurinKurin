'use strict';

angular.module('myApp.signUp', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/signUp', {
                    templateUrl: 'signUp/signUp.html',
                    controller: 'signUpCtrl'
                });
            }])

        .controller('signUpCtrl', ['$scope', '$rootScope','PostUser', '$mdDialog', function ($scope, $rootScope, PostUser, $mdDialog) {
                $scope.name = "";
                $scope.lastName = "";
                $scope.user = "";
                $scope.password = "";
                $scope.confirmPassword = "";
                $scope.email = "";
                $scope.address = "";
                $scope.phone = "";
                $scope.signUp = function () {
                    if ($scope.password == $scope.confirmPassword) {
                        var newitem = {"name": $scope.name, "lastName": $scope.lastName, "user": $scope.user, "password": $scope.password, "email": $scope.email,"address": $scope.address,"phone": $scope.phone};
                        PostUser.save(newitem, function () {
                            console.info("Saved " + newitem.name);
                        });
                    }
                    else{
                        alert("Las contraseñas no coinciden.");
                    }
                };
            }]);
