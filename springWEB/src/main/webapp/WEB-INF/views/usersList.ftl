<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Users list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Age</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>

<#list users as user>
    <tr>
        <td><a href="/user/${user.id}">${user.id}</a></td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.age}</td>
        <td><a href="/delete/${user.id}">delete</a></td>
        <td><a href="/update/${user.id}">edit</a></td>
    </tr>
</#list>
</table>
<a href="/addUser">Add new user</a>

</body>
</html>