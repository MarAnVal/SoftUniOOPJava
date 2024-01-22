package main.java.Exam_19_December_2022.MagicGame.models.region;

import main.java.Exam_19_December_2022.MagicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {
        String wizardType = "Wizard";
        String blackWidowType = "BlackWidow";
        List<Magician> wizardToFight = getMagiciansToFight(magicians, wizardType);
        List<Magician> blackWidowToFight = getMagiciansToFight(magicians, blackWidowType);
        while (!wizardToFight.isEmpty() && !blackWidowToFight.isEmpty()) {
            int doneDamageFromWizards = 0;
            for (Magician magician : wizardToFight) {
                doneDamageFromWizards = magician.getMagic().fire();
                if (doneDamageFromWizards > 0) {
                    break;
                }
            }
            blackWidowToFight.get(0).takeDamage(doneDamageFromWizards);
            if (!blackWidowToFight.get(0).isAlive()) {
                wizardToFight = getMagiciansToFight(magicians, wizardType);
                blackWidowToFight = getMagiciansToFight(magicians, blackWidowType);
                continue;
            }
            int doneDamageFromBlackWidow = 0;
            for (Magician magician : blackWidowToFight) {
                doneDamageFromBlackWidow = magician.getMagic().fire();
                if (doneDamageFromBlackWidow > 0) {
                    break;
                }
            }
            wizardToFight.get(0).takeDamage(doneDamageFromBlackWidow);
            wizardToFight = getMagiciansToFight(magicians, wizardType);
            blackWidowToFight = getMagiciansToFight(magicians, blackWidowType);
        }
        //Separates the magicians into two types - Wizard and Black Widow.
        // The game continues until one of the teams is completely dead (all magicians have 0 health).
        // Both magician groups take turn shooting at each other – first are the Wizards,
        // then the Black Widows inflict damage equal to their bullet fired from their Magic.
        // Make sure the Magician has enough bullets before he/she tries to attack!
        //The damage they deal comes from each magic property of each Magician.
        //If Wizards win return "Wizards win!" otherwise return "Black widows win!"
        //TODO
        if (wizardToFight == null) {
            return "Black widows win!";
        }
        return "Wizards win!";
    }

    private static List<Magician> getMagiciansToFight(Collection<Magician> magicians, String magicianType) {
        return magicians.stream().filter(Magician::isAlive)
                .filter(e -> e.getClass().getSimpleName().equals(magicianType))
                .collect(Collectors.toList());
    }
}
