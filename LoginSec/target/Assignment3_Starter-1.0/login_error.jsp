<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Error Page</title>
  </head>
  <body>
      
      <!-- display login error message and provide a way to move back -->
    <h1>Login Error</h1>
    <p>Incorrect Username or Password, Try Again Please</p>      
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