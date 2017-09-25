#!/usr/bin/env python

import argparse

def main():
    parser = argparse.ArgumentParser(description="Hello program")
    parser.add_argument("-g", "--greeting",
                        action="store",
                        default="Hello, world!",
                        metavar="TEXT",
                        help="Output text instead of the default greeting."),
    parser.add_argument("-t", "--traditional",
                        action="store_true",
                        default=False,
                        help="Output the traditional greeting message 'hello, world'.")
    parser.add_argument('--version', action='version', version='%(prog)s 1.0')

    opt = parser.parse_args()

    text = "hello, world" if opt.traditional else opt.greeting

    print(text)


if __name__ == '__main__': main()
