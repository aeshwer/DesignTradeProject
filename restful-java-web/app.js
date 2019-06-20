var myApp = angular.module('myApp', ['ngResource']);

myApp.controller('mainController', ['$scope','$resource', function($scope,$resource) {
    
    $scope.data = 's';
    
    $scope.getData = function() {
        return $scope.data;
    };
    
}]);
