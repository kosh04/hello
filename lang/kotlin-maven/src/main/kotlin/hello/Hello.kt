package hello

import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options
import org.apache.commons.cli.ParseException

class Hello {
    var text        = "Hello, world!"
    val traditional = "hello, world"
    val version     = "Hello 1.0"

    fun print() = println(text)

    fun parseOptions(args: Array<String>) {
        if (args.contains("-v")) {
            text = version
        } else if (args.contains("-t")) {
            text = traditional
        } else if (args.contains("-g")) {
            val i = args.indexOf("-g") + 1
            text = if (i < args.size) args[i] else text
        }
    }
}

class Cli(args: Array<String>) {
    val opts = Options()
    val parser = DefaultParser()
    val cmd: CommandLine = try {
        setupOptions()
        parser.parse(opts, args)
    } catch (e: ParseException) {
        println(e)
        parser.parse(opts, arrayOf("--help")) // force display help
    }

    fun run() {
        if (cmd.hasOption("h")) {
            usage()
            return
        }

        val text = when {
            cmd.hasOption("g") -> cmd.getOptionValue("g")
            cmd.hasOption("t") -> Hello().traditional
            cmd.hasOption("v") -> Hello().version
            else -> Hello().text
        }
        println(text)
    }

    protected fun setupOptions() {
        opts.addOption(
            Option.builder("g").longOpt("greeting")
                .argName("text")
                .hasArg()
                .required(false)
                .desc("Output text instead of the default greeting")
                .build())

        opts.addOption(
            Option.builder("t").longOpt("traditional")
                .hasArg(false)
                .required(false)
                .desc("Output the traditional greeting message 'hello, world'")
                .build())

        opts.addOption(
            Option.builder("h").longOpt("help")
                .desc("display this help and exit")
                .build())

        opts.addOption(
            Option.builder("v")
                .longOpt("version")
                .desc("display version information and exit")
                .build())
    }

    protected fun usage() {
        val help = HelpFormatter()
        //help.setWidth(120)
        help.printHelp("hello", opts, true)
    }
}

fun main(args: Array<String>) {
    Cli(args).run()
}
