#!/usr/bin/env ruby

require 'optparse'

text = "Hello, World!"

OptionParser.new do |opt|
  opt.banner = "Usage: #{opt.program_name} [options]"
  opt.version = "1.0"

  opt.on("-g", "--greeting=TEXT") {|newtext|
    text = newtext
  }
  opt.on("-t", "--traditional") {
    text = "hello, world"
  }

  opt.parse!(ARGV)
end

puts text
