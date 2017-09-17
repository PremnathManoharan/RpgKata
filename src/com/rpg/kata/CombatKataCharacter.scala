package com.rpg.kata

trait AnyCharacter {
  val uniquePlayerId  : String
  val damageRateBeforeThreshold: Double
  val damageRateAfterThreshold : Double
  val damageValue:Int
  val THRESHOLD_HEALTH: Double
  val recoveryValue:Int
  var currentHealth:Double
  val MAX_HEALTH : Double
  val MIN_HEALTH : Double
  var level: Int

  def promoteNextLevel

  //  val recoveryTime:Int

  def isDead: Boolean = if(currentHealth <= MIN_HEALTH) true else false
  def isAlive(): Boolean = if (currentHealth >= MIN_HEALTH) true else false

  def isAliveWithFullPower: Boolean= if (currentHealth >= MAX_HEALTH) true else false

  def isAliveWithBelowThreshold: Boolean = if (currentHealth < THRESHOLD_HEALTH) true else false


  def resetHealth = {currentHealth = MAX_HEALTH }
  def applyDamage
  def applyHealing

}
abstract class CharacterCategoryA extends AnyCharacter{

  override val MAX_HEALTH = 2000.0
  override val MIN_HEALTH = 10.0
  override val THRESHOLD_HEALTH = 1000.0
  override val damageRateBeforeThreshold = 1.0
  override val damageRateAfterThreshold = 1.5
//  override val recoveryTime: Int = 30
  override val damageValue = 200
  val recoveryValue=200
  var additionalHealingCount:Int
  val thresholdAdditionalHealingCount:Int = 10



  override def applyDamage() = {
    if (!isDead && isAliveWithBelowThreshold) {
      currentHealth = currentHealth - damageValue*damageRateAfterThreshold
    } else if (!isDead) {
      currentHealth = currentHealth - damageValue*damageRateBeforeThreshold
    }
    if(isDead) println("player dead")
  }
  override def promoteNextLevel()= {
    if (additionalHealingCount >= thresholdAdditionalHealingCount) {
      level=level+1;
      additionalHealingCount=0;
    }
  }
  override def applyHealing()  = {
    if(isAliveWithFullPower) {
      additionalHealingCount=additionalHealingCount+1
      promoteNextLevel
    } else if(!isDead) {
      currentHealth = currentHealth+recoveryValue
    }
  }


}
//abstract class CharacterCategoryB extends AnyCharacter{
//
//  override val MAX_HEALTH = 1000.0
//  override val MIN_HEALTH = 20.0
//  val THRESHOLD_HEALTH = 200.0
//  override val damageRateBeforeThreshold = 1.0
//  override val damageRateAfterThreshold = 1.2
//  override val damageValue = 100
////  override val recoveryTime: Int = 10
//
//  override def isDead: boolean = if(currentHealth <= MIN_HEALTH) true else false
//
//  override protected def applyDamage(CharacterCategoryB : a): CharacterCategoryB = {
//    if (!isDead && a.isAliveWithBelowThreshold) {
//      a.currentHealth = a.currentHealth - damageValue*damageRateAfterThreshold
//    } else if (!isDead) {
//      a.currentHealth = a.currentHealth - damageValue*damageRateBeforeThreshold
//    }
//    return a
//  }
//}

case class CombatKataCharacterA (name: String) extends CharacterCategoryA {

  override var currentHealth: Double = MAX_HEALTH

  override val uniquePlayerId: String = java.util.UUID.randomUUID.toString

//  override val currentHealth:Double = 0
  override var additionalHealingCount: Int = 0
  override var level =1
}
object CombatKataCharacterA{
  def apply(name: String) = new CombatKataCharacterA(name)
}

object playGame {
  def main (args: Array[String]): Unit = {
    println("Hello world")
    val playerPrem = new CombatKataCharacterA("Prem")
    println(playerPrem.currentHealth)
    println(playerPrem.level)
    playerPrem.applyDamage()
    println(playerPrem.currentHealth)
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    playerPrem.applyHealing()
    println(playerPrem.currentHealth)
    println(playerPrem.level)
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    playerPrem.applyDamage()
    println(playerPrem.currentHealth)
    println(playerPrem.level)
  }
}

//case class CombatKataCharacterA extends CharacterCategoryA (val name: String,val level: Int,val health: Double){
//    def getLevel() : Int = level
//    def getName() : String= name
//    def isDead() : Boolean = {this.health <= Character.MIN_HEALTH}
//    def isSame(other : Character) : Boolean = this.name ==other.name
//    def receiveDamage(amount : Double) : Character = Character(name, level, health - amount)
//    def heal(amount : Double) : Character = {
//      if (this.isDead())
//        this
//      if (this.health + amount > Character.MAX_HEALTH)
//        Character(name, level, Character.MAX_HEALTH);
//      Character(name, level, this.health + amount);
//    }
//  }


//  object Character {
//    val MAX_HEALTH = 1000.0
//    val MIN_HEALTH = 0
//    val FULL_HEALTH : Character = Character("Player1", 1, MAX_HEALTH);
//    val HALF_HEALTH : Character = Character("Player2", 1, MAX_HEALTH/2);
//    def main(args: Array[String]): Unit = {
//      println("Hello")
//      println(FULL_HEALTH.receiveDamage(200.0).heal(100))
//      println(FULL_HEALTH.receiveDamage(1000).isDead)
//      println(FULL_HEALTH.receiveDamage(1000).heal(100))
//      println(FULL_HEALTH.isSame(HALF_HEALTH))
//    }
//}
