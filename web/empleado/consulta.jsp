<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <link rel="stylesheet" href="assets/css/style.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <h1 class="txt-center">Lista de Empleados</h1>
        <a href="CrlEmpleado?accion=nuevo" class="btn-nuevo">Nuevo</a><br><br>
        <table border="1" cellpadding="4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombres</th>
                    <th>Sueldo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
        <c:forEach var="e" items="${lista}">
            <tr>
                <td>${e.idempleado}</td>
                <td>${e.nombre_empleado}</td>
                <td>${e.sueldo}</td>
                <td>
                    <a href="CrlEmpleado?accion=modificar&id=${e.idempleado}" class="btn-info">
                        <i class="fa fa-edit"></i>
                    </a> | 
                    <a href="CrlEmpleado?accion=eliminar&id=${e.idempleado}" class="btn-danger" onclick="return confirm('Estás seguro que deseas eliminar el registro?');">
                        <i class="fa fa-trash-alt"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
            </tbody>
       </table>
    </body>
</html>