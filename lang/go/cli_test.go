package main

import (
	"bytes"
	"os"
	"testing"
)

func TestHello(t *testing.T) {
	cases := []struct {
		args []string
		want string
	}{
		{[]string{"hello"}, GreetModern + "\n"},
		{[]string{"hello", "-t"}, GreetTraditional + "\n"},
		{[]string{"hello", "-g", "HELLO"}, "HELLO\n"},
	}
	for _, tc := range cases {
		stdout, stderr := new(bytes.Buffer), new(bytes.Buffer)
		cli := &CLI{outStream: stdout, errStream: stderr}

		status := cli.Run(tc.args)

		if status != ExitCodeOK {
			t.Errorf("ExitCode=%d, want %d", status, ExitCodeOK)
		}

		if stdout.String() != tc.want {
			t.Errorf("Output=`%v`, want `%s`", stdout, tc.want)
		}
	}
}

func newCLI() *CLI {
	return &CLI{
		outStream: os.Stdout,
		errStream: os.Stderr,
	}
}

func ExampleHello() {
	cli := newCLI()
	cli.Run([]string{"hello"})
	// Output: Hello, World!

}

func ExampleOptGreeting() {
	cli := newCLI()
	cli.Run([]string{"hello", "-g", "HELLO"})
	// Output: HELLO

}

func ExampleOptTraditional() {
	cli := newCLI()
	cli.Run([]string{"hello", "-t"})
	// Output: hello, world
}
