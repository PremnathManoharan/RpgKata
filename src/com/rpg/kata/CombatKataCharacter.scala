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
  //  val recoveryTime:Int
  def promoteNextLevel



  def isDead: Boolean = if(currentHealth <= MIN_HEALTH) true else false
  def isAlive(): Boolean = if (currentHealth >= MIN_HEALTH) true else false
  def isAliveWithFullPower: Boolean= if (currentHealth == MAX_HEALTH) true else false
  def isAliveWithBelowThreshold: Boolean = if (currentHealth < THRESHOLD_HEALTH) true else false


  def resetHealth = {currentHealth = MAX_HEALTH }
  def applyDamage
  def applyHealing

  def hit(a:AnyCharacter) : AnyCharacter = { a.applyDamage;a }

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
      additionalHealingCount=0
    }
  }


}
abstract class CharacterCategoryB extends AnyCharacter {

  override val MAX_HEALTH = 1000.0
  override val MIN_HEALTH = 20.0
  val THRESHOLD_HEALTH = 200.0
  override val damageRateBeforeThreshold = 1.0
  override val damageRateAfterThreshold = 1.2
  override val damageValue = 100
  //  override val recoveryTime: Int = 10
  val recoveryValue=200
  var additionalHealingCount:Int
  val thresholdAdditionalHealingCount:Int = 10

  override def isDead: Boolean = if (currentHealth <= MIN_HEALTH) true else false
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
      additionalHealingCount=0
    }
  }


}

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
    println("Let's Begin the Play")
    val playerPrem = new CombatKataCharacterA("Prem")
    val playerVJ = new CombatKataCharacterA("VJ")
    println(s"Current PlayerHealth "+playerPrem.currentHealth)
    println(" Level   "+playerPrem.level)
    playerPrem.applyDamage()
    println("Player been Hit "+playerPrem.currentHealth)
    println("Heeling now")
    Thread.sleep(60)
    for (i <- 1 to 3) {
      playerPrem.applyHealing()
    }
    println("Moved to next level "+playerPrem.level)
    println("Player Current Health "+playerPrem.currentHealth)

    println("VJ levels"+playerVJ.level)
    println("VJ Health"+playerVJ.MAX_HEALTH)
    playerPrem.hit(playerVJ )
    println("VJ levelsAfter HIT"+playerVJ.level)
    println("VJ Health After HIT"+playerVJ.MAX_HEALTH)
  }
}

