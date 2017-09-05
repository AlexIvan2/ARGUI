<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>ARGUI</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value='/css/app.css' />" rel="stylesheet">
    <link href="<c:url value='/css/custom.css' />" rel="stylesheet">
    <link rel="stylesheet"; href="https://unpkg.com/ng-table@2.0.2/bundles/ng-table.min.css">
</head>
<body ng-app="myApp" class="ng-cloak">
<nav class="navbar navbar-default row">
    <div class="container-fluid">
        <div class="navbar-header">
            <ul class="nav navbar-nav">
                <li><a ui-sref="subscribersViewForm">Subscribers</a></li>
                <li><a ui-sref="transactionsViewForm">Transactions</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="row">
    <div class="span12">
        <div class="well" ui-view></div>
    </div>
</div>

<script src="<c:url value='/lib/angular.js' />"></script>
<script src="<c:url value='/lib/angular-ui-router.js' />"></script>
<script src="<c:url value='/js/app.js' />"></script>
<script src="<c:url value='/lib/ng-table/ng-table.js' />"></script>
<script src="<c:url value='/js/service/subscriber_service.js' />"></script>
<script src="<c:url value='/js/controller/subscriber_controller.js' />"></script>
<script src="<c:url value='/js/service/transaction_service.js' />"></script>
<script src="<c:url value='/js/controller/transaction_controller.js' />"></script>
</body>
</html>