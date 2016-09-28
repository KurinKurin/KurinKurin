'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'View1Ctrl'
  });
}])

.controller('View1Ctrl','Get','$scope','GetServicios', [function(Get, $scope,GetServicios) {
        $scope.listado;
      Get.get(function(data){ 
                $scope.listado = data; 
            }); 
            
            
       $scope.getServicios = function () {
                var e = document.getElementById("select");
                var nombre_tienda = e.options[e.selectedIndex].value;
		GetServicios.get(nombre_tienda,function(data){ 
                $scope.servicios = data; 
            });
                    };
 
}]);