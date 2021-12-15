<html>
<head>
    <#--引样式：zTreeStyle.css-->
    <link rel="stylesheet" href="/js/zTree_v3-3.5.32/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <#--引js-->
    <script type="text/javascript" src="/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
    <#--引ztree.core.js核心js-->
    <script type="text/javascript" src="/js/zTree_v3-3.5.32/js/jquery.ztree.core.js"></script>
    <#--ztree.excheck.js勾选框-->
    <script type="text/javascript" src="/js/zTree_v3-3.5.32/js/jquery.ztree.excheck.js"></script>
</head>
<body>
<#--类样式：树-->
<div id="test1" class="ztree"></div>
<#--隐藏域：拿到角色id：指明给谁授权-->
<input id="roleId" value="${roleId!}" type="hidden">

<script type="text/javascript" src="/js/role/grant.js"></script>
</body>
</html>