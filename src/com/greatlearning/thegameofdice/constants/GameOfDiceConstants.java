package com.greatlearning.thegameofdice.constants;

public class GameOfDiceConstants {

  public static final String ROLL_DICE_COMMAND = "r";

  public static final int DICE_ROLL_MAX_SCORE = 6;
  public static final int DICE_ROLL_MIN_SCORE = 1;

  public static final String MESSAGE_GAME_COMPLETION = "Congratulations %s!!, you have completed game, your rank is : %d\n";
  public static final String MESSAGE_DICE_ROLL_SCORE = "\nYou have scored %d points.\n";
  public static final String MESSAGE_DICE_ROLL_INSTRUCTION = "\n%s its your turn (press 'r' to roll the dice)\n";
  public static final String MESSAGE_SCORE_BOARD = "\n:::::::::::::: Score Board ::::::::::::::";
  public static final String MESSAGE_SCORE_BOARD_HEADER = "%-10s  %-10s  %-10s\n";
  public static final String MESSAGE_PLAYER_NAME = "Player Name";
  public static final String MESSAGE_POINTS = "Points";
  public static final String MESSAGE_RANK = "Rank";
  public static final String MESSAGE_ENTER_NUMBER_OF_PLAYERS = "Please Enter Number of Players : ";
  public static final String MESSAGE_ENTER_POINTS_REQUIRED_TO_WIN = "Please Enter Points Required To Win : ";
  public static final String MESSAGE_END_GAME_GREETINGS = "\n\nThank you all for participating in game :)";

  public static final String ERROR_ENTER_POSTIVE_NO_PLAYERS = "[ERROR] Please Enter Positive Number of Players";
  public static final String ERROR_ENTER_POSTIVE_POINTS_REQUIRED_TO_WIN = "[ERROR] Please Enter Positive Positive Points Required To Win";
  public static final String ERROR_NON_NUMERIC_VALUE_ENTERED = "[ERROR] Please Enter Positive Numeric Value!!";

  public static final String RULE_EXTRA_CHANCE = "\nSixer!!, Well played %s, you will get one more chance to play.\n";
  public static final String RULE_PENALTY = "\n%s, you are getting penalty because of scoring '1'  twice consecutively.\n";
  public static final String RULE_PENALTY_TURN_SKIP = "\n%s, as part of Penalty, you will not be given this turn.\n";

}
