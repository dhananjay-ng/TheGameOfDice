package com.greatlearning.thegameofdice;

import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.MESSAGE_DICE_ROLL_INSTRUCTION;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.MESSAGE_PLAYER_NAME;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.MESSAGE_POINTS;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.MESSAGE_RANK;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.MESSAGE_SCORE_BOARD;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.MESSAGE_SCORE_BOARD_HEADER;

import com.greatlearning.thegameofdice.model.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class GameHelper {

  private GameHelper() {

  }

  /**
   * Method prints score board for  game.
   */
  public static void printGameStatistics(List<Player> playerList) {

    System.out.println(MESSAGE_SCORE_BOARD);
    System.out
        .printf(MESSAGE_SCORE_BOARD_HEADER, MESSAGE_PLAYER_NAME, MESSAGE_POINTS, MESSAGE_RANK);
    playerList.forEach(player -> System.out
        .printf("%-10s   %-10d   %-10s\n", player.getPlayerName(), player.getPoints(),
            player.getRank() != Long.MAX_VALUE ? player.getRank() : "-"));

  }

  /**
   * Acending order sorting based on rank of player.
   */
  public static void sortPlayerByRankingAsc(List<Player> playerList) {
    Collections.sort(playerList, Comparator.comparingLong(Player::getRank));
  }


  public static void printDiceRollInstruction(Player currentPlayingPlayer) {
    System.out.printf(MESSAGE_DICE_ROLL_INSTRUCTION, currentPlayingPlayer.getPlayerName());
  }


  public static List<Player> initializePlayers(int numberOfPlayers) {
    List<Player> players = new ArrayList<>();

    for (int playerIndex = 1; playerIndex <= numberOfPlayers; playerIndex++) {
      players.add(new Player(playerIndex));
    }

    return shufflePlayers(players);
  }


  /**
   * shuffles players list using swapping technique.
   */
  public static List<Player> shufflePlayers(List<Player> players) {
    Random random = new Random();
    for (int playerIndex = 0; playerIndex < players.size(); playerIndex++) {
      int randomNumber = random.nextInt(players.size());

      Player temp = players.get(randomNumber);
      players.set(randomNumber, players.get(playerIndex));
      players.set(playerIndex, temp);
    }

    return players;
  }

}
