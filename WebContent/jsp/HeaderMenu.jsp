<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<script type="text/javascript">
			var timeout         = 500;
			var closetimer		= 0;
			var ddmenuitem      = 0;

			// open hidden layer
			function mopen(id)
			{	
			// cancel close timer
			mcancelclosetime();

			// close old layer
			if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';

	// get new layer and show it
	ddmenuitem = document.getElementById(id);
	ddmenuitem.style.visibility = 'visible';

}
// close showed layer
function mclose()
{
	if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';
}

// go close timer
function mclosetime()
{
	closetimer = window.setTimeout(mclose, timeout);
}

// cancel close timer
function mcancelclosetime()
{
	if(closetimer)
	{
		window.clearTimeout(closetimer);
		closetimer = null;
	}
}

// close layer when click-out
document.onclick = mclose; 
// -->
</script>

<style type="text/css">
#sddm
{	margin: 0;
	padding: 0;
	z-index: 30}

#sddm li
{	margin: 0;
	padding: 0;
	list-style: none;
	float: left;
	font: bold 11px arial}

#sddm li a
{	display: block;
	margin: 0 1px 0 0;
	padding: 4px 10px;
	width: 60px;
	background: #5970B2;
	color: #FFF;
	text-align: center;
	text-decoration: none}

#sddm li a:hover
{	background: #49A3FF}

#sddm div
{	position: absolute;
	visibility: hidden;
	margin: 0;
	padding: 0;
	background: #EAEBD8;
	border: 1px solid #5970B2}

	#sddm div a
	{	position: relative;
		display: white;
		margin: 0;
		padding: 5px 10px;
		width: auto;
		white-space: nowrap;
		text-align: left;
		text-decoration: none;
		background: #EAEBD8;
		color: #2875DE;
		font: 11px arial}

	#sddm div a:hover
	{	background: #49A3FF;
		color: #FFF}


	</style>
</head>


<body>
	<div style="position: absolute;top:0px;height:100px;width:1000px;background-color: #601f21">
	<h1 style="position: absolute;top: 20px;left:400px;color: #fed2d4">Sample MVC Login</h1>
	<div style="position: absolute;top:100px;">
	<ul id="sddm">
		<li><a href="/AttendenceTracker/jsp/Home_Page.jsp" onmouseover="mopen('m4')" onmouseout="mclosetime()">Home</a>
		</li>	
		
		<li><a href="/AttendenceTracker" onmouseover="mopen('m4')" onmouseout="mclosetime()">Logout</a></li>
			
	</ul>
</div>
</div>
<div style="clear:both"></div>

		
</body>
</html>