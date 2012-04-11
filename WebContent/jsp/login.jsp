<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="h" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        
        <style type="text/css">
			.error {
				background-color: #b9ecfd;
				}
			#form {
    			width: 250px;
    			padding: 20px;
    			border: 1px solid #270644;
 
    		/*** Adding in CSS3 ***/
    	 	
   			/*** Rounded Corners ***/
			    -moz-border-radius: 20px;
    			-webkit-border-radius: 20px;
 
    		/*** Background Gradient - 2 declarations one for Firefox and one for Webkit ***/
 			   background:  -moz-linear-gradient(19% 75% 90deg,#4E0085, #963AD6);
			   background:-webkit-gradient(linear, 0% 0%, 0% 100%, from(#963AD6), to(#4E0085));
 
    		/*** Shadow behind the box ***/
			    -moz-box-shadow:0px -5px 300px #fed2d4;
    			-webkit-box-shadow:0px -5px 300px #fed2d4;
			}
		</style>     
    </head>
    
   <div style="position: absolute;top:0px;height:100px;width:1000px;background-color: #601f21">
	<h1 style="position: absolute;top: 20px;left:400px;color: #fed2d4">Sample MVC Login</h1>
	</div>
    
    <body>
    
    	<div style="position: absolute;top:180px;left:300px">
			<h3>Login Page</h3>
		
			<div id="form">
    		 
  				<center>
        			<div style="color:red">
            			<h:errors />
        			</div>
        		</center>
        
        		<h:form action="/Login" >
        			<table>
						<tr>
							<td> <bean:message key="Login.userName"/></td>	
							 <td><h:text name="LoginForm" property="userName" /><br></td>
						 </tr>
         				<tr> 
         					<td><bean:message key="Login.password"/> </td>
         					<td> <h:password name="LoginForm" property="password" /></td>
 		        		</tr><br>
        		 		<tr> 
         					<td>
         						<div style="position:absolute;left:150px"><h:submit value="Login" /></div>	
		         			</td>
        		 	 	</tr>
      				</table>
		    	</h:form> 
    		</div> 
    	</div>
    	
		<div style="position:absolute;top:600px">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
    		
    </body> 
</html>