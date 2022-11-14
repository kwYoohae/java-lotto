package lotto.domain;

import lotto.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateIsDistinct(numbers);
        sortLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_SIX);
        }
    }

    private void validateIsDistinct(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();

        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_DISTINCT);
        }
    }

    private void sortLottoNumbers(List<Integer> numbers) {
        List<Integer> notImmutableList = new ArrayList<>(numbers);
        Collections.sort(notImmutableList);
    }

    public void validateDistinctInBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber))
            throw new IllegalArgumentException(ErrorMessage.BONUS_DISTINCT_WINNING_NUMBER);
    }
}
