package main.java.Exam_19_December_2022.MagicGame.core;

import main.java.Exam_19_December_2022.MagicGame.models.magicians.BlackWidow;
import main.java.Exam_19_December_2022.MagicGame.models.magicians.Magician;
import main.java.Exam_19_December_2022.MagicGame.models.magicians.Wizard;
import main.java.Exam_19_December_2022.MagicGame.models.magics.BlackMagic;
import main.java.Exam_19_December_2022.MagicGame.models.magics.Magic;
import main.java.Exam_19_December_2022.MagicGame.models.magics.RedMagic;
import main.java.Exam_19_December_2022.MagicGame.models.region.Region;
import main.java.Exam_19_December_2022.MagicGame.models.region.RegionImpl;
import main.java.Exam_19_December_2022.MagicGame.repositories.MagicRepositoryImpl;
import main.java.Exam_19_December_2022.MagicGame.repositories.MagicianRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static main.java.Exam_19_December_2022.MagicGame.common.ExceptionMessages.*;
import static main.java.Exam_19_December_2022.MagicGame.common.OutputMessages.SUCCESSFULLY_ADDED_MAGIC;
import static main.java.Exam_19_December_2022.MagicGame.common.OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN;

public class ControllerImpl implements Controller {
    //magics - MagicRepositoryImpl
    private MagicRepositoryImpl magics;
    //magicians – MagicianRepositoryImpl
    private MagicianRepositoryImpl magicians;
    //region - Region
    private Region region;


    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        // Valid types are "RedMagic" and "BlackMagic".
        Magic magic = null;
        switch (type) {
            case "RedMagic":
                magic = new RedMagic(name, bulletsCount);
                break;
            case "BlackMagic":
                magic = new BlackMagic(name, bulletsCount);
                break;
            default:
                //If the Magic type is invalid, you have to
                // throw an IllegalArgumentException with the following message: "Invalid magic type."
                throw new IllegalArgumentException(INVALID_MAGIC_TYPE);
        }
        //Adds a Magic and adds it to the MagicRepositoryImpl.
        this.magics.addMagic(magic);
        //If the Magic is added successfully, the method should return the following String:
        //· "Successfully added magic {magicName}."
        return String.format(SUCCESSFULLY_ADDED_MAGIC, magic.getName());
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magic magic = this.magics.findByName(magicName);
        if (magic == null) {
            //If the magic is not found
            // throw NullPointerException with a message: "Magic cannot be found!"
            throw new NullPointerException(MAGIC_CANNOT_BE_FOUND);
        }
        // Valid types are: "Wizard" and "BlackWidow".
        Magician magician = null;
        switch (type) {
            case "Wizard":
                magician = new Wizard(username, health, protection, magic);
                break;
            case "BlackWidow":
                magician = new BlackWidow(username, health, protection, magic);
                break;
            default:
                //If the magician type is invalid,
                // throw an IllegalArgumentException with a message: "Invalid magician type!"
                throw new IllegalArgumentException(INVALID_MAGICIAN_TYPE);
        }
        //Creates a Magician of the given type and adds it to the MagicianRepositoryImpl.
        this.magicians.addMagician(magician);
        //The method should return the following String if the operation is successful:
        //· "Successfully added magician {username}."
        return String.format(SUCCESSFULLY_ADDED_MAGICIAN, magician.getUsername());
    }

    @Override
    public String startGame() {
        //The game starts with all magicians that are alive! Returns the result from the start() method.
        return this.region.start(this.magicians.getData());
    }

    @Override
    public String report() {
        List<Magician> sortedMagicians = this.magicians.getData().stream()
                .sorted(Comparator.comparing(Magician::getHealth)
                        .thenComparing(Magician::getUsername)
                        .thenComparing(e -> e.getClass().getSimpleName()))
                .collect(Collectors.toList());
        StringBuilder text = new StringBuilder();
        //Returns information about each magician separated with a new line.
        for (int i = 0; i< sortedMagicians.size();i++) {
            if(i<sortedMagicians.size()-1) {
                text.append(sortedMagicians.get(i).toString());
                text.append(System.lineSeparator());
            } else {
                text.append(sortedMagicians.get(i).toString());
            }
        }
        // Order then by health descending, then by username alphabetically,
        // them by type alphabetically. You can use the overridden .toString() Magician method.
        //"{magician type}: {magician username}"
        //"Health: {magician health}"
        //"Protection: {magician protection}"
        //"Magic: {magician magic name}"
        //Note: Use System.lineSeparator() for a new line and don't forget to trim if you use StringBuilder.
        return text.toString();
    }
}
