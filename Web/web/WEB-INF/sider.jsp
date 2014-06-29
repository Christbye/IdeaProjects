<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <a href="list-kind.action?unUseJson=true">
            <i class="icon-folder-open"></i>
            <span class="title">文件上传</span>
        </a>
    </li>

    <li class="last ">
        <a href="list-file.action?kind=1&unUseJson=true">
            <i class="icon-user"></i>
            <span class="title">文件管理</span>
        </a>
    </li>
</ul>