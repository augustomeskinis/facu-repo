package main

import "fmt"

func main() {
	/* integers */
	var zz int = 0
	var x int8 = 10
	var z int8 = x
	var y int8 = x + int8(1)
	const n = 5001
	const c int = 5001
	/* float */
	var e float32 = 6
	var f float32 = e
	fmt.Println(zz, x, z, y, n, c, e, f)
}
