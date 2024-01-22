package main.java.Exam_9_April_2022.FairyShop.core;

import main.java.Exam_9_April_2022.FairyShop.common.ExceptionMessages;
import main.java.Exam_9_April_2022.FairyShop.models.*;
import main.java.Exam_9_April_2022.FairyShop.repositories.HelperRepository;
import main.java.Exam_9_April_2022.FairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

import static main.java.Exam_9_April_2022.FairyShop.common.ConstantMessages.*;


public class ControllerImpl implements Controller{
    private HelperRepository helperRepository;
    private PresentRepository presentRepository;
    private Shop shop;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
        this.shop = new ShopImpl();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper = null;
        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            //Creates a helper with the given name of the given type.
            default:
            //If the helper is invalid, throw an IllegalArgumentException with a message:
            //"Helper type doesn't exist!"
                throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }
        helperRepository.add(helper);
        //The method should return the following message:
        //"Successfully added {helperType} named {helperName}!"
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        //Creates an instrument with the given power and adds it to the collection of the helper.
        Helper helper = helperRepository.getModels().stream().filter(e -> e.getName().equals(helperName))
                .findFirst().orElse(null);
        if (helper != null){
            Instrument instrument = new InstrumentImpl(power);
            helper.addInstrument(instrument);
        }else {
            //If the helper doesn't exist, throw an IllegalArgumentException with a message:
            //"The helper you want to add an instrument to doesn't exist!"
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        //The method should return the following message:
        //"Successfully added instrument with power {instrumentPower} to helper {helperName}!"
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        //Creates a present with the provided name and required energy and adds it to the corresponding repository.
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);
        //The method should return the following message:
        //"Successfully added Present: {presentName}!"
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Present present = presentRepository.getModels().stream()
                .filter(e -> e.getName().equals(presentName))
                .findFirst().orElse(null);
        //You should start crafting the given present, by assigning helpers which are almost ready:
        //The helpers that you should select are the ones with energy above 50 units.
        List<Helper> helpers = helperRepository.getModels().stream()
                .filter(e -> e.getEnergy() > 50).collect(Collectors.toList());
        if (helpers.isEmpty()) {
            //If no helpers are ready, throw IllegalArgumentException with the following message:
            //"There is no helper ready to start crafting!"
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }
        //The suitable ones start working on the given present.
        int brokenInstruments = 0;
        for (Helper helper : helpers) {
            this.shop.craft(present, helper);
            List<Instrument> instruments = (List<Instrument>) helper.getInstruments();
            for (Instrument instrument : instruments) {
                if(instrument.isBroken()){
                    brokenInstruments++;
                }
            }
            if (present.isDone()){
                break;
            }
        }
        //After the work is done, you must return the following message, reporting whether the
        // present is done and how many total instruments have been broken in the process:
        StringBuilder text = new StringBuilder();
        String presentStatus = "not done";
        if (present.isDone()){
            presentStatus = "done";
        }
        //"Present {presentName} is {done/not done}. "
        text.append(String.format(PRESENT_DONE, presentName, presentStatus));
        //"{countBrokenInstruments} instrument/s have been broken while working on it!"
        text.append(String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments));
        return text.toString();
    }

    @Override
    public String report() {
        StringBuilder text = new StringBuilder();
        int craftedPresentsCount = presentRepository.getModels().stream().filter(e -> e.isDone())
                .collect(Collectors.toList()).size();
        //Returns information about crafted presents and helpers:
        //"{countCraftedPresents} presents are done!"
        text.append(String.format("%d presents are done!", craftedPresentsCount));
        text.append(System.lineSeparator());
        //"Helpers info:"
        text.append("Helpers info:");
        for (Helper helper : helperRepository.getModels()) {
            text.append(System.lineSeparator());
            //"Name: {helperName1}"
            text.append(String.format("Name: %s", helper.getName()));
            //"Energy: {helperEnergy1}"
            text.append(System.lineSeparator());
            text.append(String.format("Energy: %d", helper.getEnergy()));

            int brokenInstrumentsCount = helper.getInstruments().stream().filter(e -> !e.isBroken())
                    .collect(Collectors.toList()).size();
            //"Instruments: {countInstruments} not broken left"
            text.append(System.lineSeparator());
            text.append(String.format("Instruments: %d not broken left", brokenInstrumentsCount));
        }
        return text.toString();
    }
}
