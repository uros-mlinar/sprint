var sprintApp = angular.module("sprintApp", ["ngRoute"]);

sprintApp.controller("ZadaciCtrl", function($scope, $http, $route, $location){
    var url = "api/zadaci";
    var urlStanja = "api/stanja";
    var urlSprintovi = "api/sprintovi";

    $scope.zadaci = [];
    $scope.stanja = [];
    $scope.sprintovi = [];

    $scope.search = {};
    $scope.search.imeZadatka = "";
    $scope.search.sprintID = "";

    $scope.zadatak = {};
    $scope.zadatak.ime = "";
    $scope.zadatak.stanjeID = "";

    $scope.zadatakZaPromenu = {};
    $scope.zadatakZaPromenu.ime = "";
    $scope.zadatakZaPromenu.stanjeID = "";

    $scope.pageNum = 0;
    $scope.totalPages = 1;
    
	$scope.changePage = function(direction){
		$scope.pageNum += direction;
		getZadaci();
    }
    
    $scope.delete = function(id) {
        var promise = $http.delete(url + "/" + id);
        promise.then(
            function success(){
				$route.reload();
            },
            function error(){
                alert("Zadatak nije obrisan.");
            }
        );
    }

    $scope.doAdd = function(){
        var promise = $http.post(url, $scope.zadatak);
        promise.then(
            function success(){
				$route.reload();
            },
            function error(){
                alert("Zadatak nije dodat.");
            }
        );
    }

    $scope.goToEdit = function(id){
        $location.path("/zadaci/edit/" + id);
    }

    var getZadaci = function(){
        var config = {params: {}};

        //ifovi za search
        if($scope.search.imeZadatka != ""){
            config.params.imeZadatka = $scope.search.imeZadatka;
        }
        if($scope.search.sprintID != ""){
            config.params.sprintID = $scope.search.sprintID;
        }

        config.params.pageNum = $scope.pageNum;

        var promise = $http.get(url, config);
        promise.then(
            function success(res){
                $scope.zadaci = res.data;
                $scope.totalPages = res.headers("totalPages");
            },
            function error(){
                alert("Nisu pronadjeni zadaci.");
            }
        );
    }

    getZadaci();

    var getStanja = function(){
        var promise = $http.get(urlStanja);
        promise.then(
            function success(res){
                $scope.stanja = res.data;
            },
            function error(){
                alert("Nisu pronadjena stanja.");
            }
        );
    }

    getStanja();

    var getSprintovi = function(){
        var promise = $http.get(urlSprintovi);
        promise.then(
            function success(res){
                $scope.sprintovi = res.data;
            },
            function error(){
                alert("Nisu pronadjen sprintovi.");
            }
        );
    }

    getSprintovi();

    $scope.doSearch = function(){
        $scope.pageNum = 0;
        getZadaci();
    }

    $scope.getZadatakZaIzmenu = function(id){

        var promise = $http.get(url + "/" + id);
        promise.then(
            function success(res){
                $scope.zadatakZaPromenu = res.data;
                console.log($scope.zadatakZaPromenu);
                izmeniStanje(id);
            },
            function error(){
                alert("Zadatak nije pronadjen.");
            }
        );
    }

    var izmeniStanje = function(zadatakID){

        $scope.zadatakZaPromenu.stanjeID = $scope.zadatakZaPromenu.stanjeID + 1;
        console.log($scope.zadatakZaPromenu);

        var promise = $http.put(url + "/" + zadatakID, $scope.zadatakZaPromenu);
        promise.then(
            function success(){
                alert("promenjen zadatak " + zadatakID);
                getZadaci();
            },
            function error(){
                alert("Nije promenjen zadatak " + zadatakID);
            }
        );
    }

});

sprintApp.controller("EditZadatakCtrl", function($scope, $http, $routeParams, $location){
    var url = "api/zadaci/" + $routeParams.id;
    var urlStanja = "api/stanja";
    var urlSprintovi = "api/sprintovi";

    $scope.zadatak = {};
    $scope.zadatak.ime = "";
    $scope.zadatak.zaduzeni = "";
    $scope.zadatak.bodovi = "";


    var getZadatak = function(){
        var promise = $http.get(url);
        promise.then(
            function success(res){
                $scope.zadatak = res.data;
            },
            function error(){
                alert("Zadatak nije pronadjen.");
            }
        );
    }

    getZadatak();

    var getStanja = function(){
        var promise = $http.get(urlStanja);
        promise.then(
            function success(res){
                $scope.stanja = res.data;
            },
            function error(){
                alert("Nisu pronadjena stanja.");
            }
        );
    }

    getStanja();

    var getSprintovi = function(){
        var promise = $http.get(urlSprintovi);
        promise.then(
            function success(res){
                $scope.sprintovi = res.data;
            },
            function error(){
                alert("Nisu pronadjen sprintovi.");
            }
        );
    }

    getSprintovi();

    $scope.doEdit = function(){
        $http.put(url, $scope.zadatak).then(
			function success(){
                console.log($scope.zadatak);
				$location.path("/zadaci");
			},
			function error(){
				alert("Something went wrong.");
			}
		);
    }
});

sprintApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/zadaci.html'
        })
        .when('/zadaci', {
			templateUrl : '/app/html/zadaci.html'
        })
        .when('/zadaci/edit/:id', {
			templateUrl : '/app/html/edit-zadatak.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);