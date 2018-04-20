
App.controller('MemberController', ['$scope', 'MemberService', function($scope, MemberService) {
          $scope.member={email:null,name:''};
          $scope.members=[];
          $scope.hola = 'Hola mundo';
               
          $scope.findAllMembers = function(){
              MemberService.findAllMembers()
                  .then(
                               function(d) {
                                    $scope.members = d;
                                    console.log('MemberController.findAllMembers: ');
                                	console.log(d);
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
            
          $scope.createMember = function(member){
              MemberService.createMember(member)
                      .then(
                      $scope.findAllMembers, 
                              function(errResponse){
                                   console.error('Error while creating Member.');
                              } 
                  );
          };
 
         $scope.updateMember = function(member, email){
              MemberService.updateMember(member, email)
                      .then(
                              $scope.findAllMembers, 
                              function(errResponse){
                                   console.error('Error while updating Member.');
                              } 
                  );
          };
 
         $scope.deleteMember = function(email){
              MemberService.deleteMember(email)
                      .then(
                              $scope.findAllMembers, 
                              function(errResponse){
                                   console.error('Error while deleting Member.');
                              } 
                  );
          };
 
          $scope.findAllMembers();
 
          $scope.submit = function() {
              if($scope.member.email==null){
                  console.log('Saving New Member', $scope.member);    
                  $scope.createMember($scope.member);
              }else{
                  $scope.updateMember($scope.member, $scope.member.email);
                  console.log('Member updated with id ', $scope.member.email);
              }
              $scope.reset();
          };
               
          $scope.edit = function(email){
              console.log('id to be edited', email);
              for(var i = 0; i < $scope.members.length; i++){
                  if($scope.members[i].email == email) {
                     $scope.member = angular.copy($scope.members[i]);
                     break;
                  }
              }
          };
               
          $scope.remove = function(email){
              console.log('id to be deleted', email);
              for(var i = 0; i < $scope.members.length; i++){//clean form if the member to be deleted is shown there.
                  if($scope.members[i].email == email) {
                     $scope.reset();
                     break;
                  }
              }
              $scope.deleteMember(email);
          };
 
           
          $scope.reset = function(){
              $scope.member={email:null,name:''};
              //$scope.myForm.$setPristine(); //reset Form
          };
 
      }]);