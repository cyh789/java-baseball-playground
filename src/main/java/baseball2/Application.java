package baseball2;

import baseball2.domain.NumberGenerator;

/**
 * 0. 객체지향 프로그램이란?
 * 인스턴스화 해서,
 * 필요한 기능을 각 역할에 맞는 인스턴스가 수행하게 하고,
 * 그 결과를 종합하여 프로그램을 동작시키는 것을,
 * 우리는 객체지향 프로그램이라고 부른다.
 *
 * 1. 기능을 가지고 있는 클래스를 인스턴스화 한다.
 * 이러한 인스턴스를 객체라고 부른다
 *
 * 2. 필요한 기능을 열할에 맞는 각 인스턴스가 수행하게 한다.
 * 수행하게 한다는 표현은 의인화
 *
 * 3. 각 결과를 종합한다.
 * 합쳐서 하나의 프로그램으로 만들게 한다. 종합한다는 이야기는 동작시킨다는 말이기도 하다.
 */
public class Application {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
    }
}
