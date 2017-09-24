#!/usr/bin/perl

use strict;
use warnings;
use Getopt::Long;
use Pod::Usage;
use feature qw(say);

MAIN: {
  my $text = "Hello, World!";

  my %options;
  GetOptions(\%options,
             'greeting=s' => \$text,
             'traditional',
             'help',
  ) or print_help(1);

  if ($options{'help'}) {
      print_help(0);
  }

  if ($options{'traditional'}) {
    $text = "hello, world";
  }

  say $text;

  exit 0;
}

sub print_help {
    return pod2usage(@_);
}

__END__

=head1 NAME

hello - Print "Hello World"

=head1 SYNOPSIS

hello.pl [options]

 Options:
    --greeting=<TEXT>	Set output message to TEXT
    --traditional	Output the traditional greeting message 'hello, world'
    --help		Print this message
=cut
