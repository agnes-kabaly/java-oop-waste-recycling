public class PaperGarbage extends Garbage {

    boolean isSqueezed;

    public PaperGarbage(String garbageName, Boolean isSqueezed) {
        super(garbageName);
	this.isSqueezed = isSqueezed;
    }

    public void squeeze() {
	this.isSqueezed = true;
    }

    public boolean isSqueezed() {
	return isSqueezed;
    }

}
