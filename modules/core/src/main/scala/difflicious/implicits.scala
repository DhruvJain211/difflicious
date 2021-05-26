package difflicious
import difflicious.utils._

object implicits {

  implicit class DifferExts[T](val differ: Differ[T]) extends AnyVal {
    // FIXME: allow replacing the whole Differ at a path
    // FIXME: return self type :/
    def updateByStrPathOrFail(op: ConfigureOp, paths: String*): Differ[T] = {
      differ.configureRaw(ConfigurePath.of(paths: _*), op).unsafeGet
    }
  }

}
