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
         $scope.servicios;
                $scope.nombre="";
                $scope.precio="";
                $scope.descripcion="";
                $scope.tamano="";
                var nombre_tienda;
                $scope.servis;
        
        Get.get(function(data){ 
                $scope.listado = data; 
                console.info(JSON.stringify($scope.listado));   
            }); 
      
            
       $scope.getServicios = function () {
                
           
           
            
            console.info("Entro en el getServicios()");
            var e = document.getElementById("select");
                nombre_tienda = e.options[e.selectedIndex].value;
                 GetServices.get(nombre_tienda,function(data){ 
                    $scope.servicios = data; 
                    console.info(JSON.stringify($scope.servicios));   
       });
            
                for(var una in $scope.listado){
                    
                    if(nombre_tienda === $scope.listado[una].nombre){
                        for(var ser in $scope.servicios){
                       
                            if($scope.listado[una].id.id === $scope.servicios[ser].tiendas_id){
                                $scope.servis.push($scope.servicios[ser]);
                                console.info($scope.servicios[ser].nombre);
                            }
                        }                       
                    }          
            }
            
            
       };
 
}]);