function MemberController2($scope, $http, $window) {
	var host = $window.location.host;
	var protocol = $window.location.protocol;
	var urlpath = protocol + '//' + host + '/socialbook/service/member/'; 
    $http.get(urlpath).
        success(function(data) {
        	var listmembers = angular.fromJson(data);
            $scope.member = listmembers[0];
        });
}