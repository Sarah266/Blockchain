# Java로 BlockChain 만들기

> :bulb: gson-2.6.2.jar 파일 다운로드


## BlockChain
블록체인은 누구라도 임의로 수정할 수 없고 누구나 변경의 결과를 열람할 수 있는 분산 컴퓨팅 기술 기반의 원장 관리 기술<br><br>

블록체인의 각 블록은 자신의 Digital Signature를 가지고 있고, 이전 블록의 Digital Signature로 포함하고 있다.

#### Hash=Digital Signature

## Hash
다양한 데이터를 특정한 함수를 통해 고정된 길이의 출력값으로 변환하는 방법<br><br>

Hash는 데이터의 무결성을 위해 존재!! -> 블록 속 데이터가 원본의 상태에서 변형되지 않았다는 것을 증명하기 때문

비트코인에서는 SHA256 해시를 사용

## Block.java
블록체인을 구성하는 Block 클래스 생성<br><br>

applySHA256을 사용해 hash, prevHash, data, timeStamp, nonce 값을 지닌 hash 블록 만들기

mineBlock() 메소드는 difficulty 파라미터를 취하며, 이 멤버가 풀어야할 자릿수의 숫자

## StringUtil.java
SHA256을 사용해야하기 때문에 utility 클래스 생성해 헬퍼 메소드(applySHA256) 만들기<br><br>

SHA256 알고리즘에 접근하기 위해 아래를 import
```
import java.security.MessageDigest;
```

## Chain.java
ArrayList에 저장된 블록을 Json 형태로 보기 위해 gson import
```
import com.google.gson.GsonBuilder;
```
Boolean 타입의 isChainValid() 메소드를 통해 블록체인의 무결성 검사
