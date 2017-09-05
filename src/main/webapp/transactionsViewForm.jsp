<div class="generic-container" ng-controller="TransactionCtrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Transactions Form </span></div>
        <div class="formcontainer">
            <form name="myForm" class="form-horizontal">
                <input type="hidden" ng-model="subscriber.accountNo" />

                <div class="row">
                    <div class="form-group col-md-6">
                        <label class="col-md-3 control-lable">Primary Uid</label>
                        <div class="col-md-6">
                            <input type="text" ng-model="transaction.primaryUid" name="primaryUid" class="transaction form-control input-sm" required ng-minlength="3" ng-pattern="/^[a-zA-Z]+$/" ng-disabled="true"/>
                        </div>
                    </div>

                    <div class="form-group col-md-6">
                        <label class="col-md-3 control-lable">Account Number</label>
                        <div class="col-md-6">
                            <input type="text" ng-model="transaction.accountNo" name="accountNo" class="transaction form-control input-sm" required ng-minlength="3" ng-pattern="/^[a-zA-Z]+$/" ng-disabled="true"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-6">
                        <label class="col-md-3 control-lable">Transaction Code</label>
                        <div class="col-md-6">
                            <input type="text" ng-model="transaction.transactionCode" name="transactionCode" class="transaction form-control input-sm" required ng-pattern="/^[0-9]{6}-[0-9]{5}$/" ng-disabled="true"/>
                        </div>
                    </div>

                    <div class="form-group col-md-6">
                        <label class="col-md-3 control-lable">Sales Tax Code</label>
                        <div class="col-md-6">
                            <input type="text" ng-model="transaction.salesTaxCode" name="salesTaxCode" class="transaction form-control input-sm" required ng-pattern="/^[0-9]{6}-[0-9]{5}$/" ng-disabled="true"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-6">
                        <label class="col-md-3 control-lable">Amount Before Tax</label>
                        <div class="col-md-6">
                            <input type="text" ng-model="transaction.amountBeforeTax" name="amountBeforeTax" class="transaction form-control input-sm" required ng-minlength="3" ng-pattern="/^[a-zA-Z]+$/" ng-disabled="true"/>
                        </div>
                    </div>

                    <div class="form-group col-md-6">
                        <label class="col-md-3 control-lable">Sales Tax Amount</label>
                        <div class="col-md-6">
                            <input type="text" ng-model="transaction.salesTaxAmount" name="salesTaxAmount" class="transaction form-control input-sm" required ng-minlength="3" ng-pattern="/^[a-zA-Z]+$/" ng-disabled="true"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-6">
                        <label class="col-md-3 control-lable">Transaction Amount</label>
                        <div class="col-md-6">
                            <input type="text" ng-model="transaction.transactionAmount" name="transactionAmount" class="transaction form-control input-sm" required ng-pattern="/^[0-9]{6}-[0-9]{5}$/" ng-disabled="true"/>
                        </div>
                    </div>

                    <div class="form-group col-md-6">
                        <label class="col-md-3 control-lable">Transaction Date</label>
                        <div class="col-md-6">
                            <input type="text" ng-model="transaction.transactionDate" name="transactionDate" class="transaction form-control input-sm" required ng-pattern="/^[0-9]{6}-[0-9]{5}$/" ng-disabled="true"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-6">
                        <label class="col-md-3 control-lable">Transaction Effective Date</label>
                        <div class="col-md-6">
                            <input type="text" ng-model="transaction.transactionEffectiveDate" name="transactionEffectiveDate" class="transaction form-control input-sm" required ng-pattern="/^[0-9]{6}-[0-9]{5}$/" ng-disabled="true"/>
                        </div>
                    </div>

                    <div class="form-group col-md-6">
                        <label class="col-md-3 control-lable">Billing YN</label>
                        <div class="col-md-6">
                            <input type="text" ng-model="transaction.billingYN" name="billingYN" class="transaction form-control input-sm" required ng-pattern="/^[0-9]{6}-[0-9]{5}$/" ng-disabled="true"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <%--<button type="button" ng-click="reset()" class="btn btn-warning btn-sm">Update</button>--%>
                        <button type="button" ng-click="reset()" class="btn btn-warning btn-sm">Reset Form</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Transactions </span></div>
        <div class="tableContainer">
            <table ng-table="tableParams" class="table" show-filter="true" ng-cloak>
                <tr ng-repeat="transaction in $data">
                    <%--<td title="'Account No'" filter="{ accountNo: 'text'}" sortable="'accountNo'">{{transaction.accountNo}}</td>--%>
                    <td title="'ID'" filter="{ primaryUid: 'number'}" sortable="'primaryUid'">{{transaction.primaryUid}}</td>
                    <td title="'Transaction Code'" filter="{ transactionCode: 'text'}" sortable="'transactionCode'">{{transaction.transactionCode}}</td>
                    <td title="'Sales Tax Code'" filter="{ salesTaxCode: 'text'}" sortable="'salesTaxCode'">{{transaction.salesTaxCode}}</td>
                    <td title="'Amount Before Tax'" filter="{ amountBeforeTax: 'text'}" sortable="'amountBeforeTax'">{{transaction.amountBeforeTax}}</td>
                    <td title="'Sales Tax Amount'" filter="{ salesTaxAmount: 'text'}" sortable="'salesTaxAmount'">{{transaction.salesTaxAmount}}</td>
                    <td title="'Transaction Amount'" filter="{ transactionAmount: 'text'}" sortable="'transactionAmount'">{{transaction.transactionAmount}}</td>
                    <td title="'Transaction date'" filter="{ transactionDate: 'text'}" sortable="'transactionDate'">{{transaction.transactionDate}}</td>
                    <td title="'Transaction effect date'" filter="{ transactionEffectiveDate: 'text'}" sortable="'transactionEffectiveDate'">{{transaction.transactionEffectiveDate}}</td>
                    <td title="'Billing yn'" filter="{ billingYN: 'text'}" sortable="'billingYN'">{{transaction.billingYN}}</td>
                </tr>
            </table>
        </div>
    </div>
</div>
