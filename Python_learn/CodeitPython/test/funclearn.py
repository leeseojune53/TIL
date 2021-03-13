print("이름을 입력하세요 : ")
name = input()
print("월급을 입력하세요 : ")
a = int(input())
print("금리를 입력하세요 : ")
b = float(input()) / 100

C = 15.4

result = ((a/2) * b) * 12

print(f'{name}씨의 정기예금 만기 금액은 {int(a / 2 * 12 + result):,}')

