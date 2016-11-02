'use strict';

angular.module('myApp.view1', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view1', {
                    templateUrl: 'view1/view1.html',
                    controller: 'View1Ctrl'
                });
            }])

        .controller('View1Ctrl', ['Get', '$scope', 'GetServices', function (Get, $scope, GetServices) {
                $scope.listado;
                $scope.tienda;

                Get.get(function (data) {
                    $scope.listado = data;
                });


                $scope.getServicios = function () {
                    $scope.servis;
                    $scope.nombre = "";
                    $scope.precio = "";
                    $scope.descripcion = "";
                    $scope.tamano = "";


                    GetServices.get({nombreTienda: $scope.tienda}, function (data) {
                        $scope.servis = data;
                    });

                    };

            }]);