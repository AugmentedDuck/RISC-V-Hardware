import chisel3._;
import chisel3.util._;

class FileReader extends Module {
  val io = IO(new Bundle {
    val programCounter = Input(UInt())
    
    val operation = Output(UInt(32.W))
  })

  io.operation := 0.U
}
