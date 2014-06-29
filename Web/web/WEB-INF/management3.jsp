<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8" />
<title>专辑管理</title>
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
<link href="assets/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css" href="assets/plugins/select2/select2_conquer.css" />
<link rel="stylesheet" href="assets/plugins/data-tables/DT_bootstrap.css" />
<link href="assets/plugins/jquery-ui-1.10.3.custom/css/custom-theme/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" /> 
<link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
<link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>
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
               <a href="management.jsp">
               <i class="icon-folder-open"></i> 
               <span class="title">文件上传</span>
               </a>
            </li>
            
            <li>
               <a href="management3.jsp">
               <i class="icon-folder-open"></i> 
               <span class="title">专辑管理</span>
               </a>
            </li>
            
            <li class="last ">
               <a href="management2.jsp">
               <i class="icon-user"></i> 
               <span class="title">文件管理</span>
               </a>
            </li>
         </ul>
      </div>
      <div class="page-content">
      	<div class="row ">
      		<div class="col-md-12">
      			<h3 class="page-title">专辑管理</h3>
      			<ul class="page-breadcrumb breadcrumb">
      				<li>
      					<i class="icon-home"></i>
      					<a href="">主页</a>
      					<i class="icon-angle-right"></i>
      				</li>
      				<li>
      					<a href="">专辑管理</a>
      				</li>
      			</ul>
      		</div>
      	</div>  
      	<form action="" name="pgform">
      	<div class="row ">
      		<div class="col-md-12">
      			<div class="portlet">
                  <div class="portlet-title">
                     <div class="caption"><i class="icon-cogs"></i>专辑管理</div>
                     <div class="actions">
                       <button type="button" class="btn btn-info" id="addClazz"><i class="icon-pencil"></i> 增加</button>
                        <div class="btn-group">
                           <a class="btn btn-success dropdown-toggle" href="#" data-toggle="dropdown">
                           <i class="icon-cogs"></i> 操作
                           <i class="icon-angle-down"></i>
                           </a>
                           <ul class="dropdown-menu pull-right">
                              <li><a href="javascript:update2();"><i class="icon-pencil"></i> 修改</a></li>
                              <li><a href="#"><i class="icon-trash"></i> 删除</a></li>
                              <li class="divider"></li>
                           </ul>
                        </div>
                     </div>
                  </div>
                  <div class="portlet-body">
                     <table class="table table-striped table-bordered table-hover" id="sample_3">
                        <thead>
                           <tr>
                              <th class="table-checkbox"><input type="checkbox" class="group-checkable" data-set="#sample_3 .checkboxes" /></th>
                              <th>分类</th>
                              <th >名称</th>
                           </tr>
                        </thead>
                        <tbody>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" name="ids" /></td>
                              <td>shuxer</td>
                              <td ><a href="mailto:shuxer@gmail.com">shuxer@gmail.com</a></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="2" name="ids" /></td>
                              <td>looper</td>
                              <td ><a href="mailto:looper90@gmail.com">looper90@gmail.com</a></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>userwow</td>
                              <td ><a href="mailto:userwow@yahoo.com">userwow@yahoo.com</a></td>
                           </tr>
                        </tbody>
                     </table>
                  </div>
               </div>
      				
      	
      		</div>
             
      </div>  
      </form> 
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
   
   <div id="add" style="display: none">
   		<form>
   			<div class="form-body">
   				 <div align="left">
   				 	<label  class="col-md-3 control-label">选择分类</label>
                   	 <label class="radio-inline"><input type="radio" name="optionsRadios" value="option1"> 专辑</label>
                     <label class="radio-inline"><input type="radio" name="optionsRadios" value="option1"> 单曲</label>
                 </div>
   				 <div class="form-group" style="margin-top:10px;">
                    <input type="text" class="form-control col-md-2"  placeholder="请输入文件名称">
                 </div>
                 <div class="form-group" align="center" style="margin-top:50px;">
                 <button type="button" class="btn" style="background: rgb(77,144,254); padding-left:10px; color: #fff"><i class="icon-plus"></i>&nbsp;提交</button>
                 <button type="button" id="dialogClose" class="btn" style="background: red; padding-left:10px; color: #fff"><i class="icon-remove"></i>&nbsp;关闭</button>
                 </div>
   			</div>
   		</form>
   </div>
      </div>
   <script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
   <script src="assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>   
   <script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
   <script src="assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript" ></script>
   <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
   <script src="assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>  
   <script src="assets/plugins/jquery.cookie.min.js" type="text/javascript"></script>
   <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
   <script src="assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>  
   <script src="assets/plugins/jquery.cookie.min.js" type="text/javascript"></script>
   <script src="assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript" ></script>
   <script type="text/javascript" src="assets/plugins/select2/select2.min.js" charset="utf-8"></script>
   <script type="text/javascript" src="assets/plugins/data-tables/jquery.dataTables.js"></script>
   <script type="text/javascript" src="assets/plugins/data-tables/DT_bootstrap.js"></script>
   <script src="assets/plugins/jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
   <script src="assets/scripts/app.js"></script>
   <script src="assets/scripts/table-managed.js"></script> 
   <link rel="shortcut icon" href="favicon.ico" />
   <script>
      jQuery(document).ready(function() {    
         App.init();
         TableManaged.init();
      });
      $('#addClazz').click(function(){
    	  $('#add').dialog({
    	      	dialogClass:'ui-dialog-grey',
    	      	modal:true,
    	      	width:400,
    	      	height:200,
    	      	title:'新增分类'
    	       });
      });
     
      $('#dialogClose').click(function(){
    	  $('#add').dialog("close");
      });
      
      
      function update(){
    	  
    	  var a = $('[name="ids"]');
    	  var count = 0;
    	  $(a).each(function(i,iteam){
    		  if(a[i].checked == true){
    			  count++;
    		  }
    	  });
    	  
    	  if(count > 1){
			  alert("只能选择一条记录");
		  }
    	  else if(count == 0){
			  alert("请选择要修改的记录");
		  }
    	  return count;
      }
      
      function update2(){
    	  var tempmoudle = update();
    	  if(tempmoudle == 1){
    		  var a = $('[name="ids"]');
    		  for(var i = 0,j = a.length;i<j;i++){
    			 if(a[i].checked == true){
    				 //$.getJSON()
    			 } 
    		  }
    	  }
    	  
      }
      
      
   </script>

</body>
</html>