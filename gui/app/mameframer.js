angular.module("mameframer",["ngRoute","allpartials"])
.controller("mainCtrl",["$scope", function($scope){
    $scope.msg = "Fuck me I am famous!";
}])
.config(function($routeProvider, $locationProvider) {

    $routeProvider
        .when("/", {
            templateUrl : "partials/home.html",
            controller : "mainCtrl"
        });

    // use the HTML5 History API
    $locationProvider.html5Mode(true);
});