'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'View1Ctrl'
  });
}])

.controller('View1Ctrl',['Get','$scope','GetServices', function(Get, $scope,GetServices) {
       $scope.listado;
         
                
                var nombre_tienda;
                
        
        Get.get(function(data){ 
                $scope.listado = data; 
            }); 
      
            
       $scope.getServicios = function () {
            $scope.servicios;
            $scope.servis = [];    
            $scope.nombre="";
            $scope.precio="";
            $scope.descripcion="";
            $scope.tamano="";
           
            
            var e = document.getElementById("select");
                nombre_tienda = e.options[e.selectedIndex].value;
                 GetServices.get(nombre_tienda,function(data){ 
                    $scope.servicios = data; 
                });
            
                for(var una in $scope.listado){
                    if(nombre_tienda === $scope.listado[una].nombre){
                        for(var ser in $scope.servicios){
                            if($scope.listado[una].id.id === $scope.servicios[ser].servs){
                                $scope.servis.push($scope.servicios[ser]);
                            }
                        }                       
                    }          
            }
            
            
       };
 
}]);