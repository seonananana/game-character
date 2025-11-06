# game-character (Kotlin, Gradle)

과제 요구사항을 모두 반영한 콘솔 프로그램입니다.

## 실행
```bash
./gradlew run        # (Gradle Wrapper가 있을 경우)
# 또는
./gradlew test
# 로컬
gradle run           # 로컬에 gradle 설치 시
```

## 빌드
```bash
./gradlew build
```

> **참고**: 이 ZIP에는 바이너리 파일인 `gradle-wrapper.jar`가 포함되어 있지 않습니다.
> 로컬에서 아래 명령 한 번만 실행하면 Wrapper 파일이 자동 생성되어 어디서든 `./gradlew run`이 가능합니다.
> ```bash
> gradle wrapper --gradle-version 8.9
> ```

## 요구사항 충족 내역
- Knight, Archer, Shuttle, Griffin 클래스 구현
- 이동: 2D 좌표(Point2D)로 이동, 캐릭터별 방식 안내
- 공격: 규칙 반영
  - Knight: 창(비행 대상 공격 불가)
  - Archer: 화살(지상/공중 모두 가능)
  - Griffin: 번개(비행 대상 불가, 지상만)
- Shuttle: Knight/Archer만 탑승, 정원 8
- 모든 행동을 한글 `println` 로그로 출력
- 시나리오: 16+16 → Shuttle 4대 탑승 → Griffin 5와 이동 → 전원 하차 → 타입별 공격 시연
- Gradle 프로젝트 (build/run 가능), README에 실행 명령 기재

## 클래스/역할 요약
- **UnitBase**: 공통 속성/로그(이름, ID, 좌표, 공중 여부)
- **Movable / Attackable / Transporter**: 행위 인터페이스로 역할 분리
- **Knight**: 말 이동, 창(비행 대상 불가)
- **Archer**: 도보 이동, 화살(지상/공중 모두 가능)
- **Griffin**: 비행 이동, 번개(비행 대상 불가)
- **Shuttle**: 비행 수송, Knight/Archer만, 정원 8
- **Main**: 전체 시나리오 실행

## 샘플 출력(일부)
```
=== 게임 시작: 캐릭터 생성 ===
=== 셔틀 탑승: Knight 16, Archer 16 → Shuttle 4대(정원 8×4=32) ===
[셔틀#1] 궁수#1 탑승 완료. (현재 1/8)
...
=== Griffin 5기 + Shuttle 4대가 함께 이동 ===
[그리핀#1] 하늘을 날아 (0, 0) → (100, 50) 로 이동합니다.
...
=== 도착지에서 셔틀 전원 하차 ===
[기사#1] 도착지 (100, 50) 에 하차했습니다.
...
=== 전투 시연 ===
- Knight의 공격 시연(타입별 1기):
[기사#1] 창으로 궁수#2 를 찌릅니다!
[기사#1] 공격 불가: 날아다니는 대상(그리핀#2)은 창으로 공격할 수 없습니다.
...
=== 시연 종료 ===
```

## 개발 환경
- Kotlin 2.0.21 (JVM)
- JDK 17 권장
- Gradle 8.9 (Wrapper 생성 권장)
