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

// func canIDrink(age int) bool {
// 	if koreanAge := age + 2; koreanAge < 18 {
// 		return false
// 	}
// 	return true
// }

func pointer(){
	a := 2
	b := &a
	a = 100
	fmt.Println(&a, *b)
}

func array(){
	names := []string{"hi", "lee", "k"}
	fmt.Println(names)
}

func canIDrink(age int) bool {
	switch{
	case age < 18:
		return false
	case age == 18:
		return true
	case age > 50:
		return false
	default:
		return false
	}
}

func repeatMe(words ...string) {
	fmt.Println(words)
}

func main() {
	array()
}
