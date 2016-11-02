'use strict';

angular.module('myApp.view3', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view3', {
    templateUrl: 'view3/view3.html',
    controller: 'View3Ctrl'
  });
}])

.controller('View3Ctrl', ['$scope','Get','PostServicio', 'Delete',function($scope,Get,PostServicio,Delete) {
     $scope.nombreServicio="Baño";
     $scope.precioServicio=25000;
     $scope.descripcionServicio="Limpio";
     $scope.tamanoServicio="grande";
                
                $scope.listado;
      Get.get(function(data){ 
                $scope.listado = data; 
            }); 
       
      $scope.agregarServicio = function () {
                    var e = document.getElementById("select");
                    var nombreTienda = e.options[e.selectedIndex].value;
               
                    var newitem = {"nombre": $scope.nombreServicio, "precio": $scope.precioServicio, "descripcion": $scope.descripcionServicio, "tamano": $scope.tamanoServicio};
                    console.info("newitem: "+newitem.nombre);
                    PostServicio.save(newitem,{nombreTienda : nombreTienda});
                        console.info("Servicio agregado :" + JSON.stringify(newitem
                   ));
                };  
       $scope.eliminar = function (tienda) {
                     
                 $scope.index = $scope.listado.indexOf(tienda);
                 $scope.listado.splice( $scope.index, 1); 
                 Delete.delete({id: $scope.index});
                        console.info("Deleted "+ "  "+ $scope.index);
                  
                };  
}]);
