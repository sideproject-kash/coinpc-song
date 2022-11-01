# Coin Price Compare 

## todo
1. 빗썸 연동. (가격 가져오기)
2. 업비트 연동. (가격 가져오기)
3. 라인 연동 (message 보내기)
4. telegram 연동 (message 보내기)

## 배포하기
- deploy dir의 파일 4개 (appspec.yml, jar, kill.sh, run.sh)를 압축해서 Amazone s3에 올린다.

## ref
upbit: https://docs.upbit.com/reference/ticker%ED%98%84%EC%9E%AC%EA%B0%80-%EC%A0%95%EB%B3%B4
bithumb:

## backlog
[] log파일 rolling 및 파일 위치 설정
[] 배포 파일에 config파일도 같이 만들어서 config파일 읽어서 java option, server port, jar이름 지정할 수 있도록 수정하기