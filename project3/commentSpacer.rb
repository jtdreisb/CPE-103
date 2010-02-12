#! /usr/env ruby


puts ARGV[0]
File.open(ARGV[0], "r").each { |line|
         line.sub!(/^(.*\/\*.*)/, "\n\n"+'\1')
         print line
         }
