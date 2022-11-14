package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Constant;
import lotto.utils.GameMessage;
import lotto.validation.InputValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Input {

    private final InputValidation inputValidation;
    private final Output output;

    public Input() {
        inputValidation = new InputValidation();
        output = new Output();
    }

    public int getUserMoney() {
        System.out.println(GameMessage.BUY_FOR_LOTTO);

        String question = Console.readLine();
        inputValidation.checkNumber(question, Constant.REGEX_INPUT);
        inputValidation.checkFirstNumberIsNotZero(question, Constant.REGEX_INPUT);
        inputValidation.checkThousandMoney(question);

        return Integer.parseInt(question);
    }

    public List<Integer> getWinningNumber() {
        System.out.print('\n' + GameMessage.INPUT_WINNING_NUMBER + '\n');

        String answer = Console.readLine();
        inputValidation.checkNumber(answer, Constant.REGEX_WINNING_NUMBER_INPUT);
        List<Integer> result = convertToList(answer);
        inputValidation.checkNumberSize(result);
        inputValidation.checkDuplicate(result);
        inputValidation.checkNumberInRange(result);
        sortWinningNumber(result);

        return result;
    }

    public List<Integer> convertToList(String numbers) {
        String[] split = numbers.split(Constant.REGEX_WINNING_NUMBER_INPUT);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            result.add(Integer.parseInt(split[i]));
        }

        return result;
    }

    public void sortWinningNumber(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public String getBonusNumber() {
        System.out.print('\n' + GameMessage.INPUT_BONUS_NUMBER + '\n');

        String answer = Console.readLine();

        return answer;
    }
}
