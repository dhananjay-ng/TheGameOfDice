package com.greatlearning.thegameofdice;

import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.ERROR_ENTER_POSTIVE_NO_PLAYERS;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.ERROR_ENTER_POSTIVE_POINTS_REQUIRED_TO_WIN;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.ERROR_NON_NUMERIC_VALUE_ENTERED;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.MESSAGE_END_GAME_GREETINGS;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.MESSAGE_ENTER_NUMBER_OF_PLAYERS;
import static com.greatlearning.thegameofdice.constants.GameOfDiceConstants.MESSAGE_ENTER_POINTS_REQUIRED_TO_WIN;

import com.greatlearning.thegameofdice.exception.InvalidInputException;
import com.greatlearning.thegameofdice.service.GameOfDiceService;
import com.greatlearning.thegameofdice.service.impl.GameOfDiceServiceImpl;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TheGameOfDice {

  public static void main(String[] args) {

    while (true) {
      try {

        Scanner reader = new Scanner(System.in);
        System.out.println(MESSAGE_ENTER_NUMBER_OF_PLAYERS);

        int numberOfPlayers = reader.nextInt();
        if (numberOfPlayers == 0) {
          throw new InvalidInputException(ERROR_ENTER_POSTIVE_NO_PLAYERS);
        }

        System.out.println(MESSAGE_ENTER_POINTS_REQUIRED_TO_WIN);

        long pointsRequiredToWin = reader.nextInt();
        if (pointsRequiredToWin <= 0) {
          throw new InvalidInputException(ERROR_ENTER_POSTIVE_POINTS_REQUIRED_TO_WIN);
        }

        GameOfDiceService gameOfDiceService = new GameOfDiceServiceImpl();
        gameOfDiceService.startGame(numberOfPlayers, pointsRequiredToWin);

        System.out.println(MESSAGE_END_GAME_GREETINGS);
        break;

      } catch (InputMismatchException inputMismatchException) {
        System.out.println(ERROR_NON_NUMERIC_VALUE_ENTERED);
      } catch (InvalidInputException e) {
        System.out.println(e.getMessage());
      }

    }


  }
}
