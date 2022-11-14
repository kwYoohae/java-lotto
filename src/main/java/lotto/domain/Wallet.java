package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wallet {

    private List<Lotto> lottos;

    private int numberOfPurchase;

    public Wallet(int numberOfPurchase) {
        this.numberOfPurchase = numberOfPurchase;
        initialize();
        pickLottos();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    private void pickLottos() {
        for (int i = 0; i < numberOfPurchase; i++) {
            lottos.add(pickRandomNumber());
        }
    }

    private Lotto pickRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constant.LOTTO_MIN_NUMBER, Constant.LOTTO_MAX_NUMBER, Constant.LOTTO_SIZE);
        return new Lotto(numbers);
    }

    public void initialize() {
        lottos = new ArrayList<>();
    }
}
