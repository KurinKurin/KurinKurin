'use strict';
angular.module('myApp.services', ['ngRoute', 'ngResource'])

        /*.factory('fabrica', function () {
         var data = {
         listado: []
         };
         return {
         getListado: function () {
         return data.listado;
         },
         addTodo: function (todo) {
         data.listado.push(todo);
         }};
         });*/
        .factory('Post', function ($resource) {
            return $resource('/tiendas');
        })

        .factory('PostServicio', function ($resource) {
            console.info("Entro en la PostServicio");
            return $resource('/servicios/:nombreTienda/servicio', {nombreTienda: "@nombreTienda"});

        })

        .factory('PostCita', function ($resource) {
            console.info("Entro en la PostCita");
            return $resource('/citas');

        })

        .factory('GetCitas', function ($resource) {
            console.info("GetCitas-------------------------------------------------------------------");
            return $resource('/citas/:nombreTienda', {nombreTienda: "@nombreTienda"},
                    {get: {method: 'GET', isArray: true}});
        })

        .factory('GetServices', function ($resource) {
            console.info("GetServicesTienda-------------------------------------------------------------------");
            return $resource('/servicios/:nombreTienda', {nombreTienda: "@nombreTienda"},
                    {get: {method: 'GET', isArray: true}});
        })
        .factory('GetServicesId', function ($resource) {
            console.info("GetServicesTiendaId-------------------------------------------------------------------");
            return $resource('/servicios/id/:idTienda', {idTienda: "@idTienda"},
                    {get: {method: 'GET', isArray: true}});
        })

        .factory('GetCitasTienda', function ($resource) {
            console.info("GetCitasTienda-------------------------------------------------------------------");
            return $resource('/citas/:idTienda', {idTienda: "@idTienda"},
                    {get: {method: 'GET', isArray: true}});
        })
        
        .factory('GetCitasTiendaServicios', function ($resource) {
            console.info("GetCitasTienda-------------------------------------------------------------------");
            return $resource('/citas/:idTienda/servicios', {idTienda: "@idTienda"},
                    {get: {method: 'GET', isArray: true}});
        })
        
        .factory('Delete', function ($resource) {
            console.info("Entro en la factory");
            return $resource('/tiendas/:id', {id: '@id'},
                    {delete: {method: 'DELETE'}});
        })

        .factory('Get', function ($resource) {
            return $resource('/tiendas', {},
                    {get: {method: 'GET', isArray: true}});
        })

        .factory('GetUser', function ($resource) {
            return $resource('/users', {},
                    {get: {method: 'GET', isArray: true}});
        })

        .factory('PostUser', function ($resource) {
            return $resource('/users');
        })


        ;


