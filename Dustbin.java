import java.util.ArrayList;

public class Dustbin {

    private String color;
    ArrayList<PaperGarbage> paperContent = new ArrayList<PaperGarbage>();
    ArrayList<PlasticGarbage> plasticContent = new ArrayList<PlasticGarbage>();
    ArrayList<Garbage> houseWasteContent = new ArrayList<Garbage>();

    public Dustbin(String color) {
	this.color = color;
	this.paperContent = paperContent;
	this.plasticContent = plasticContent;
	this.houseWasteContent = houseWasteContent;
    }

    public void throwOutGarbage(Garbage garbage) throws DustbinContentException {

	if (garbage instanceof PlasticGarbage) {
	    PlasticGarbage plasticGarbage = (PlasticGarbage) garbage;
	    if (plasticGarbage.isClean() == true) {
		plasticContent.add(plasticGarbage);
	    }
	    else {
	        throw new DustbinContentException("Clean it befora throw out!");
	    }
	}
	else if (garbage instanceof PaperGarbage) {
	    PaperGarbage paperGarbage = (PaperGarbage) garbage;
	    if (paperGarbage.isSqueezed() == true) {
		paperContent.add(paperGarbage);
	    }
	}
	else if (garbage instanceof Garbage) {
	    houseWasteContent.add(garbage);
	}
    }

    public PaperGarbage[] getPaperContent() {
	return (PaperGarbage[]) paperContent.toArray();
    }

    public PlasticGarbage[] getPlasticContent() {
	return (PlasticGarbage[]) plasticContent.toArray();
    }

    public Garbage[] getHouseWasteContent() {
	return (Garbage[]) houseWasteContent.toArray();
    }

    public void emptyContents() {
	paperContent = null;
	plasticContent = null;
	houseWasteContent = null;
    }
}
