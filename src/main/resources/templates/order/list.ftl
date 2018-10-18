<!DOCTYPE html>
<html>
<head>
    <title>Cities</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<h2>List of Order</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>IdCard</th>
        <th>email</th>
        <th>weixin</th>
        <th>telephone</th>
        <th>area_name</th>
        <th>create_time</th>
        <th>modify_time</th>
    </tr>

            <#list orderList as order>
                <tr>
                    <td>${order.id}</td>
                    <td>${order.username}</td>
                    <td>${order.idCard}</td>
                    <td>${order.email}</td>
                    <td>${order.weixin}</td>
                    <td>${order.telephone}</td>
                    <td>${order.areaName}</td>
                    <td>${order.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                    <td>${order.modifyTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                </tr>
            </#list>
</table>
</body>
</html>