<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <meta name="description" content=""/>
        <meta name="author" content=""/>
        <title>Simple Sidebar - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet"/>
    </head>
    <body>
    <p>changed</p>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar menu.jsp-->
            <tiles:insertAttribute name="menu"/>
            
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation nav.jsp-->
                <tiles:insertAttribute name="nav"/>
                
                <!-- Page content-->
                <div class="container-fluid">
                    <tiles:insertAttribute name="body"/>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
