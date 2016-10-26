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
                    var e = document.getElementById("select");
                    var nombreTienda = e.options[e.selectedIndex].value;
               
                    var newitem = {"user": $scope.usuario, "idServicio": 1};
                    console.info("newitem: "+newitem.user);
                    PostCita.save(newitem,{nombreTienda : nombreTienda});
                        console.info("Cita agregada :" + JSON.stringify(newitem));
                  
                };
                }]);
