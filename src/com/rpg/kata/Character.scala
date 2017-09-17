package com.rpg.kata

case class Character (val name: String,val level: Int,val health: Double) {

  def getLevel() : Int = level
  def getName() : String= name
  def isDead() : Boolean = {this.health <= Character.MIN_HEALTH}
  def isSame(other : Character) : Boolean = this.name ==other.name
  def receiveDamage(amount : Double) : Character = Character(name, level, health - amount)
  def heal(amount : Double) : Character = {
    if (this.isDead())
      this
    if (this.health + amount > Character.MAX_HEALTH)
      Character(name, level, Character.MAX_HEALTH);
    Character(name, level, this.health + amount);
  }
}


object Character {
  val MAX_HEALTH = 1000.0
  val MIN_HEALTH = 0
  val FULL_HEALTH : Character = Character("Player1", 1, MAX_HEALTH);
  val HALF_HEALTH : Character = Character("Player2", 1, MAX_HEALTH/2);
  def main(args: Array[String]): Unit = {
    println("Hello")
    println(FULL_HEALTH.receiveDamage(200.0).heal(100))
    println(FULL_HEALTH.receiveDamage(1000).isDead)
    println(FULL_HEALTH.receiveDamage(1000).heal(100))
    println(FULL_HEALTH.isSame(HALF_HEALTH))
  }


  def fullHealth(name: String,level: Int) : Character = Character(name, level, MAX_HEALTH)

}
