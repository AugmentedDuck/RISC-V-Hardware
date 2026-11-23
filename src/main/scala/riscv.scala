import chisel3._
import chisel3.util._

class riscv() extends Module {
  val io = IO(new Bundle {

  })
}

// generate Verilog
object riscv extends App {
  emitVerilog(new VendingMachine())
}
