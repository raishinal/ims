<%-- 
    Document   : adminhome
    Created on : Jul 24, 2018, 12:28:00 PM
    Author     : Raishin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Admin Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="../../plugins/datatables/dataTables.bootstrap.css">
  
  
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!--page header and left side bar here-->
  <%@include file="/header.jsp" %>
  
  

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       User
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>User</a></li>
        <li class="active">Registration</li>
      </ol>
    </section>

    <!-- Main content -->
      <section class="content">
      <div class="row row-border">
        
         <!-- left column -->
        <div class="col-md-12">
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Add User</h3>
            </div>
            <!-- /.box-header -->
           
                <form action="${pageContext.request.contextPath}/RegisterUser/Add" method="post" enctype="multipart/form-data">
                     <div class="box-body col-sm-3">
                    <div class="form-group">
                        <label for="inputName">Full Name</label>
                        <input class="form-control" type="text" id="inputName" name="ufname" placeholder="Enter Full Name" > 
                    </div>
                    <div class="form-group">
                        <label for="inputUsername">Username</label>
                        <input class="form-control" type="text" id="inputUsername" name="uname" placeholder="Enter Username" > 
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">Password</label> &nbsp; <span style="color:red">${error_pass}</span>
                        <input class="form-control" type="password" id="inputPassword" name="upass" placeholder="Enter password" >
                    </div>
                    <div class="form-group">
                        <label for="inputConfirmPassword">Confirm Password</label>
                        <input class="form-control" type="password" id="inputPassword" name="ucpass" placeholder="Re-Enter Password" > 
                    </div>
                    <div class="form-group">
                        <label for="inputAuthority">Authority</label>
                        <select id="inputAuthority" name="uauthority" class="form-control">
                            <option value="admin">ADMINISTRATOR</option>
                            <option value="user">REGISTERED USER</option>
                            <option value="staff">STAFF MEMBER</option>
                        </select>
                    </div>
                     <div class="form-group">
                        <label for="inputActive">Status</label>
                        <input type="radio" id="inputActive" name="uactive" value="1">Activate &nbsp; 
                        <input type="radio" id="inputActive" name="uactive" value="0">Deactivate &nbsp; 
                    </div> 
                     <div class="form-group">
                        <label for="inputGender">Gender</label>
                        <input type="radio" id="inputGender" name="ugender" value="male">Male &nbsp; 
                        <input type="radio" id="inputGender1" name="ugender" value="female">Female &nbsp; 
                        <input type="radio" id="inputGender2" name="ugender" value="other">Other &nbsp; 
                    </div> 
                     
                     <div class="form-group">
                        <label for="inputImage">User Image</label>
                        <!--<input type="image" id="inputImage" name="uimage" placeholder="Select User Image">--> 
                        <input type="file" id="inputImage" name="uimage" placeholder="Select User Image"> 
                        </div> 
                    </div>
                            <div class="box-footer col-md-12"
                   <div class="box-footer col-md-12">
                  <button type="submit"class="btn btn-app">
                <i class="fa fa-save"></i> Save
                  </button>
              </div>
                     
                    </form>
            </div>
            <!-- /.box-body -->
          </div>
                     </section>
          <!-- /.box -->
        
        <!-- /.col -->
      <!-- /.row -->
   
        <!-- right col -->
        <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <!-- /.box -->
          <div class="box">
            <div class="box-header">
              <h3 class="box-title"> Users</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="userTable" class="table table-bordered table-striped">
                <thead>
                    
                <tr>
                    <th>ID</th>
                  <th>Full Name</th>
                  <th>Username</th>
                  <th>Authority</th>
                  <th>Status</th>
                  <th>Gender</th>
                  
                 
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userdata}" var="user">
                      <tr>
                          <td>${user.id}</td>
                          <td>${user.fname}</td>
                          <td>${user.uname}</td>
                          <td>${user.authority}</td>
                          <td>${user.active}</td>
                          <td>${user.gender}</td>
                          
                      </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                      <th>ID</th>
                  <th>Full Name</th>
                  <th>Username</th>
                  <th>Authority</th>
                  <th>Status</th>
                  <th>Gender</th>
                  
                </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
      </div>
                        </div>
      <!-- /.row (main row) -->

        
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
    <!--footer and control side bar here-->
  <%@include file="footer.jsp" %>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="${pageContext.request.contextPath}/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/dist/js/demo.js"></script>

<script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- jQuery 2.2.3 -->
<script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="../../plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<!-- page script -->
<script>
  $(function () {
//    $("#courseTable").DataTable();
   
    $('#userTable').DataTable({
      "paging": true,
      "lengthChange": true,
      "searching": true,
      "ordering": true,
      "info": true,
      "autoWidth": false
    });
  });
</script>
</body>
</html>
