package com.rpg.kata

case class AttackResult(attacker: Character,attacked: Character)
case class HealResult(healed: Character)
class PlayGame {
  object PlayGame {

    def attack(attacker: Character ,attacked: Character,damageAmount : Double) : AttackResult={

      if (attacker.isSame(attacked)) throw new Nothing("Attacker and attacked characters must be different")
      AttackResult(attacker, attacked.receiveDamage(applyDamageBonus(attacker, attacked, damageAmount)))
    }

    def applyDamageBonus(attacker: Character, attacked: Character, damageAmount: Double): Double = {
      if (attacked.getLevel - attacker.getLevel <= -5) return damageAmount * 1.5
      if (attacked.getLevel - attacker.getLevel >= 5) return damageAmount * 0.5
      damageAmount
    }

    def heal(theChar: Character, amountToBeHealed: Double) = HealResult(theChar.heal(amountToBeHealed))
  }

}
