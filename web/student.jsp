<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="addoredit" value="true" ></c:set>
    <c:if test="${studentedit.id gt 0}">
    <c:set var="addoredit" value="false" ></c:set>
    </c:if>
<%-- 
    Document   : adminhome
    Created on : Jul 24, 2018, 12:28:00 PM
    Author     : Raishin
--%>

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

  
  
 <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
 
  <!-- DataTables -->
  <link rel="stylesheet" href="../../plugins/datatables/dataTables.bootstrap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">
  <!-- Tell the browser to be responsive to screen width -->
    <!-- Bootstrap 3.3.6 -->
  

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
        Student
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>Student</a></li>
        <li class="active">Management</li>
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
              <h3 class="box-title">Student Information</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form action="${pageContext.request.contextPath}/Admin/Student/Add" method="post">
              <div class="box-body col-md-9">
                  <c:if test="${addoredit.equals('false')}">
                <div class="form-group" > 
                  <label for="inputId">Id</label>
                  <input type="text" class="form-control" id="inputId" name="sid" value="${studentedit.id}" readonly>
                </div>
                </c:if>
                  <div class="form-group" > 
                  <label for="inputName">Name</label>
                  <input type="text" class="form-control" id="inputName"name="sname"
                         <c:if test="${addoredit.equals('false')}"> value="${studentedit.name}" </c:if> placeholder="Enter student name.." required>
                </div>
                <div class="form-group ">
                  <label for="inputAddress">Address</label>
                  <input type="text" class="form-control" id="inputAddress"name="saddress" 
                         <c:if test="${addoredit.equals('false')}"> value="${studentedit.address}" </c:if> placeholder="Enter student address.." required>
                </div>
                <div class="form-group ">
                  <label for="inputGender">Gender &nbsp;</label>
                 <div>
                  <input type="radio"id="inputGender" name="sgender" value="Male" <c:if test="${studentedit.gender.equals('Male')}"> checked </c:if>> Male &nbsp;
                  <input type="radio"id="inputGender" name="sgender" value="Female" <c:if test="${studentedit.gender.equals('Female')}"> checked </c:if>> Female &nbsp;
                </div>
                </div>
                <div class="form-group ">
                  <label for="inputDob">Date of Birth</label>
                  <input type="date" class="form-control" id="inputDob" name="sdob" 
                          <c:if test="${addoredit.equals('false')}"> value="${studentedit.dob}" </c:if>>
                </div>

                  
                 
                      <div class="form-group ">
                      <label for="inputHobbies">Hobbies &nbsp;</label>
                      <div >
                      <input type="checkbox"id="inputHobbies" name="shobbies" value="Coding" <c:if test="${studentedit.hobbies.contains('Coding')}"> checked </c:if> >Coding &nbsp;
                  <input type="checkbox"id="inputHobbies "name="shobbies"value="Designing" <c:if test="${studentedit.hobbies.contains('Designing')}"> checked </c:if>>Designing &nbsp;
                  <input type="checkbox"id="inputHobbies" name="shobbies" value="Testing" <c:if test="${studentedit.hobbies.contains('Testing')}"> checked </c:if> >Testing &nbsp;
                </div>  
                  </div>
                <div class="form-group ">
                  <label for="inputPhone">Phone</label>
                  <input type="number" class="form-control" id="inputPhone" name="sphone"<c:if test="${addoredit.equals('false')}"> value="${studentedit.phone}" </c:if> placeholder="Enter student phone no..">
                </div>
              <div class="form-group">
                  <label for="inputCountry">Country</label>
                  <select class="form-control" id="inputCountry"name="scountry">
                      <option value="Nepal"  <c:if test="${studentedit.country.equals('Nepal')}"> selected </c:if>>Nepal</option>
                      <option value="India"<c:if test="${studentedit.country.equals('India')}"> selected </c:if>>India</option>
                      <option value="USA" <c:if test="${studentedit.country.equals('USA')}"> selected </c:if>>USA</option>
                      <option value="UK" <c:if test="${studentedit.country.equals('UK')}"> selected </c:if>>UK</option>
                      <option value="Japan" <c:if test="${studentedit.country.equals('Japan')}"> selected </c:if>>Japan</option>
                      
                  </select>
                </div>
              <div class="form-group ">
                  <label for="inputEmail">Email</label>
                  <input type="email" class="form-control" id="inputEmail"name="semail" <c:if test="${addoredit.equals('false')}"> value="${studentedit.email}" </c:if> placeholder="Enter student email address..">
                </div>
              
              <div class="box-footer col-md-12">
                  <button type="submit"class="btn btn-app">
                <i class="fa fa-save"></i> Save</button>
              </div>
            
          </div>
                </form>
    </div>
        </div>
      </div>
       </section>
 <!--display part-->
       
        <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <!-- /.box -->
          <div class="box">
            <div class="box-header">
              <h3 class="box-title"> All <small>Student data</small></h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="studentTable" class="table table-bordered table-striped"style="width:100%">
                <thead>
                <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Address</th>
                  <th>Gender</th>
                  <th>Date of Birth</th>
                  <th>Hobbies</th>
                  <th>Phone</th> 
                  <th>Country</th> 
                  <th>Email</th> 
                  
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${studentdata}" var="student">
                      <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.address}</td>
                        <td>${student.gender}</td>
                        <td>${student.dob}</td>
                        <td>${student.hobbies}</td>
                        <td>${student.phone}</td>
                        <td>${student.country}</td>
                        <td>${student.email}</td>
                        <td><a class="btn btn-app-sm" href="${pageContext.request.contextPath}/Admin/Student/Edit?id=${student.id}"><i class="fa fa-edit"></i> Edit</a></td>
                        <td><a class="nav-link btn btn" data-toggle="modal" data-target="#deleteModal"><font color="scarlet"><i class="fa fa-trash-o"></i>Delete</font></a></td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                     <th>ID</th>
                  <th>Name</th>
                  <th>Address</th>
                  <th>Gender</th>
                  <th>Date of Birth</th>
                  <th>Hobbies</th>
                  <th>Phone</th> 
                  <th>Country</th> 
                  <th>Email</th> 
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
              <!-- right col -->
        
      </div>
      <!-- /.row (main row) -->

 
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
<script src="$${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
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


<!-- ./wrapper -->

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

<script>
  $(function () {

   
    $('#studentTable').DataTable({
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

