package scala.cli.commands

import caseapp.*
import com.github.plokhotnyuk.jsoniter_scala.core.*
import com.github.plokhotnyuk.jsoniter_scala.macros.*

// format: off
final case class LoggingOptions(
  @Recurse
    verbosityOptions: VerbosityOptions = VerbosityOptions(),
  @Group("Logging")
  @HelpMessage("Decrease verbosity")
  @Tag(tags.implementation)
  @Name("q")
    quiet: Boolean = false,
  @Group("Logging")
  @Tag(tags.implementation)
  @HelpMessage("Use progress bars")
    progress: Option[Boolean] = None
) {
  // format: on

  lazy val verbosity = verbosityOptions.verbosity - (if (quiet) 1 else 0)
}

object LoggingOptions {
  implicit lazy val parser: Parser[LoggingOptions]            = Parser.derive
  implicit lazy val help: Help[LoggingOptions]                = Help.derive
  implicit lazy val jsonCodec: JsonValueCodec[LoggingOptions] = JsonCodecMaker.make
}
