package Server.game.caro;

import java.util.concurrent.Callable;

public class TestTimerCaro {

    @SuppressWarnings("rawtypes")
    public TestTimerCaro() {
        Caro caro = new Caro();
        Callable endCallback, tickCallback;

        endCallback = (Callable) () -> {
            System.out.println("END");
            throw new Exception();
        };

        tickCallback = (Callable) () -> {
            if (caro.getTurnTimer().getCurrentTick() == 10) {
                caro.cancelTimer();
            }
            System.out.println(caro.getTurnTimer().getCurrentTick());
            throw new Exception();
        };

        caro.getTurnTimer().setTimerCallBack(endCallback, tickCallback, 1);

    }

    public static void main(String[] args) {
        new TestTimerCaro();
    }
}
