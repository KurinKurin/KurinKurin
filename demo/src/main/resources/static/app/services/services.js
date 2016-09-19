'use strict';
angular.module('myApp.services', ['ngRoute','ngResource'])

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
        
        .factory('Delete', function ($resource) {
            return $resource('/tiendas');
        })
    
     .factory('Get', function ($resource) {
            return $resource('/tiendas',{},
                    {get: {method: 'GET', isArray: true}});
        });
