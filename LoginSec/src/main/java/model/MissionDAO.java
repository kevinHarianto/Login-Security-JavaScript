package model;

import java.sql.*;
import java.util.*;
import db.ConnectionPool;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MissionDAO {

    //TODO: add constant SQL Statements
    private static final String SQL_CREATE_TABLE
            
            //only makes the table if it does not exist, to avoid overwriting
            = "create table if not exists missiontable ("
            + "missionId int primary key auto_increment,"
            + "missionName varchar(50) not null unique,"
            + "missionType varchar(50) not null,"
            + "missionDescription varchar(400),"
            + "difficulty int not null,"
            + "completed boolean not null,"
            + "assignedTo varchar(50)"
            + ");";

    private static final String SQL_ADD_USER
            = "insert into missiontable (missionName, missionType, missionDescription, difficulty, completed, assignedTo) "
            + "values (?,?,?,?,?,?);";

    private static final String SQL_SELECT_ALL = "select * from missiontable;";
    
            
            
    /*
    *@Author: Kevin Harianto, @Date: 4/13/2022
    *Description: selects the entire table
    *param: none
    *return: List
    */
    public static List<Mission> selectAll() {
        List<Mission> list = new ArrayList<>();
        //TODO: return a list of all missions in DB
        try (Connection connection = ConnectionPool.getInstance().getConnection();
                PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);) {
            ResultSet rs = ps.executeQuery();
            
            //obtains the entire table
            while (rs.next()) {
                list.add(new Mission(
                        rs.getInt("missionId"), rs.getString("missionName"),
                        rs.getString("missionType"), rs.getString("missionDescription"),
                        rs.getInt("difficulty"), rs.getBoolean("completed"), new Avenger(rs.getString("assignedTo"))));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(MissionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    /*
    *@Author: Kevin Harianto @Date: 4/13/2022
    *Description: Inserts the data to the table
    *param: Mission object
    *return: boolean
    */
    public static boolean insertMission(Mission mission) {
        boolean done = false;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
                PreparedStatement ps = connection.prepareStatement(SQL_ADD_USER);) {
            
            //inserts each value to the table
            ps.setString(1, mission.getMissionName());
            ps.setString(2, mission.getMissionType());
            ps.setString(3, mission.getMissionDescription());
            ps.setInt(4, mission.getDifficulty());
            ps.setBoolean(5, mission.isCompleted());   
            ps.setString(6, mission.getAssignedTo().getName());
            
            done = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(MissionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return done;
    }
    
    /*
    *@Author: Kevin Harianto. @Date: 4/3/2022
    *Description: Creates a table
    *param: none
    *return: none
    */
     public static void createTable() {
    try ( Connection connection = ConnectionPool.getInstance().getConnection();  
        PreparedStatement ps = connection.prepareStatement(SQL_CREATE_TABLE);) {
      ps.execute();
    } catch (SQLException ex) {
      System.err.println(ex);
      Logger.getLogger(MissionDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
    
     
}


