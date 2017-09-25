package main

import (
	"flag"
	"fmt"
	"io"
)

// App info
var (
	Name    = "hello"
	Version = "0.1"
)

// Greeting Text
const (
	GreetModern      = "Hello, World!"
	GreetTraditional = "hello, world"
)

// Exit code
const (
	ExitCodeOK    int = 0
	ExitCodeError int = 1 + iota
)

// CLI is the command line object
type CLI struct {
	outStream, errStream io.Writer
}

func (cli *CLI) printHello(text string) {
	fmt.Fprintln(cli.outStream, text)
}

func (cli *CLI) printVersion() {
	v := fmt.Sprintf("%s version %s", Name, Version)
	fmt.Fprintln(cli.errStream, v)
}

// Run invokes the CLI with the given arguments
func (cli *CLI) Run(args []string) int {
	var opt struct {
		greeting    string
		traditional bool
		version     bool
	}

	// Define option flags
	flags := flag.NewFlagSet(Name, flag.ContinueOnError)
	flags.SetOutput(cli.errStream)

	flags.StringVar(&opt.greeting, "g", GreetModern, "Output texting instead of the default greeting")
	flags.BoolVar(&opt.traditional, "t", false, "Output the traditional greeting message 'hello, world'")
	flags.BoolVar(&opt.version, "v", false, "Print version")

	if err := flags.Parse(args[1:]); err != nil {
		return ExitCodeError
	}

	if opt.version {
		cli.printVersion()
		return ExitCodeOK
	}

	if opt.traditional {
		opt.greeting = GreetTraditional
	}

	cli.printHello(opt.greeting)

	return ExitCodeOK
}
