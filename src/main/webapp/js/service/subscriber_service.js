'use strict';

angular.module('myApp').factory('SubscriberService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8090/subscribers/';

    var factory = {
        fetchAllSubscribers: fetchAllSubscribers,
        createSubscriber: createSubscriber,
        updateSubscriber: updateSubscriber,
        deleteSubscriber: deleteSubscriber
    };

    return factory;

    function fetchAllSubscribers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createSubscriber(subscriber) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, subscriber)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Subscriber');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateSubscriber(subscriber) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + 'update', subscriber)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Subscriber');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteSubscriber(accountNo) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + 'delete', accountNo)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Subscriber');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
