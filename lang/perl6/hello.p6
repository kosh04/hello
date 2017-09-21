#!/usr/local/bin/perl6

# Usage:
#   hello.p6 [--greeting=<Str>] [--traditional (False True)]

my $Hello = "Hello, World!";
my $HelloTraditional = "hello, world";

sub MAIN(Str :$greeting = $Hello, Bool :$traditional){
    say $HelloTraditional if $traditional;
    say $greeting if not $traditional;
}
