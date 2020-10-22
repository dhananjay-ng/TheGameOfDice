package com.greatlearning.thegameofdice.service.impl;

import static com.greatlearning.thegameofdice.GameHelper.initializePlayers;
import static com.greatlearning.thegameofdice.GameHelper.printDiceRollInstruction;
import static com.greatlearning.thegameofdice.GameHelper.printGameStatistics;
import static com.greatlearning.thegameofdice.GameHelper.sortPlayerByRankingAsc;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.DICE_ROLL_MAX_SCORE;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.DICE_ROLL_MIN_SCORE;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.MESSAGE_DICE_ROLL_SCORE;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.MESSAGE_GAME_COMPLETION;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.ROLL_DICE_COMMAND;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.RULE_EXTRA_CHANCE;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.RULE_PENALTY;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.RULE_PENALTY_TURN_SKIP;

import com.greatlearning.thegameofdice.model.Player;
import com.greatlearning.thegameofdice.service.GameOfDiceService;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameOfDiceServiceImpl implements GameOfDiceService {

  /**
   * Method uses playersQueue to keep track of currently playing players and scheduling players turn
   * based on queues FIFO principle, which will simulate Round Robin Scheduling.
   * <pre>
   * for every turn :
   * 1. we remove first player from queue and roll dice,
   * 2. points are added to players points
   * 3. if player scores 6, we continue to give chance to same player
   * 4. if player'sprevious score and current score is '1' the we assign him penalty
   * 5. if player has not scored 6, we add player to last of queue.
   * <pre>
   * <pre>
   *   One list is maintained with same players as in queue, which will be used for printing scoreboard
   *   after every dice roll, and also we will be sorting players based on rank to show in scoreboard.
   * </pre>
   *
   * @param numberOfPlayers     : number of players playing the game
   * @param pointsRequiredToWin : minimum points required to win
   */
  @Override
  public void startGame(int numberOfPlayers, long pointsRequiredToWin) {
    Scanner reader = new Scanner(System.in);
    Random randomGenerator = new Random();

    List<Player> playerList = initializePlayers(numberOfPlayers);
    Deque<Player> playersQueue = new LinkedList<>(playerList);

    long rank = 0;

    while (!playersQueue.isEmpty()) {

      Player currentPlayingPlayer = playersQueue.removeFirst();

      //Rule: If Player is in penalty they will not be given chance, so we will remove penalty
      //of user and reset his last points
      if (currentPlayingPlayer.isInPenalty()) {
        System.out.printf(RULE_PENALTY_TURN_SKIP, currentPlayingPlayer.getPlayerName());
        currentPlayingPlayer.setInPenalty(false);
        currentPlayingPlayer.setLastPoints(0);

        //player will be added to last of queue so that his turn will come later
        playersQueue.addLast(currentPlayingPlayer);
        continue;
      }

      printDiceRollInstruction(currentPlayingPlayer);

      String playerInput = reader.next();

      if (ROLL_DICE_COMMAND.equals(playerInput)) {

        int diceRollResult = randomGenerator.nextInt(DICE_ROLL_MAX_SCORE) + 1;
        currentPlayingPlayer.addPoints(diceRollResult);
        System.out.printf(MESSAGE_DICE_ROLL_SCORE, diceRollResult);

        if (currentPlayingPlayer.getPoints() >= pointsRequiredToWin) {

          currentPlayingPlayer.setRank(++rank);

          System.out.printf(MESSAGE_GAME_COMPLETION, currentPlayingPlayer.getPlayerName(),
              currentPlayingPlayer.getRank());

          sortPlayerByRankingAsc(playerList);
          printGameStatistics(playerList);
          continue;
        }

        if (isPenaltyEligibleScore(currentPlayingPlayer, diceRollResult)) {

          System.out.printf(RULE_PENALTY, currentPlayingPlayer.getPlayerName());
          currentPlayingPlayer.setInPenalty(true);
        }

        if (diceRollResult == DICE_ROLL_MAX_SCORE) {
          System.out.printf(RULE_EXTRA_CHANCE, currentPlayingPlayer.getPlayerName());
          playersQueue.addFirst(currentPlayingPlayer);
        } else {
          playersQueue.addLast(currentPlayingPlayer);
        }

        sortPlayerByRankingAsc(playerList);
        printGameStatistics(playerList);
        currentPlayingPlayer.setLastPoints(diceRollResult);
      }
    }

  }

  private boolean isPenaltyEligibleScore(Player currentPlayingPlayer, int diceRollResult) {
    return diceRollResult == DICE_ROLL_MIN_SCORE
        && currentPlayingPlayer.getLastPoints() == DICE_ROLL_MIN_SCORE;
  }


}
