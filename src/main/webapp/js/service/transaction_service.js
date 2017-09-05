'use strict';

angular.module('myApp').factory('TransactionService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8090/transactions/';

    var factory = {
        fetchAllTransactions: fetchAllTransactions,
        updateTransaction: updateTransaction
    };

    return factory;

    function fetchAllTransactions() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Transactions');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function updateTransaction(transaction) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + 'update', transaction)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Transaction');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
