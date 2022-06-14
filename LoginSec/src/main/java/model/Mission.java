package model;

import java.io.Serializable;
import java.util.Arrays;

public class Mission implements Serializable {
  public static final String[] TYPES = new String[]{
    "Deliver", "Fight", "Ride", "Build", "Destroy", "Evacuate", "Rescue", 
    "Eliminate", "Collect", "Supply", "Repair", "Defense", "Capture", "Hijack"
  };
  
  private int missionId;
  private String missionName;
  private String missionType;
  private String missionDescription;
  private int difficulty;
  private boolean completed;
  private Avenger assignedTo;

  public Mission() {
  }

  public Mission(String missionName, String missionType, 
      String missionDescription, int difficulty, boolean completed, 
      Avenger assignedTo) {
    if (missionName == null || missionName.isBlank() 
        || missionType == null || missionType.isBlank() 
        || !Arrays.asList(TYPES).contains(missionType)
        || difficulty < 0 || difficulty > 100 || assignedTo == null)
      throw new IllegalArgumentException("Illegal argument.");
    this.missionName = missionName;
    this.missionType = missionType;
    this.missionDescription = missionDescription;
    this.difficulty = difficulty;
    this.completed = completed;
    this.assignedTo = assignedTo;
  }

  public Mission(int missionId, String missionName, String missionType, 
      String missionDescription, int difficulty, boolean completed, 
      Avenger assignedTo) {
    if (missionName == null || missionName.isBlank() 
        || missionType == null || missionType.isBlank() 
        || !Arrays.asList(TYPES).contains(missionType)
        || difficulty < 0 || difficulty > 100 || assignedTo == null)
      throw new IllegalArgumentException("Illegal argument.");
    this.missionId = missionId;
    this.missionName = missionName;
    this.missionType = missionType;
    this.missionDescription = missionDescription;
    this.difficulty = difficulty;
    this.completed = completed;
    this.assignedTo = assignedTo;
  }

  public int getMissionId() {
    return missionId;
  }

  public void setMissionId(int missionId) {
    if (missionName == null || missionName.isBlank() 
        || missionType == null || missionType.isBlank() 
        || !Arrays.asList(TYPES).contains(missionType)
        || difficulty < 0 || difficulty > 100 || assignedTo == null)
      throw new IllegalArgumentException("Illegal argument.");
    this.missionId = missionId;
  }

  public String getMissionName() {
    return missionName;
  }

  public void setMissionName(String missionName) {
    if (missionName == null || missionName.isBlank())
      throw new IllegalArgumentException("Illegal argument.");
    this.missionName = missionName;
  }

  public String getMissionType() {
    return missionType;
  }

  public void setMissionType(String missionType) {
    if (missionType == null || missionType.isBlank() 
        || !Arrays.asList(TYPES).contains(missionType))
      throw new IllegalArgumentException("Illegal argument.");
    this.missionType = missionType;
  }

  public String getMissionDescription() {
    return missionDescription;
  }

  public void setMissionDescription(String missionDescription) {
    this.missionDescription = missionDescription;
  }

  public int getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(int difficulty) {
    if (difficulty < 0 || difficulty > 100)
      throw new IllegalArgumentException("Illegal argument.");
    this.difficulty = difficulty;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public Avenger getAssignedTo() {
    return assignedTo;
  }

  public void setAssignedTo(Avenger assignedTo) {
    if (assignedTo == null)
      throw new IllegalArgumentException("Illegal argument.");
    this.assignedTo = assignedTo;
  }

  @Override
  public String toString() {
    return "Mission{" + "missionId=" + missionId + ", missionName=" + missionName + ", missionType=" + missionType + ", missionDescription=" + missionDescription + ", difficulty=" + difficulty + ", completed=" + completed + ", assignedTo=" + assignedTo + '}';
  }

  
}
