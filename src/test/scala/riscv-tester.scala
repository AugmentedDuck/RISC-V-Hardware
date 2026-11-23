import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class RiscVTester extends AnyFlatSpec with ChiselScalatestTester {
  "RISC-V test" should "pass" in {
    test(new riscv(20)).withAnnotations(Seq(WriteVcdAnnotation, VerilatorBackendAnnotation)) { c =>
    
    }
  }
}
