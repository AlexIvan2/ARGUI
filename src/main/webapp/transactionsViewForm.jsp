<div class="generic-container" ng-controller="TransactionCtrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Transactions Form </span></div>
        <div class="formcontainer">
            <form name="myForm" class="form-horizontal">
                <input type="hidden" ng-model="subscriber.accountNo" />
                <%--primaryUid:null,--%>
                <%--accountNo:'',--%>
                <%--transactionCode:'',--%>
                <%--salesTaxCode:'',--%>
                <%--amountBeforeTax:'',--%>
                <%--salesTaxAmount:'',--%>
                <%--transactionAmount:'',--%>
                <%--transactionDate:'',--%>
                <%--transactionEffectiveDate:'',--%>
                <%--billingYN:''--%>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">First Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="transaction.primaryUid" name="primaryUid" class="transaction form-control input-sm" required ng-minlength="3" ng-pattern="/^[a-zA-Z]+$/" ng-disabled="true"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">Last Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="transaction.accountNo" name="accountNo" class="transaction form-control input-sm" required ng-minlength="3" ng-pattern="/^[a-zA-Z]+$/" ng-disabled="true"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">Personal ID</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="subscriber.personalID" name="personalID" class="subscriber form-control input-sm" placeholder="Enter Personal ID" required ng-pattern="/^[0-9]{6}-[0-9]{5}$/"/>
                            <div class="has-error" ng-show="myForm.personalID.$error.required || myForm.personalID.$invalid">
                                <span ng-show="myForm.personalID.$error.required">This is a required field</span>
                                <span ng-show="myForm.personalID.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">Balance</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="subscriber.balance" name="balance" class="subscriber form-control input-sm" placeholder="Enter Balance" required ng-pattern="/^[0-9]+[0-9]*(.[0-9]{2})?$/"/>
                            <div class="has-error" ng-show="myForm.balance.$error.required || myForm.balance.$invalid">
                                <span ng-show="myForm.balance.$error.required">This is a required field</span>
                                <span ng-show="myForm.balance.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <button type="button" ng-click="reset()" class="btn btn-warning btn-sm">Update</button>
                        <button type="button" ng-click="reset()" class="btn btn-warning btn-sm">Reset Form</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Subscribers </span></div>
        <div class="tableContainer">
            <table ng-table="tableParams" class="table" show-filter="true">
                <tr ng-repeat="transaction in $data">
                    <td title="'Account No'" filter="{ accountNo: 'text'}" sortable="'accountNo'">{{transaction.accountNo}}</td>
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
