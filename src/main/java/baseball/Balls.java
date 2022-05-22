package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls implements Playable {
    private final List<Ball> answersBallNumbers;

    public Balls(List<Integer> answers) {
        this.answersBallNumbers = mapBall(answers);
    }

    //리팩토링 : 인스턴스 변수에 의존하는 곳이 없으므로 static을 붙여서 클래스변수로 사용
    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    //1.
    //private으로 변경 가능
    BallStatus play(Ball userBall) {
        return answersBallNumbers.stream()
                .map(answers -> answers.play(userBall))
                .filter(BallStatus::isNotNothing)
//                .filter(status -> status.isNotNothing())
//                .filter(status -> status != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    //1. 핵심이 되는 기능은?
    //핵심이 되는 기능들 : play
    //핵심이 되는 기능들 중 public으로 노출이 되는 기능 : play
    //2. 핵심기능을 interface화 한다면?
    //위의 경우에는 interface로 만들 수 있음. 다만 필요한 시점에 뽑아내는것이 좋다(interface가 남발될 수 있음)
    //필요한 시점 : 새로운 방식의 play, 새로운 구현체 Balls(새로운 방식을 가진 Balls) 가 생기는 시점
    //3. 변수명을 userBallList로 쓰면?
    //List나 Set 같은 자료구조의 이름을 변수에 적는것은 적절하지 않다. 자료구조가 바뀌게 될 경우, 변수명을 바꿔줘야 되므로.
    public PlayResult play(List<Integer> userBallNumbers) {
        Balls userBalls = new Balls(userBallNumbers);
        PlayResult result = new PlayResult();
        for (Ball BallNumbers : answersBallNumbers) {
            //answersBallNumbers = BallNumbers : 원래 있던 값(정답)
            //userBallNumbers : 유저가 넣어준 값
            //userBallNumbers로 만든 Balls 객체 : userBalls
            BallStatus status = userBalls.play(BallNumbers);
            result.report(status);
        }

        return result;
    }

}
