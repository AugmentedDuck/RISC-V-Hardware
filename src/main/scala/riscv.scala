import chisel3._
import chisel3.util._

class riscv() extends Module {
  val io = IO(new Bundle {
    val realOperation = Output(Bool())
  })

  val fileReader = Module(new FileReader)
  val operation = RegInit(0.U(32.W))
  val programCounter = RegInit(0.U(10.W))

  val registers = RegInit(VecInit(Seq.fill(32)(0.U(32.W))))

  fileReader.io.programCounter := programCounter
  operation := fileReader.io.operation

  val rs1    = operation(19,15)
  val rs2    = operation(24,20)
  val rd     = operation(11,7) 
  val funct3 = operation(31,25)
  val funct7 = operation(14,12)

  val imm = 0.U(25.W)

  val opcode = operation(6,0)

  when(opcode === "b110011".U) {
    // R
    io.realOperation := true.B
  }.elsewhen (opcode === "b0010011".U) {
    // I1
    io.realOperation := true.B
  }.elsewhen (opcode === "b0000011".U) {
    // I2
    io.realOperation := true.B
  }.elsewhen (opcode === "b1100111".U) {
    // I3
    io.realOperation := true.B
  }.elsewhen (opcode === "b1110011".U) {
    // I4
    io.realOperation := true.B
  }.elsewhen (opcode === "b0100011".U) {
    // S
    io.realOperation := true.B
  }.elsewhen (opcode === "b1100011".U) {
    // B
    io.realOperation := true.B
  }.elsewhen (opcode === "b1101111".U) {
    // J
    io.realOperation := true.B
  }.elsewhen (opcode === "b0110111".U) {
    // U1
    io.realOperation := true.B
  }.elsewhen (opcode === "b0010111".U) {
    // U2
    io.realOperation := true.B
  }.otherwise {
    io.realOperation := false.B
  }
}

// generate Verilog
object riscv extends App {
  emitVerilog(new riscv())
}
