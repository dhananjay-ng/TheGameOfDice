package com.greatlearning.thegameofdice.model;

public class Player {

  private int number;
  private boolean inPenalty;
  private long lastPoints;
  private long points;
  private long rank;

  public Player(int number) {
    this.number = number;
    this.inPenalty = false;
    this.lastPoints = 0;
    this.points = 0;
    this.rank = Long.MAX_VALUE;
  }

  public String getPlayerName() {
    return "Player-" + number;
  }

  public boolean isInPenalty() {
    return inPenalty;
  }

  public void setInPenalty(boolean inPenalty) {
    this.inPenalty = inPenalty;
  }

  public long getLastPoints() {
    return lastPoints;
  }

  public void setLastPoints(long lastPoints) {
    this.lastPoints = lastPoints;
  }

  public long getPoints() {
    return points;
  }

  public void setPoints(long points) {
    this.points = points;
  }

  public void addPoints(long points) {
    this.points += points;
  }


  public long getRank() {
    return rank;
  }

  public void setRank(long rank) {
    this.rank = rank;
  }
}
