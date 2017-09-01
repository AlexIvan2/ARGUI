<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Subscribers</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <%--<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>--%>
</head>
<body ng-app="myApp" class="ng-cloak">
<div class="generic-container" ng-controller="SubscriberCtrl as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Subscribers </span></div>

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