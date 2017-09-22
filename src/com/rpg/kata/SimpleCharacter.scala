package com.rpg.kata

case class SimpleCharacter (val name: String, val level: Int, val health: Double) {

  def getLevel() : Int = level
  def getName() : String= name
  def isDead() : Boolean = {this.health <= SimpleCharacter.MIN_HEALTH}
  def isSame(other : SimpleCharacter) : Boolean = this.name ==other.name
  def receiveDamage(amount : Double) : SimpleCharacter = SimpleCharacter(name, level, health - amount)
  def heal(amount : Double) : SimpleCharacter = {
    if (this.isDead())
      this
    if (this.health + amount > SimpleCharacter.MAX_HEALTH)
      SimpleCharacter(name, level, SimpleCharacter.MAX_HEALTH);
    SimpleCharacter(name, level, this.health + amount);
  }
}


object SimpleCharacter {
  val MAX_HEALTH = 1000.0
  val MIN_HEALTH = 0
  val FULL_HEALTH : SimpleCharacter = SimpleCharacter("Player1", 1, MAX_HEALTH);
  val HALF_HEALTH : SimpleCharacter = SimpleCharacter("Player2", 1, MAX_HEALTH/2);
  def main(args: Array[String]): Unit = {
    println("Hello")
    println(FULL_HEALTH.receiveDamage(200.0).heal(100))
    println(FULL_HEALTH.receiveDamage(1000).isDead)
    println(FULL_HEALTH.receiveDamage(1000).heal(100))
    println(FULL_HEALTH.isSame(HALF_HEALTH))
  }


  def fullHealth(name: String,level: Int) : SimpleCharacter = SimpleCharacter(name, level, MAX_HEALTH)

}
