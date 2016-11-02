'use strict';

angular.module('myApp.view4', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view4', {
    templateUrl: 'view4/view4.html',
    controller: 'View4Ctrl'
  });
}])

.controller('View4Ctrl', ['$scope','Get',function($scope,Get) {
        $scope.direccion="";
        $scope.telefono="";
        $scope.descripcion="";
                $scope.listado;
      Get.get(function(data){ 
                $scope.listado = data; 
            }); 
       
      $scope.traerTiendas = function () {
                    var e = document.getElementById("select");
                    var nombreTienda = e.options[e.selectedIndex].value;
                    for(var una in $scope.listado){
                        if(nombreTienda == $scope.listado[una].nombre){
                            $scope.direccion=$scope.listado[una].direccion;
                            $scope.telefono=$scope.listado[una].telefono;
                            $scope.descripcion=$scope.listado[una].descripcion;
                        }
                       
                    }
                    
                };  

}]);
