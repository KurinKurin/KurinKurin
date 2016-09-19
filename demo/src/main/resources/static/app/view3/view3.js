'use strict';

angular.module('myApp.view3', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view3', {
    templateUrl: 'view3/view3.html',
    controller: 'View3Ctrl'
  });
}])

.controller('View3Ctrl', ['$scope','Get', 'Delete',function($scope,Get,Delete) {
       
      $scope.agregarServicio = function () {
                    var newitem = {"nombre": $scope.nombre, "direccion": $scope.direccion, "telefono": $scope.telefono, "descripcion": $scope.descripcion};
		
                };  
       $scope.eliminar = function (tienda) {
                    
                    //Delete.removeTienda(tienda,function () {
                        //console.info("Deleted: " + newitem.nombre);
                   // }
                   // );
		
                }; 
       
     Get.get(function(data){ 
                $scope.listado=data; 
            });

}]);
