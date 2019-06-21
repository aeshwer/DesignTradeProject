// Note how to enable CORS in apache tomcat : https://www.youtube.com/watch?v=2Js3iZXt964
// add filter mappping in web.xml   ,, link : https://tomcat.apache.org/tomcat-7.0-doc/config/filter.html#CORS_Filter

var myApp = angular.module('myApp', ['ngResource']);

myApp.controller('mainController', ['$scope','$resource','$http','$timeout',function($scope,$resource,$http,$timeout) {
    
   $scope.data = 'Dummy';
                                  
    //GET CALL
    $scope.getData = function() {             
     $scope.data = $http.get('http://localhost:9090/restful-java/score')
        .success(function (result) {
            $scope.data = result;              

        })
        .error(function (data, status) {

        });
        return $scope.data; 
        
    };
        
    //PUT CALL
    $scope.putData = function() {         
        
      $http.put('http://localhost:9090/restful-java/score?wins=11&loss=22&ties=33')
        .success(function (result) {
            $scope.data = result;              

        })
        .error(function (data, status) {

        }); 
        
        
    };
    
    //PUT CALL
    $scope.putData2 = function() {         
        
      $http.put('http://localhost:9090/restful-java/score/wins')
        .success(function (result) {
            $scope.data = result;              

        })
        .error(function (data, status) {

        }); 
        
        
    };
    
    //Try to send JSON data from client
    //PUT CALL
    $scope.putJsonDummyData = function() {         
        
        var obj = { name: "John", age: 30, city: "New York" };
        
      $http.put('http://localhost:9090/restful-java/score/jsonData',obj)
        .success(function (result) {
            console.log(result);              

        })
        .error(function (data, status) {
          console.log(result);              
        }); 
        
        
    };
    
    
    $timeout($scope.getData,3000);  
    //$timeout($scope.putData,2000);  
    //$timeout($scope.getData,1000);  
    //$timeout($scope.putData2,2000);  
    //$timeout($scope.getData,1000); 
    
    $timeout($scope.putJsonDummyData,2000); 
    $timeout($scope.getData,1000); 
    
    
    
    
    
    /*We can also get data this way
    $scope.weatherAPI = $resource("http://localhost:9090/restful-java/score");    
    $scope.data = $scope.weatherAPI.get();*/
          
    
}]);

    