'use strict';

angular.module('myApp.agendar', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/agendar', {
                    templateUrl: 'agendar/agendar.html',
                    controller: 'agendarCtrl'
                });
            }])

        .controller('agendarCtrl', ['$scope', '$rootScope', 'Get', 'GetServices', 'GetHorarioService', '$mdDialog', function ($scope, $rootScope, Get, GetServices, GetHorarioService, $mdDialog) {
                $scope.tiendas;
                Get.get(function (data) {
                    $scope.tiendas = data;
                });

                $scope.servicios=GetServices.get({nombreTienda: $scope.tiendaEscogida});
                                
                $scope.horarios;
                GetHorarioService.get(function (data) {
                    $scope.servicios = data;
                });

                $scope.tiendaEscogida = "";
                $scope.servicioEscogido = "";
                $scope.fecha = "";
                $scope.horaEscogida = "";
                $scope.agendar = function () {
                    var newitem = {"name": $scope.name, "lastName": $scope.lastName, "user": $scope.user, "password": $scope.password, "email": $scope.email, "address": $scope.address, "phone": $scope.phone};
                    PostUser.save(newitem, function () {
                        console.info("Saved " + newitem.name);
                    });
                           
                }
                ;
            }]);
