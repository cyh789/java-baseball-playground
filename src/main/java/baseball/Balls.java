package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> answersBallList;

    public Balls(List<Integer> answers) {
        this.answersBallList = mapBall(answers);
    }

    //리팩토링 : 인스턴스 변수에 의존하는 곳이 없으므로 static을 붙여서 클래스변수로 사용
    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball userBall) {
        return answersBallList.stream()
                .map(answers -> answers.play(userBall))
                .filter(BallStatus::isNotNothing)
//                .filter(status -> status.isNotNothing())
//                .filter(status -> status != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(List<Integer> userBallList) {
        Balls userBalls = new Balls(userBallList);
        PlayResult result = new PlayResult();
        for (Ball ballList : answersBallList) {
            //answersBallList = ballList : 원래 있던 값(정답)
            //userBallList : 유저가 넣어준 값
            //userBallList로 만든 Balls 객체 : userBalls
            BallStatus status = userBalls.play(ballList);
            result.report(status);
        }

        return result;
    }

}
