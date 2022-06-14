package controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import model.*;

public class WhoCaresServlet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
       if (request.getUserPrincipal() != null) {
        String username = request.getUserPrincipal().getName();
        request.getSession().setAttribute("username", username);
      }
    String action = request.getServletPath();
    try {
      switch(action) {
        case "/play":
          loadAvengers();
          loadTypes();
          list(request, response);
          break;
        case "/list":
          list(request, response);
          break;
        case "/add":
          add(request, response);
          break;
        
        case "/logout":
          request.getSession().invalidate();
          response.sendRedirect("play");
          return;
        default:
          list(request, response);
      }
    } catch(Exception e) {
      request.setAttribute("errorMsg", "Can't be added to DB, Error: " + e);
      list(request, response);
    }
    getServletContext().getRequestDispatcher("/index.jsp")
        .forward(request, response);

  }   
  
 private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean done = false;

        //obtains the parameters
        Mission user = new Mission(
                request.getParameter("missionName"),
                request.getParameter("missionType"),
                request.getParameter("missionDescription"),
                Integer.parseInt(request.getParameter("difficulty")),
                Boolean.parseBoolean(request.getParameter("completed")),
                new Avenger(request.getParameter("assignedTo")));

        MissionDAO.insertMission(user);

       
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

    private void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //obtains the list
        List<Mission> list = MissionDAO.selectAll();
        request.setAttribute("list", list);
        request.setAttribute("listmsg", list != null && !list.isEmpty()
                ? "Found " + list.size() + " users." : "No user found.");
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    //A helper method for loading all avengers to a context attribute
    private void loadAvengers() {
        List<Avenger> avengers = Collections.unmodifiableList(
                AvengerFileIO.readFromFile(getServletContext().getRealPath(
                        getServletContext().getInitParameter("filepathname"))));
        getServletContext().setAttribute("avengers", avengers);
        getServletContext().setAttribute("avengersSize", avengers.size());
    }

    //A helper method for loading all missioin types to a context attribute
    private void loadTypes() {
        List<String> missionTypes = Collections.unmodifiableList(
                Arrays.asList(Mission.TYPES));
        getServletContext().setAttribute("missionTypes", missionTypes);
        getServletContext().setAttribute("missionTypesSize", missionTypes.size());
    }
  
  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
