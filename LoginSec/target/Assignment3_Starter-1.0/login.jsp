<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Who Cares - Login Page</title>
  </head>
  <body>
      
      <!-- Sets the login page -->
    <h1>Login</h1>
    <form action="j_security_check" method="POST">
      <p>Username: <input type="text" 
                          name="j_username" /></p>
      <p>Password: <input type="text" 
                          name="j_password" /></p>
      <input type="submit" value="Sign Me In" />      
    </form>
    <p>   For testing admin, use tony/tony or peter/peter<br>
            For testing guest, use hulk/hulk or thor/thor <br></p>
    <br><br>
   
  </body>
</html>
