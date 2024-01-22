package main.java.Exam_9_April_2022.FairyShop.models;

public class ShopImpl implements Shop {
    public ShopImpl() {
    }

    @Override
    public void craft(Present present, Helper helper) {
        //The helper starts crafting the present.
        // This is only possible if the helper has energy and an instrument that isn't broken.
        Instrument instrument = helper.getInstruments().stream()
                .filter(e -> !e.isBroken()).findFirst().orElse(null);
        while (helper.canWork() && instrument != null && !present.isDone()) {
            //Keep working until the present is done or the helper has energy (and instruments to use).
            helper.work();
            instrument.use();
            present.getCrafted();
            //If at some point the power of the current instrument reaches or drops below 0,
            // meaning it is broken, then the helper should take the next instrument from its collection,
            // if it has any left.
            if (instrument.isBroken()) {
                instrument = helper.getInstruments().stream()
                        .filter(e -> !e.isBroken()).findFirst().orElse(null);
            }
        }
    }
}
