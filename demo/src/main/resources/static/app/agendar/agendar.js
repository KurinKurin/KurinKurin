'use strict';

angular.module('myApp.agendar', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/agendar', {
                    templateUrl: 'agendar/agendar.html',
                    controller: 'agendarCtrl'
                });
            }])

        .controller('agendarCtrl', ['$scope', '$rootScope', 'Get', 'GetServicesId', 'GetCitasTienda','GetCitasTiendaServicios','PostCita', '$mdDialog', function ($scope, $rootScope, Get, GetServicesId, GetCitasTienda, GetCitasTiendaServicios, PostCita, $mdDialog) {
                $scope.usuario;
                $scope.tienda;
                $scope.servicio;
                $scope.cita;
                $scope.citas;
                $scope.listadoServicios;
                $scope.listadoTiendas;
                
                Get.get(function (data) {
                    $scope.listadoTiendas = data;
                });

                $scope.getServicios = function () {
                    console.info("nombretienda en ajendar.js"+$scope.tienda);
                    GetServicesId.get({idTienda: $scope.tienda}, function (data) {
                        $scope.listadoServicios = data;
     
                        console.info(data);
                    });
                };
                
                $scope.getHoraCitas = function (){
                    GetCitasTienda.get({idTienda: $scope.tienda}, function (data) {
                        $scope.citas = data;     
                        console.info(data);
                    });
                }
                
                $scope.agendar = function () {                    
                    var newitem = {"user": $scope.usuario, "idServicio": $scope.servicio, "tienda_id":$scope.tienda, "disponible": "1", "fecha":$scope.cita, "hora":$scope.cita};
                    console.info("newitem: " + newitem.user);
                    PostCita.save(newitem);
                    console.info("Cita agregada :" + JSON.stringify(newitem));

                };
            }]);
