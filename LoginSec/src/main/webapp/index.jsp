<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <style>.todo {
                color:red;
            }
            .note {
                color:blue;
            }</style>
        <title>Who Cares</title>
    </head>
    <body>



        <form action="logout">
            <input type="submit" value="logout" />
        </form>

        <!-- Checks error message -->
        <h1>Who Cares</h1><hr>
        <c:if test="${not empty errorMsg}">
            <p class="note"><b>${errorMsg}</b></p><hr>
                </c:if> 


            <!-- displays message for adding and provide the inputs -->
        <h3>Add A New Mission</h3>
        <p>${addmsg}</p>
        <form action="add" method="POST">

            
            Mission Name: <input type="text" name="missionName" value="" /><br>

            <!-- lists off all types -->
            Mission Type: <select name="missionType">
                <c:forEach items="${missionTypes}" var="i" varStatus="status">
                    <option><c:out value="${i}" /></option>

                </c:forEach>
            </select><br>

            Mission Description: <input type="text" name="missionDescription" value="" /><br>
            Difficulty: <input type="text" name="difficulty" value="" /><br>
            Completed: <input type="checkbox" name="completed" value="true" /><br>
            <input type="hidden" name="completed" value="false" /><br>

            <!-- lists of all possible avengers -->
            Who Cares: <select name="assignedTo">
                <c:forEach items="${avengers}" var="i" varStatus="status">
                    <option><c:out value="${i.name}" /></option>
                </c:forEach>
            </select><br>        


            <input type="submit" value="Add New Mission"/>
        </form><br><hr>





        <h3>Reload All Mission</h3>
        <form action="play" method="POST">
            <input type="submit" value="Reload All" />
        </form>
        <p>${listmsg}</p>
        
        <!-- displays entire table -->
        <c:if test="${not empty list}">
            <table border="1">
                <thead>
                    <tr>
                        <th>missionId</th>
                        <th>missionName</th>
                        <th>missionType</th>
                        <th>missionDescription</th>
                        <th>difficulty</th>
                        <th>completed</th>
                        <th>assignedTo</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="Mission" items="${list}">
                        <tr>
                            <td>${Mission.missionId}</td>
                            <td>${Mission.missionName}</td>
                            <td>${Mission.missionType}</td>
                            <td>${Mission.missionDescription}</td>
                            <td>${Mission.difficulty}</td>
                            <td>${Mission.completed}</td>
                            <td>${Mission.assignedTo.getName()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <br><hr>
    </body>
</html>
