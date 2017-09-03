'use strict';

angular.module('myApp').controller('SubscriberCtrl', ['$scope', 'SubscriberService', function($scope, SubscriberService) {

    $scope.subscriber={
        accountNo:null,
        firstName:'',
        lastName:'',
        personalID:'',
        balance:''
    };
    $scope.subscribers=[];

    fetchAllSubscribers();

    function fetchAllSubscribers(){
        SubscriberService.fetchAllSubscribers()
            .then(
            function(data) {
                $scope.subscribers = data;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

    function createSubscriber(subscriber){
        SubscriberService.createSubscriber(subscriber)
            .then(
                fetchAllSubscribers,
            function(errResponse){
                console.error('Error while creating Subscriber');
            }
        );
    }

    function updateSubscriber(subscriber){
        SubscriberService.updateSubscriber(subscriber)
            .then(
                fetchAllSubscribers,
                function(errResponse){
                    console.error('Error while updating Subscriber');
                }
            );
    }

    function deleteSubscriber(accountNo){
        SubscriberService.deleteSubscriber(accountNo)
            .then(
                fetchAllSubscribers,
            function(errResponse){
                console.error('Error while deleting Subscriber');
            }
        );
    }

    $scope.submit = function() {
        if($scope.subscriber.accountNo === null) {
            console.log('Saving New Subscriber', $scope.subscriber);
            createSubscriber($scope.subscriber);
        } else {
            updateSubscriber($scope.subscriber);
            console.log('Subscriber updated with account number ', $scope.subscriber.accountNo);
        }
        reset();
    };

    $scope.edit = function(accountNo) {
        console.log('AccountNo to be edited', accountNo);
        for (var i = 0; i < $scope.subscribers.length; i++) {
            if ($scope.subscribers[i].accountNo === accountNo) {
                $scope.subscriber = angular.copy($scope.subscribers[i]);
                break;
            }
        }
    };

    $scope.remove = function(accountNo) {
        console.log('AccountNo to be deleted', accountNo);
        if($scope.subscriber.accountNo === accountNo) {
            reset();
        }
        deleteSubscriber(accountNo);
    };


    $scope.reset = function() {
        $scope.subscriber={
            accountNo:null,
            firstName:'',
            lastName:'',
            personalID:'',
            balance:''
        };
    }

}]);
