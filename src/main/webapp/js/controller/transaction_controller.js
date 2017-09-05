'use strict';

angular.module('myApp').controller('TransactionCtrl', ['$scope', 'TransactionService', '$filter', 'ngTableParams', function($scope, TransactionService, $filter, NgTableParams) {

    function init() {
        $scope.transaction = {
            primaryUid: null,
            accountNo: '',
            transactionCode: '',
            salesTaxCode: '',
            amountBeforeTax: '',
            salesTaxAmount: '',
            transactionAmount: '',
            transactionDate: '',
            transactionEffectiveDate: '',
            billingYN: ''
        };

        $scope.tableParams = new NgTableParams({
            page: 1,
            count: 10
        }, {
            counts: [],
            getData: function ($defer, params) {
                TransactionService.fetchAllTransactions()
                    .then(
                        function(response) {
                            params.total(response.length);
                            $defer.resolve(response);
                        },
                        function(errResponse){
                            $defer.reject();
                        }
                    );
                return $defer.promise;
            }
        });
    }

    $scope.updateTransaction = function(transaction) {
        TransactionService.updateTransaction(transaction)
            .then(
                fetchAllTransactions,
                function(errResponse){
                    console.error('Error while updating Transaction');
                }
            );
    };

    $scope.reset = function() {
        $scope.transaction={
            primaryUid:null,
            accountNo:'',
            transactionCode:'',
            salesTaxCode:'',
            amountBeforeTax:'',
            salesTaxAmount:'',
            transactionAmount:'',
            transactionDate:'',
            transactionEffectiveDate:'',
            billingYN:''
        };
    };

    init();

}]);