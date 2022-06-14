package model;

import java.io.Serializable;

public class Avenger implements Serializable {
  private String name;
  private boolean canFly;
  private int intelligence, strength, speed, energy;
  private int skill, leadership, charm, luck;
  private String detailUrl, imageUrl;

  public double getSimilarity(Avenger avenger) {
    double fly = 0.0;
    if (canFly != avenger.isCanFly())
      fly = 0.2;  
    return 1.0 - fly - (Math.abs(intelligence - avenger.getIntelligence()) 
        + Math.abs(strength - avenger.getStrength())
        + Math.abs(speed - avenger.getSpeed())
        + Math.abs(energy - avenger.getEnergy())
        + Math.abs(skill - avenger.getSkill())
        + Math.abs(leadership - avenger.getLeadership())
        + Math.abs(charm - avenger.getCharm())
        + Math.abs(luck - avenger.getLuck())) / 80.0;
  }
  
  public Avenger() {
  }

  public Avenger(String name) {
    this.name = name;
  }

  public Avenger(String name, boolean canFly, int intelligence, int strength, int speed, int energy, int skill, int leadership, int charm, int luck) {
    this.name = name;
    this.canFly = canFly;
    this.intelligence = intelligence;
    this.strength = strength;
    this.speed = speed;
    this.energy = energy;
    this.skill = skill;
    this.leadership = leadership;
    this.charm = charm;
    this.luck = luck;
  }

  public Avenger(String name, boolean canFly, int intelligence, int strength, int speed, int energy, int skill, int leadership, int charm, int luck, String detailUrl, String imageUrl) {
    this.name = name;
    this.canFly = canFly;
    this.intelligence = intelligence;
    this.strength = strength;
    this.speed = speed;
    this.energy = energy;
    this.skill = skill;
    this.leadership = leadership;
    this.charm = charm;
    this.luck = luck;
    this.detailUrl = detailUrl;
    this.imageUrl = imageUrl;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isCanFly() {
    return canFly;
  }

  public void setCanFly(boolean canFly) {
    this.canFly = canFly;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public void setIntelligence(int intelligence) {
    this.intelligence = intelligence;
  }

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getEnergy() {
    return energy;
  }

  public void setEnergy(int energy) {
    this.energy = energy;
  }

  public int getSkill() {
    return skill;
  }

  public void setSkill(int skill) {
    this.skill = skill;
  }

  public int getLeadership() {
    return leadership;
  }

  public void setLeadership(int leadership) {
    this.leadership = leadership;
  }

  public int getCharm() {
    return charm;
  }

  public void setCharm(int charm) {
    this.charm = charm;
  }

  public int getLuck() {
    return luck;
  }

  public void setLuck(int luck) {
    this.luck = luck;
  }

  public String getDetailUrl() {
    return detailUrl;
  }

  public void setDetailUrl(String detailUrl) {
    this.detailUrl = detailUrl;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @Override
  public String toString() {
    return "Avenger{" + "name=" + name + ", canFly=" + canFly + ", intelligence=" + intelligence + ", strength=" + strength + ", speed=" + speed + ", energy=" + energy + ", skill=" + skill + ", leadership=" + leadership + ", charm=" + charm + ", luck=" + luck + ", detailUrl=" + detailUrl + ", imageUrl=" + imageUrl + '}';
  }
  
}
