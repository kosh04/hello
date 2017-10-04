#!/usr/local/bin/perl6

# Usage:
#   hello.p6
#   hello.p6 [--greeting=<Str>]
#   hello.p6 [--traditional (False True)]

my $Hello = "Hello, world!";
my $HelloTraditional = "hello, world";

sub hello(Str $greeting) {
    say $greeting
}

multi MAIN() {
    hello($Hello)
}

multi MAIN(Str :$greeting = $Hello) {
    hello($greeting)
}

multi MAIN(Bool :$traditional) {
    hello($HelloTraditional)
}

#sub USAGE () {}
