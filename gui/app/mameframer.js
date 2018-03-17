angular.module("mameframer", ["ngRoute", "allpartials"])
    .factory('api', function ($http) {
        return {
            upload: function (file, callback) {
                var fd = new FormData();
                fd.append("source", file);
                $http.post("http://localhost:3000/programs", fd, {
                    transformRequest: angular.identity,
                    headers: { 'Content-Type': undefined }
                })
                    .then(function (response) {
                        callback(response);
                    }, function (err) {
                        callback(err);
                    });
            }
        };
    })
    .directive("code", function () {
        return {
            scope: {
                source: "<",
                title: "@",
                resource: "@",
                pkg: "@"
            },
            templateUrl: "partials/code.html"
        }
    })
    .directive("uploadHandler", ["api", "$sce", function (api, sce) {
        return {
            restrict: "A",
            link: function (scope, element, attr) {
                element.bind("change", function () {
                    var file = element[0].files[0];
                    api.upload(file, (r) => {
                        console.log(r);
                        scope.waiting = true;
                        scope.file = { resource: r.data.resource, source: sce.trustAsHtml(r.data.highlighted), name: r.data.name, id: r.data.id };
                    });
                })
            },
            controller: ["$scope", "$interval", "$http","$sce", function ($scope, $interval, $http, sce) {
                $scope.file = false;
                function poll() {
                    if ($scope.transpiled) {
                        $interval.cancel(poll);
                    } else {
                        $http.get($scope.file.resource)
                            .then(function(result){
                                console.log(result);
                                $scope.waiting = false;
                                if(result.data){
                                    result.data.dataClasses = result.data.dataClasses.map(function(dc){
                                        dc.dataHtml = sce.trustAsHtml(dc.dataHtml);
                                        return dc;
                                    });
                                    result.data.programClasses = result.data.programClasses.map(function(dc){
                                        dc.dataHtml = sce.trustAsHtml(dc.dataHtml);
                                        return dc;
                                    });
                                    $scope.transpiled = result.data;

                                }
                            }, function(err){
                                console.log(err);
                                $scope.waiting = true;
                            })
                    }
                }
                $scope.$watch("file", function (d) {
                    if($scope.file && $scope.file.resource){
                        $interval(poll, 1000);
                    }                    
                });
            }]
        };
    }])
    .directive("uploadForm", function () {
        return {
            restrict: "E",
            templateUrl: "partials/uploader.html"
        }
    })
    .controller("mainCtrl", ["$scope", function ($scope) {
        $scope.msg = "Fuck me I am famous!";
    }])
    .config(function ($routeProvider, $locationProvider) {
        $routeProvider
            .when("/", {
                templateUrl: "partials/home.html",

            });
    });