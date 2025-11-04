
# game-character

중세 RTS 게임 캐릭터 시뮬레이션 (과제용). Gradle 프로젝트입니다.

## 실행 방법

### 전제
- Java 17 이상
- Gradle 8.x 이상 (로컬 설치)

### 빌드 & 실행
```bash
gradle clean build
gradle run
```

> Windows 사용자는 PowerShell/cmd에서 동일하게 실행하면 됩니다.

## 구조
- `com.example.game.core` : 공통 인터페이스/추상클래스
- `com.example.game.units` : Knight, Archer, Shuttle, Griffin
- `com.example.game.Main` : 과제 시나리오 실행

## 과제 요구 충족 사항
- 모든 행동은 `System.out.println` 한글 출력
- Knight/Archer/Shuttle/Griffin 이동 (좌표 기반)
- Knight/Archer/Griffin 공격(요구 조건에 맞는 제약 포함)
- Shuttle 수송: Archer/Knight만 탑승, 최대 8기
- 시나리오: Knight/Archer 각 16기, Shuttle 4대, Griffin 5기 → 이동 → 하차 → 지정된 교전

