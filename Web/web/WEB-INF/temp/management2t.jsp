<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8" />
<title>文件上传-管理</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<meta name="MobileOptimized" content="320">      
<link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="assets/css/style-conquer.css" rel="stylesheet" type="text/css"/>
<link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
<link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
<link href="assets/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="assets/plugins/select2/select2_conquer.css" />
<link rel="stylesheet" href="assets/plugins/data-tables/DT_bootstrap.css" />
<title></title>
</head>
<body class="page-header-fixed">
<div class="header navbar navbar-inverse navbar-fixed-top">
      <div class="header-inner">
         <a class="navbar-brand" href="">
         <img src="assets/img/4.png" alt="logo" class="img-responsive" />
         </a>
         <form class="search-form search-form-header" role="form" action="" >
            <div class="input-icon right">
               <i class="icon-search"></i>
               <input type="text" class="form-control input-medium input-sm" name="query" placeholder="Search...">
            </div>
         </form>
         <a href="javascript:;" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
         <img src="assets/img/menu-toggler.png" alt="" />
         </a> 
         
         
       <!--   <ul class="nav navbar-nav pull-right">
            <li class="dropdown user">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
               <img alt="" src="assets/img/avatar3_small.jpg"/>
               <span class="username">Nick</span>
               <i class="icon-angle-down"></i>
               </a>
            </li>
         </ul>
          -->
          
          
      </div>
  </div>
  <div class="clearfix"></div>
  <div class="page-container">
      <div class="page-sidebar navbar-collapse collapse">
         <ul class="page-sidebar-menu">
            <li>
               <form class="search-form search-form-sidebar" role="form">
                  <div class="input-icon right">
                     <i class="icon-search"></i>
                     <input type="text" class="form-control input-medium input-sm" placeholder="Search...">
                  </div>
               </form>
            </li>
            <li>
               <div class="sidebar-toggler"></div>
               <div class="clearfix"></div>
            </li>
            <li class="start ">
               <a href="management">
               <i class="icon-folder-open"></i> 
               <span class="title">文件上传</span>
               </a>
            </li>
            
            <li class="last ">
               <a href="management2">
               <i class="icon-user"></i> 
               <span class="title">文件管理</span>
               </a>
            </li>
         </ul>
      </div>
      <div class="page-content">
      	<div class="row ">
      		<div class="col-md-12">
      			<h3 class="page-title">文件管理</h3>
      			<ul class="page-breadcrumb breadcrumb">
      				<li>
      					<i class="icon-home"></i>
      					<a href="">主页</a>
      					<i class="icon-angle-right"></i>
      				</li>
      				<li>
      					<a href="">文件管理</a>
      				</li>
      			</ul>
      		</div>
      	</div>  
      	<div class="row ">
      		<div class="col-md-12">
      			<div class="portlet ">
      				<div class="portlet-title">
      					<div class="caption">
      						<i class="icon-reorder"></i>
      						文件汇总
      					</div>
      					<div class="tools">
      						<a class="collapse "></a>
      						<a href="#portlet-config" data-toggle="modal"></a>
      						<a href class="reload"></a>
      						<a href class="remove"></a>
      					</div>
      				</div>
      				<div class="portlet-body">
                     <table class="table table-striped table-hover table-bordered" id="sample_editable_1">
                        <thead>
                           <tr>
                              <th>文件名称</th>
                              <th>文件分类</th>
                              <th>来源信息</th>
                              <th>修改</th>
                              <th>删除</th>
                           </tr>
                        </thead>
                        <tbody>
                           <tr >
                              <td>alex</td>
                              <td>Alex Nilson</td>
                              <td>1234</td>
                              <td><a class="edit" href="javascript:;">修改</a></td>
                              <td><a class="delete" href="javascript:;">删除</a></td>
                           </tr>
                           <tr >
                              <td>lisa</td>
                              <td>Lisa Wong</td>
                              <td>434</td>
                              <td><a class="edit" href="javascript:;">修改</a></td>
                              <td><a class="delete" href="javascript:;">删除</a></td>
                           </tr>
                           <tr >
                              <td>nick12</td>
                              <td>Nick Roberts</td>
                              <td>232</td>
                              <td><a class="edit" href="javascript:;">修改</a></td>
                              <td><a class="delete" href="javascript:;">删除</a></td>
                           </tr>
                           <tr >
                              <td>goldweb</td>
                              <td>Sergio Jackson</td>
                              <td>132</td>
                              <td><a class="edit" href="javascript:;">修改</a></td>
                              <td><a class="delete" href="javascript:;">删除</a></td>
                           </tr>
                           <tr >
                              <td>webriver</td>
                              <td>Antonio Sanches</td>
                              <td>462</td>
                              <td><a class="edit" href="javascript:;">修改</a></td>
                              <td><a class="delete" href="javascript:;">删除</a></td>
                           </tr>
                           <tr >
                              <td>gist124</td>
                              <td>Nick Roberts</td>
                              <td>62</td>
                              <td><a class="edit" href="javascript:;">修改</a></td>
                              <td><a class="delete" href="javascript:;">删除</a></td>
                           </tr>
                        </tbody>
                     </table>
                  </div>
      			</div>
      		</div>
      	
      	</div>
             
      </div>   
   </div>
   <div class="footer">
      <div class="footer-inner">
         2014 &copy; Conquer by Truth.
      </div>
      <div class="footer-tools">
         <span class="go-top">
         <i class="icon-angle-up"></i>
         </span>
      </div>
   </div>
   <script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
   <script src="assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
   <script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
   <script src="assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript" ></script>
   <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
   <script src="assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
   <script src="assets/plugins/jquery.cookie.min.js" type="text/javascript"></script>
   <script src="assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript" ></script>
   <script type="text/javascript" src="assets/plugins/select2/select2.min.js" charset="utf-8"></script>
   <script type="text/javascript" src="assets/plugins/data-tables/jquery.dataTables.js"></script>
   <script type="text/javascript" src="assets/plugins/data-tables/DT_bootstrap.js"></script>
   <script src="assets/scripts/app.js"></script>
   <script src="assets/scripts/table-editable.js"></script>
   <script>
      jQuery(document).ready(function() {    
         App.init();
         TableEditable.init();
      });
   </script>

</body>
</html>