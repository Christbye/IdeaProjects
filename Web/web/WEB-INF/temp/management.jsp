<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
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
         <jsp:include page="../sider.jsp"></jsp:include>
      </div>
      <div class="page-content">
      	<div class="row ">
      		<div class="col-md-12">
      			<h3 class="page-title">文件上传</h3>
      			<ul class="page-breadcrumb breadcrumb">
      				<li>
      					<i class="icon-home"></i>
      					<a href="">主页</a>
      					<i class="icon-angle-right"></i>
      				</li>
      				<li>
      					<a href="">文件上传</a>
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
      						FM信息
      					</div>
      					<div class="tools">
      						<a class="collapse "></a>
      						<a href="#portlet-config" data-toggle="modal"></a>
      						<a href class="reload"></a>
      						<a href class="remove"></a>
      					</div>
      				</div>
      				<div class="portlet-body form">
      					<form class="form-horizontal" role="form" action="upload" method="post" enctype="multipart/form-data">
                        <div class="form-body">
                           <div class="form-group">
                              <label for="exampleInputFile1" class="col-md-3 control-label">上传文件</label>
                              <div class="col-md-9">
                                 <input type="file" id="exampleInputFile1" name="files" required accept=".mp3">
                              </div>
                           </div>
                           <div class="form-group">
                              <label for="exampleInputFile2" class="col-md-3 control-label">上传图片</label>
                              <div class="col-md-9">
                                 <input type="file" id="exampleInputFile2" name="files" accept="image/*">
                              </div>
                           </div>
                           <div class="form-group">
                              <label  class="col-md-3 control-label">F&nbsp;M名称</label>
                              <div class="col-md-9">
                                 <input type="text" name="fm.name" class="form-control" required  placeholder="Enter text">
                              </div>
                           </div>
                           <div class="form-group">
                              <label  class="col-md-3 control-label">来源信息</label>
                              <div class="col-md-9">
                                    <input type="text" name="fm.source" class="form-control" required  placeholder="Enter text">
                              </div>
                           </div>
                            <div class="form-group" id="album">
                                <label  class="col-md-3 control-label">所属专辑</label>
                                <div class="col-md-9">
                                    <input id="albumHidden" type="hidden" name="fm.album" class="form-control" value="1" >
                                    <select name="fm.kind">

                                    </select>
                                </div>
                            </div>
                           <div class="form-group">
                              <label  class="col-md-3 control-label">文件分类</label>
                              <div class="col-md-9">
                                 <div class="radio-list" id="tdiv" onclick="getAlbum()">
                                    <s:iterator value="list">
                                    <label class="radio-inline" id="radioStart">
                                    <input type="hidden" id="#kind<s:property value="id"/> " value="<s:property value="type"/>">
                                    <input type="radio" required value="<s:property value="id" />" name="fm.kind">
                                        <s:property value="name"/>
                                    </label>
                                    </s:iterator>
                                     <!--
                                     <label class="radio-inline">
                                    <input type="radio" name="optionsRadios" id="optionsRadios26" value="option2"> 武器装备
                                    </label>
                                    <label class="radio-inline">
                                    <input type="radio" name="optionsRadios" id="optionsRadios27" value="option3"> 战役与战争
                                    </label>  
                                    <label class="radio-inline">
                                    <input type="radio" name="optionsRadios" id="optionsRadios28" value="option4"> 科技与神秘
                                    </label>
                                    <%--<s:action name="list-kind" var="list" executeResult="true">--%>
                                        <%--1123<s:debug></s:debug>--%>
                                        <%--<s:iterator value="list" var="l" status="st">--%>
                                            <%--<label class="radio-inline">--%>
                                                <%--<input type="radio" name="optionsRadios" id="optionsRadios<s:property value="st.index" />" value="option4">--%>
                                                <%--<s:property value="l.name"/>--%>
                                            <%--</label>--%>
                                        <%--</s:iterator>--%>
                                    <%--</s:action>--%>
									<label class="radio-inline" id="fff">
                                    <input type="radio" name="optionsRadios" id="optionsRadios29" value="option5" onchange="showinput2(this);"> 单曲
                                    </label>
		                            
		                            <label class="radio-inline" id="ggg">
                                    <input type="radio" name="optionsRadios" id="optionsRadios30" value="option6" onchange="showinput2(this);" > 专辑
                                    </label>
                                     -->
                                    <div class="btn-group" style="margin-left:30px;">
	                                    <table id="attfile" style="display:none;">
										  <tr>
										   <td><input type="text"  size="20"/></td>
										   <td>
										     <a href="javascript:delrows();"><i class="icon-minus"></i></a>
										     <a href="javascript:addrows();"><i class="icon-plus"></i></a>
										   </td>
										  </tr>
										 </table>
                                    </div>
                                    
                                    <div class="btn-group" style="margin-left:30px;">
	                                    <table id="attfile2" style="display:none;">
										  <tr>
										   <td><input type="text"  size="20"/></td>
										   <td>
										     <a href="javascript:delrows2();"><i class="icon-minus"></i></a>
										     <a href="javascript:addrows2();"><i class="icon-plus"></i></a>
										   </td>
										  </tr>
										 </table>
                                    </div>
                                    
                                    
		                            
                                   <!--  <div class="btn-group" style="margin-left:30px;" onClick="addsort(this);" id="buttonrrr">
			                           <button class="btn btn-success" type="button">
			                           <i class="icon-plus"></i>添加分类
			                           </button>
			                  	   </div> 
			                  	    -->
			                  	    
			                  	    <!-- <span id="addinut" onclick="addinut();">
		                                    <i class="icon-plus"></i>
		                                </span>
		                                <span id="delinput" onclick="delinut();">
		                                    <i class="icon-minus" onclick="delinut();" id="delinput"></i>
	                                    </span> -->

			                        
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div class="form-actions right">
                           <div class="col-md-offset-3 col-md-9">
                           	  <button type="button" class="btn btn-default">取消</button> 
                              <button type="submit" class="btn btn-success">提交</button>
                           </div>
                        </div>
                     </form>
      				
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
   <script src="assets/scripts/app.js"></script> 
   <script src="assets/scripts/form-editable.js"></script>
   <script>

       jQuery(document).ready(function() {
         App.init();
         showinput();
      });
      
      function showinput(){
    	  var a = $('#optionsRadios30').is(':checked');
    	  if(a == true){
    		  $('#attfile').css('display','');
    		  $('#ggg').css('display','none');
    	  }else{
    		  $('#attfile').css('display','none');
    		  $('#ggg').css('display','');
    	  }

    	  var b = $('#optionsRadios29').is(':checked');
    	  if(b == true){
    		  $('#attfile2').css('display','');
    		  $('#fff').css('display','none');
    	  }else{
    		  $('#attfile2').css('display','none');
    		  $('#fff').css('display','');
    	  }
      }

      //专辑
      var attachfiles=1;        //个数

      function delrows()
      {
          //删除行
          if(attachfiles>1)
          {
              attachfiles--;
              attfile.deleteRow();
          }
      }
        function addrows()
      {
          //添加行
          attachfiles++;
          var mynewrow=attfile.insertRow();
          col1=mynewrow.insertCell(0);
          col2=mynewrow.insertCell(1);

          if(attachfiles<10){
              col1.innerHTML="<td><input type=text name=filename size=20></td>";
          }
      }

        //单曲
        var attachfiles2=1;        //个数

        function delrows2()
        {
            //删除行
            if(attachfiles2>1)
            {
                attachfiles2--;
                attfile2.deleteRow();
            }
        }
          function addrows2()
        {
            //添加行
            attachfiles2++;
            var mynewrow=attfile2.insertRow();
            col1=mynewrow.insertCell(0);
            col2=mynewrow.insertCell(1);

            if(attachfiles2<10){
                col1.innerHTML="<td><input type=text name=filename size=20></td>";
            }
        }




   </script>

</body>
</html>