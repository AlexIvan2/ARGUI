<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Subscribers</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value='/css/app.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/css/custom.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
<div class="generic-container" ng-controller="SubscriberCtrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Subscribers Registration Form </span></div>
        <div class="formcontainer">
            <form ng-submit="submit()" name="myForm" class="form-horizontal">
                <input type="hidden" ng-model="subscriber.accountNo" />

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">First Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="subscriber.firstName" name="firstName" class="subscriber form-control input-sm" placeholder="Enter First Name" required ng-minlength="3" ng-pattern="/^[a-zA-Z]+$/"/>
                            <div class="has-error" ng-show="myForm.firstName.$error.required || myForm.firstName.$error.minlength || myForm.firstName.$invalid">
                                <span ng-show="myForm.firstName.$error.required">This is a required field</span>
                                <span ng-show="myForm.firstName.$error.minlength">Minimum length required is 3</span>
                                <span ng-show="myForm.firstName.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable">Last Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="subscriber.lastName" name="lastName" class="subscriber form-control input-sm" placeholder="Enter Last Name" required ng-minlength="3" ng-pattern="/^[a-zA-Z]+$/"/>
                            <div class="has-error" ng-show="myForm.lastName.$error.required || myForm.lastName.$error.minlength || myForm.lastName.$invalid">
                                <span ng-show="myForm.lastName.$error.required">This is a required field</span>
                                <span ng-show="myForm.lastName.$error.minlength">Minimum length required is 3</span>
                                <span ng-show="myForm.lastName.$invalid">This field is invalid </span>
                            </div>
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
                        <input type="submit"  value="{{!subscriber.accountNo ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
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
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Account No</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Personal ID</th>
                    <th>Balance</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="subscriber in subscribers">
                    <td><span ng-bind="subscriber.accountNo"></span></td>
                    <td><span ng-bind="subscriber.firstName"></span></td>
                    <td><span ng-bind="subscriber.lastName"></span></td>
                    <td><span ng-bind="subscriber.personalID"></span></td>
                    <td><span ng-bind="subscriber.balance"></span></td>
                    <td>
                        <button type="button" ng-click="edit(subscriber.accountNo)" class="btn btn-success custom-width">Edit</button>
                        <button type="button" ng-click="remove(subscriber.accountNo)" class="btn btn-danger custom-width">Remove</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="<c:url value='/lib/angular.js' />"></script>
<script src="<c:url value='/js/app.js' />"></script>
<script src="<c:url value='/js/service/subscriber_service.js' />"></script>
<script src="<c:url value='/js/controller/subscriber_controller.js' />"></script>
</body>
</html>