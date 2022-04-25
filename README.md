# 코딩으로 학습하는 리팩토링 by 인프런 백기선 


## 냄새1. 이해하기 힘든 이름 
```
  이해하기 힘든 이름 
    - 깔끔한 코드에서 가장 중요한 것 중 하나가 바로 "좋은 이름"이다.
	- 함수, 변수, 클래스, 모듈의 이름 등 모두 어떤 역할을 하는지 어떻게 쓰이는지 직관적이어야 한다.
	- 사용할 수 있는 리팩토링 기술 
	  - 함수 선언 변경하기(Change Function Declaration)
	  - 변수 이름 바꾸기 (Rename Variable)
	  - 필드 이름 바꾸기 (Rename Field)
```

### 리팩토링1. 함수 선언 변경하기 
```
  함수 선언 변경하기 (Change Function Declaration)
    - 함수 이름 변경하기, 메소드 이름 변경하기, 매개변수 추가하기, 매개변수 제거하기, 시그니처 변경하기
	  - 좋은 이름을 가진 함수는 함수가 어떻게 구현되었는지 코드를 보지 않아도 이름만 보고도 이해할 수 있다. 
	  - 좋은 리름을 찾아내는 방법? 함수에 주석을 작성한 다음, 주석을 함수 이름으로 만들어 본다. 
	  - 함수의 매개변수는 
	    - 함수 내부의 문맥을 결정한다. (예, 전화번호 포매팅 함수)
		- 의존성을 결정한다. (예, Payment 만기일 계산 함수)
```

### 리팩토링2. 변수 이름 바꾸기 
```
  변수 이름 바꾸기 (Rename Variable)
    - 더 많이 사용되는 변수일수록 그 이름이 더 중요하다. 
	  - 람다식에서 사용하는 변수 vs 함수의 매개변수 
	- 다이나믹 타입을 지원하는 언어에서는 타입을 이름에 넣기도 한다.
	- 여러 함수에 걸쳐 쓰이는 필드 이름에는 더 많이 고민하고 이름을 짓는다. 
```

### 리팩토링3. 필드 이름 바꾸기 
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

## 냄새2. 중복 코드 
```
  중복 코드 
    - 중복 코드의 단점 
	  - 비슷한지, 완전히 동일한 코드인지 주의 깊게 봐야한다.
	  - 코드를 변경할 때, 동일한 모든 곳의 코드를 변경해야 한다. 
	- 사용할 수 있는 리팩토링 기술 
	  - 동일한 코드를 여러 메소드에서 사용하는 경우, 함수 추출하기(Extract Function)
	  - 코드가 비슷하게 생겼지만 완전히 같지는 않는 경우, 코드 분리하기(Slide Statement)
	  - 여러 하위 클래스에 동일한 코드가 있다면, 메소드 올리기(Pull Up Method)
```

### 리팩토링4. 함수 추출하기 
```
  함수 추출하기(Extract Function)
    - 의도와 구현 분리하기 
	- 무슨 일을 하는 코드인지 알아내려고 노력해야 하는 코드라면 해당 코드를 
	  함수로 분리하고 함수 이름으로 무슨 일을 하는지 표현할 수 있다. 
	- 한줄 짜리 메소드도 괜찮은가?
	- 거대한 함수 안에 들어있는 주석은 추출한 함수를 찾는데 있어서 좋은 단서가 될 수 있다. 
```

### 리팩토링5. 코드 정리하기 
```
  코드 정리하기 (Slide Statements)
    - 관련있는 코드끼리 묶여있어야 코드를 더 쉽게 이해할 수 있다. 
	- 함수에서 사용할 변수를 상단에 미리 정의하기 보다는, 해당 변수를 사용하는 코드
	  바로 위에 선언하자. 
	- 관련있는 코드끼리 묶은 다음, 함수 추출하기(Extract Function)를 사용해서 
	  더 깔끔하게 분리할 수도 있다. 
```

### 리팩토링6. 메소드 올리기 
```
  메소드 올리기(Pull up Method)
    - 중복 코드는 당장은 잘 동작하더라도 미래에 버그를 만들어 낼 빌미를 제공한다. 
	  - 예) A에서 코드를 고치고, B에는 반영하지 않은 경우 
	- 여러 하위 클래스에 동일한 코드가 있다면, 손쉽게 이 방법을 적용할 수 있다. 
	- 비슷하지만 일부 값만 다른 경우라면, 함수 매개변수화하기(Parameterize Function)
	  리팩토링을 적용한 이후에, 이 방법을 사용할 수 있다. 
	- 하위 클래스에 있는 코드가 상위 클래스가 아닌 하위 클래스 기능에 의존하고 있다면, 
	  필드 올리기(Pull up Field)를 적용한 이후에 이 방법을 적용할 수 있다. 
	- 두 메소드가 비슷한 절차를 따르고 있다면, 템플릿 메소드 패턴 적용을 고려할 수 있다. 
```

## 냄새3. 긴 함수 
```
  긴 함수
    - 짧은 함수 vs 긴 함수 
	  - 함수가 길 수록 더 이해하기 어렵다 vs 짧은 함수는 더 많은 문맥 전환을 필요로 한다. 
	  - 과거에는 작은 함수를 사용하는 경우에 더 많은 서브루틴 호출로 인한 오버헤드가 있었다. 
	  - 작은 함수에 좋은 이름을 사용했다면 해당 함수의 코드를 보지 않고도 이해할 수 있다. 
	  - 어떤 코드에 주석을 남기고 싶다면, 주석 대신 함수를 만들고 함수의 이름으로 의도를 표현해보자. 
	- 사용할 수 있는 리팩토링 기술 
	  - 99%는 함수 추출하기(Extract Function)로 해결할 수 있다. 
	  - 함수로 분리하면서 해당 함수로 전달해야 할 매개변수가 많아진다면 다음과 같은 리팩토링을 
	    고려해볼 수 있다. 
		- 임시 변수를 질의 함수로 바꾸기(Replace Temp with Query)
		- 매개변수 객체 만들기 (Introduce Parameter Object)
		- 객체 통째로 넘기기(Preserve Whole Object)
	- 조건문 분해하기(Decompose Conditional)를 사용해 조건문을 분리할 수 있다. 
	- 같은 조건으로 여러개의 Switch 문이 있다면, 조건문을 다형성으로 바꾸기 
	  (Replace Conditional with Polymorphism)을 사용할 수 있다. 
	- 반복문 안에서 여러 작업을 하고 있어서 하나의 메소드로 추출하기 어렵다면, 
	  반복문 쪼개기(Split Loop)를 적용할 수 있다. 
```

### 리팩토링7. 임시 변수를 질의 함수로 바꾸기 
```
  임시 변수를 질의 함수로 바꾸기(Replace Temp with Query)
    - 변수를 사용하면 반복해서 동일한 식을 계산하는 것을 피할 수 있고, 이름을 사용해
	  의미를 표현할 수도 있다. 
	- 긴 함수를 리팩토링할 때, 그러한 임시 변수를 함수로 추출하여 분리한다면 빼낸 함수로 
	  전달해야 할 매개변수를 줄일 수 있다.
```

### 리팩토링8. 매개변수 객체 만들기
```
  매개변수 객체 만들기 (Introduce Parameter Object)
    - 같은 매개변수들이 여러 메소드에 걸쳐 나타난다면 그 매개변수들을 묶은 자료 구조를 
	  만들 수 있다. 
	- 그렇게 만든 자료구조는: 
	  - 해당 데이터간의 관계를 보다 명시적으로 나타낼 수 있다. 
	  - 함수에 전달할 매개변수 개수를 줄일 수 있다. 
	  - 도메인을 이해하는데 중요한 역할을 하는 클래스로 발전할 수도 있다. 
```