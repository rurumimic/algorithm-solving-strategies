# algorithm-solving-strategies

아무튼 알고리즘 스터디임. 

# Samsung Software Expert Academy

주의점이 있다. input.txt, output.txt라고 되어있는데

실제로는 그냥 cmd에서 input, output하듯 처리해야한다.

이것 때문에 엄청 헤맸는데 다른 분들은 그러지 마시길 ㅡㅡ!

# Baekjoon

12100번 문제를 풀면서 익힌 것들을 기록한다

Java로 하면서 다시금 확인한 요소다

### pass by value, pass by reference

모두들 저 두 개의 차이는 알거라 생각하고 넘긴다

문제를 풀면서 배열을 그대로 복사해야 하는 경우가 있었다

아무 생각없이 변수 복사하듯 우변항을 좌변항에 대입시켰다

배열 '값' 자체가 복사됐다 생각하고 문제를 풀었더니

엄청 해멨다

배열은 복사 시 pass by reference로 값을 넘긴다

같은 주소를 참조하는 바람에 복제된 배열의 값을 수정하면

원본도 같이 수정되는 것

현재는 loop돌려서 일일히 값을 넣어줬는데

이것말고 더 좋은방법이 있으면 밑에 수정하여 답을 달아 줬으면 한다
