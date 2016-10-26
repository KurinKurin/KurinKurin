'use strict';

angular.module('myApp.agendar', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/agendar', {
                    templateUrl: 'agendar/agendar.html',
                    controller: 'agendarCtrl'
                });
            }])

        .controller('agendarCtrl', ['$scope', '$rootScope', 'Get', 'GetServices', 'PostCita', '$mdDialog', function ($scope, $rootScope, Get, GetServices, PostCita, $mdDialog) {
                $scope.usuario;

                $scope.listadoTiendas;
                Get.get(function (data) {
                    $scope.listadoTiendas = data;
                });
/**
                $scope.listadoServicios;
                GetServices.get(function (data) {
                    $scope.listadoServicios = data;
                });

                $scope.horarios;
                GetHorarioService.get(function (data) {
                    $scope.servicios = data;
                });
**/

                $scope.agendar = function () {
                    var newitem = {"name": $scope.name, "lastName": $scope.lastName, "user": $scope.user, "password": $scope.password, "email": $scope.email, "address": $scope.address, "phone": $scope.phone};
                    PostUser.save(newitem, function () {
                        console.info("Saved " + newitem.name);
                    });

                }
                ;
            }]);
