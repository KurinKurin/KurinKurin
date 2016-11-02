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
                $scope.tienda;
                $scope.servicio;
                $scope.listadoServicios;
                $scope.listadoTiendas;
                
                Get.get(function (data) {
                    $scope.listadoTiendas = data;
                });

                $scope.getServicios = function () {
                    console.info("nombretienda en ajendar.js"+$scope.tienda);
                    GetServices.get({nombreTienda: $scope.tienda}, function (data) {
                        $scope.listadoServicios = data;
                        console.info(data);
                    });
                };
                
                /**
                 $scope.horarios;
                 GetHorarioService.get(function (data) {
                 $scope.servicios = data;
                 });
                 **/

                $scope.agendar = function () {                    
                    var newitem = {"user": $scope.usuario, "idServicio": $scope.servicio};
                    console.info("newitem: " + newitem.user);
                    PostCita.save(newitem);
                    console.info("Cita agregada :" + JSON.stringify(newitem));

                };
            }]);
