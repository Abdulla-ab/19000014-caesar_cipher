import scala.io.StdIn.readInt
import scala.util.control.Breaks._

object CC extends App{

  val a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

  val encryption = (character:Char, key:Int, alph:String) => alph((alph.indexOf(character.toUpper) + key) % alph.size)

  val decryption = (character:Char, key:Int, alph:String) => alph((alph.indexOf(character.toUpper)- key) % alph.size)

  val cipher=(algo:(Char,Int,String)=> Char, s:String, key:Int, alph:String) => s.map(algo(_, key, alph))

  val y = "RANDOM"
  val ctxt = cipher(encryption, y, 5, a)
  val cpattern = cipher(decryption, ctxt, 5, a)

  println("encode   : "+ ctxt)
  println("decode   : "+ cpattern)
}