// Note how to enable CORS in apache tomcat : https://www.youtube.com/watch?v=2Js3iZXt964
// add filter mappping in web.xml   ,, link : https://tomcat.apache.org/tomcat-7.0-doc/config/filter.html#CORS_Filter

var myApp = angular.module('myApp', ['ngResource']);

myApp.controller('mainController', ['$scope','$resource','$http','$timeout',function($scope,$resource,$http,$timeout) {
    
   $scope.data = 'Dummy';
                                    
    $scope.getData = function() { 
                                    
     $scope.data = $http.get('http://localhost:9090/restful-java/score')
        .success(function (result) {
            $scope.data = result;              

        })
        .error(function (data, status) {

        });
        return $scope.data; 
        
    };
    
    $timeout($scope.getData,3000);  

    
    /*We can also get data this way
    $scope.weatherAPI = $resource("http://localhost:9090/restful-java/score");    
    $scope.data = $scope.weatherAPI.get();*/
          
    
}]);
