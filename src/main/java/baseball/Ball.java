package baseball;

public class Ball {

    private final int position;

    //* 클래스분리 연습 *
    //객체지향 생활체조 -> 3.모든 원시 값과 문자열을 포장한다.
    //포장하게 되면 유효성체크를 할 수 있게 되므로, 값을 보장할 수 있게 된다.
    //유효성체크를 유틸 클래스를 만들어서 처리하지 말고, 원시값이나 문자열을 포장해서 처리하면 뭔가 로직을 추가 할 수 있다(클래스 분리)
//    private final int ballNo;
    private final BallNumber ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
//        this.ballNo = ballNo;
        this.ballNo = new BallNumber(ballNo);
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (ball.matchBallNo(ballNo)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchPosition(int position) {
        return this.position == position;
    }

    private boolean matchBallNo(BallNumber ballNo) {
        return this.ballNo == ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }
}
