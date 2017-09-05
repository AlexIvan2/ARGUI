'use strict';

angular.module('myApp').controller('TransactionCtrl', ['$scope', 'TransactionService', '$filter', 'ngTableParams', function($scope, TransactionService, $filter, NgTableParams) {

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

    $scope.transactions=[];
    $scope.tableParams = new NgTableParams({
        page: 1,
        count: 10
    }, {
        dataset: $scope.transactions
    });

    fetchAllTransactions();

    function fetchAllTransactions(){
        TransactionService.fetchAllTransactions()
            .then(
            function(data) {
                $scope.transactions = data;
                $scope.tableParams.data = data;
            },
            function(errResponse){
                console.error('Error while fetching Transactions');
            }
        );
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
    }

}]);
