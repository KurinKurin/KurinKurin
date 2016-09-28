'use strict';

angular.module('myApp.view2', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view2', {
                    templateUrl: 'view2/view2.html',
                    controller: 'View2Ctrl'
                });
            }])


        .controller('View2Ctrl', ['$scope', 'Post', '$mdDialog', function ($scope, Post, $mdDialog) {
                $scope.nombre = "";
                $scope.direccion = "";
                $scope.telefono = 5;
                $scope.descripcion = "";

                $scope.aceptar = function () {
                    var newitem = {"nombre": $scope.nombre, "direccion": $scope.direccion, "telefono": $scope.telefono, "descripcion": $scope.descripcion};
                    Post.save(newitem, function () {
                        console.info("Saved " + newitem.nombre);
                    }
                    );
                };
            }]);
