# 코딩으로 학습하는 리팩토링 by 인프런 백기선 

## 이해하기 힘든 이름 

### 냄새1. 이해하기 힘든 이름 
```
  이해하기 힘든 이름 
    - 깔끔한 코드에서 가장 중요한 것 중 하나가 바로 "좋은 이름"이다.
	- 함수, 변수, 클래스, 모듈의 이름 등 모두 어떤 역할을 하는지 어떻게 쓰이는지 직관적이어야 한다.
	- 사용할 수 있는 리팩토링 기술 
	  - 함수 선언 변경하기(Change Function Declaration)
	  - 변수 이름 바꾸기 (Rename Variable)
	  - 필드 이름 바꾸기 (Rename Field)
```

#### 리팩토링1. 함수 선언 변경하기 
```
  함수 선언 변경하기 (Change Function Declaration)
    - 함수 이름 변경하기, 메소드 이름 변경하기, 매개변수 추가하기, 매개변수 제거하기, 시그니처 변경하기
	  - 좋은 이름을 가진 함수는 함수가 어떻게 구현되었는지 코드를 보지 않아도 이름만 보고도 이해할 수 있다. 
	  - 좋은 리름을 찾아내는 방법? 함수에 주석을 작성한 다음, 주석을 함수 이름으로 만들어 본다. 
	  - 함수의 매개변수는 
	    - 함수 내부의 문맥을 결정한다. (예, 전화번호 포매팅 함수)
		- 의존성을 결정한다. (예, Payment 만기일 계산 함수)
```

#### 리팩토링2. 변수 이름 바꾸기 
```
  변수 이름 바꾸기 (Rename Variable)
    - 더 많이 사용되는 변수일수록 그 이름이 더 중요하다. 
	  - 람다식에서 사용하는 변수 vs 함수의 매개변수 
	- 다이나믹 타입을 지원하는 언어에서는 타입을 이름에 넣기도 한다.
	- 여러 함수에 걸쳐 쓰이는 필드 이름에는 더 많이 고민하고 이름을 짓는다. 
```

#### 리팩토링3. 필드 이름 바꾸기 
```
  필드 이름 바꾸기 (Rename Field)
    - Record 자료 구조의 필드 이름은 프로그램 전반에 걸쳐 참조될 수 잇기 때문에 
	  매우 중요하다. 
	  - Record 자료 구조: 특정 데이터와 관련있는 필드를 묶어놓은 자료 구조 
	  - 파이썬의 Dictionary, 또는 줄여서 dicts
	  - C#의 Record
	  - 자바 14 버전부터 지원 (record 키워드)
	  - 자바에서는 Getter와 Setter 메소드 이름도 필드의 이름과 비슷하게 간주할 수 있다. 
```