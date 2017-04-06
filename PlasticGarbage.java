public class PlasticGarbage extends Garbage {

    private Boolean isClean;

    public PlasticGarbage(String garbageName, Boolean isClean) {
        super(garbageName);
	this.isClean = isClean;
    }

    public void clean() {
	this.isClean = true;
    }

    public boolean isClean() {
	return isClean;
    }

}


