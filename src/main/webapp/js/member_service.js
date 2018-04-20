 
App.factory('MemberService', ['$http', '$q', '$window', function($http, $q, $window){
	var host = $window.location.host;
	var protocol = $window.location.protocol;
	var urlpath = protocol + '//' + host + '/socialbook/service/member/'; 
 
    return {
         
    		findAllMembers: function() {
                    return $http.get(urlpath)
                            .then(
                                    function(response){
                                    	console.log('MemberService.findAllMembers: ');
                                    	console.log(response.data);
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching members');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            createMember: function(member){
                    return $http.post(urlpath, member)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating member');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateMember: function(member, email){
                    return $http.put(urlpath + email, member)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating member');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteMember: function(email){
                    return $http.delete(urlpath + email)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting member');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
 
}]);