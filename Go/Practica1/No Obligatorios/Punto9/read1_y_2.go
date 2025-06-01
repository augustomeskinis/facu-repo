package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
)

func read1() {
	fmt.Println("Input text: ")
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()
	err := scanner.Err()
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("Read line: %s-\n", scanner.Text())
}

func read2() {
	fmt.Println("Input text: ")
	reader := bufio.NewReader(os.Stdin)
	line, err := reader.ReadString('\n')
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("Read line: %s-\n", line)
}

func jose() {
	read1()
}
