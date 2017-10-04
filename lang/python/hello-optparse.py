#!/usr/bin/env python

# https://docs.python.jp/3/library/optparse.html
# バージョン 3.2 で撤廃: optparse モジュールは廃止予定であり、これ以上の開発は行われません。
# argparse モジュールを使用してください。

from optparse import OptionParser


def main():
    parser = OptionParser(version="%prog 1.0")
    parser.add_option("-g", "--greeting",
                      metavar="TEXT",
                      help="Output text instead of the default greeting."),
    parser.add_option("-t", "--traditional",
                      action="store_true",
                      help="Output the traditional greeting message 'hello, world'.")

    opts, args = parser.parse_args()

    text = opts.greeting or 'Hello, world!'
    if opts.traditional:
        text = "hello, world"

    print(text)


if __name__ == '__main__':
    main()
