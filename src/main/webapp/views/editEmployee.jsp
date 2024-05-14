<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Black Pig
  Date: 14-May-24
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Edit Employee</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1>EDIT STUDENT</h1>
<form:form action="/editEmployee" class="row g-3" modelAttribute="edit" method="post">
    <div class="col-md-6">
        <label for="name" class="form-label">Name</label>
        <form:input path="employeeName" class="form-control" id="name"/>
    </div>
    <br/>
    <div class="col-md-6">
        <label for="male" class="form-label">Male</label>
        <form:radiobutton path="gender" class="form-control" id="male" value="true"/>
    </div>
    <div class="col-md-6">
        <label for="female" class="form-label">Female</label>
        <form:radiobutton path="gender" class="form-control" id="female" value="false"/>
    </div>
    <br/>
    <div class="col-md-6">
        <label for="birthday" class="form-label">Birthday</label>
        <form:input path="birthday" type="date" class="form-control" id="birthday"/>
    </div>
    <br/>
    <div class="col-12">
        <label for="address" class="form-label">Address</label>
        <form:input path="address" type="text" class="form-control" id="address" placeholder="1234 Main St"/>
    </div>
    <br/>
    <div class="col-12">
        <label for="department" class="form-label">Department</label>
        <form:input path="department" class="form-control" id="department"/>
    </div>
    <div class="col-md-6">
        <label for="position" class="form-label">City</label>
        <form:input path="position" class="form-control" id="position"/>
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary">Update</button>
    </div>
</form:form>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>