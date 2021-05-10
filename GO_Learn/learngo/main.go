package main

import (
	"fmt"
	"strings"
)

func multiply(a int, b int) int {
	return a * b
}

func lenAndUpper(name string) (length int, uppercase string) {
	defer fmt.Println("I'm done")
	length = len(name)
	uppercase = strings.ToUpper(name)
	defer fmt.Println("I'm done?")
	return
}

func superAdd(numbers ...int) int {
	defer fmt.Println("I'm done!")
	sum := 0
	for _, number := range numbers {
		sum += number
	}
	return sum
}

func canIDrink(age int) bool {
	if koreanAge := age + 2; koreanAge < 18 {
		return false
	}
	return true
}

func repeatMe(words ...string) {
	fmt.Println(words)
}

func main() {
	fmt.Println(canIDrink(18))
}
