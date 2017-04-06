public class Test {

        public static void main(String[] args) throws DustbinContentException {
                Test test = new Test();
                test.testInstantiatingGarbage();
                test.testInstantiatingPlasticGarbage();
                test.testInstantiatingPaperGarbage();
                test.testSqueezeOnPaperGarbage();
                test.testCleanOnPlasticGarbage();
                test.testDustbinOutPaperGarbage();
                test.testDustbinOutPlasticGarbage();
                test.testDustbinOutHouseWasteGarbage();
                test.testDustbinOutUnsqueezedPaperGarbage();
                test.testDustbinOutUncleanedPlasticGarbage();
                test.testEmptyContentsOnDustbin();
                // Uncomment this method. What happens when you try the tests?
                //test.testDustbinOutSomethingWhichIsNotAGarbage();
        }

        public Test() {
                getClass().getClassLoader().setDefaultAssertionStatus(true);
        }

        public void testInstantiatingGarbage() {
                String garbageName = "Rotten food from the fridge";
                Garbage garbage = new Garbage(garbageName);
                assert garbageName.equals(garbage.getName());
        }

        public void testInstantiatingPlasticGarbage() {
                String garbageName = "Empty coke bottle";
                PlasticGarbage plasticGarbage = new PlasticGarbage(garbageName, false);
                assert garbageName.equals(plasticGarbage.getName());
                assert !plasticGarbage.isClean();
        }

        public void testInstantiatingPaperGarbage() {
                String garbageName = "An empty milk carton";
                PaperGarbage paperGarbage = new PaperGarbage(garbageName, false);
                assert garbageName.equals(paperGarbage.getName());
                assert !paperGarbage.isSqueezed();
        }

        public void testSqueezeOnPaperGarbage() {
                PaperGarbage paperGarbage = new PaperGarbage("Paper garbage", false);
                paperGarbage.squeeze();
                assert paperGarbage.isSqueezed();
        }

        public void testCleanOnPlasticGarbage() {
                PlasticGarbage plasticGarbage = new PlasticGarbage("Plastic garbage", false);
                plasticGarbage.clean();
                assert plasticGarbage.isClean();
        }
;
        public void testDustbinOutPaperGarbage() throws DustbinContentException {
                PaperGarbage paperGarbage = new PaperGarbage("Paper garbage", true);
                Dustbin dustbin = new Dustbin("red");
                dustbin.throwOutGarbage(paperGarbage);
                assert dustbin.getPaperContent().length == 1;
                assert dustbin.getPlasticContent().length == 0;
                assert dustbin.getHouseWasteContent().length == 0;
        }

        public void testDustbinOutPlasticGarbage() throws DustbinContentException {
                PlasticGarbage plasticGarbage = new PlasticGarbage("Plastic garbage", true);
                Dustbin dustbin = new Dustbin("red");
                dustbin.throwOutGarbage(plasticGarbage);
                assert dustbin.getPaperContent().length == 0;
                assert dustbin.getPlasticContent().length == 1;
                assert dustbin.getHouseWasteContent().length == 0;
        }

        public void testDustbinOutHouseWasteGarbage() throws DustbinContentException {
                Garbage garbage = new Garbage("House waste garbage");
                Dustbin dustbin = new Dustbin("red");
                dustbin.throwOutGarbage(garbage);
                assert dustbin.getPaperContent().length == 0;
                assert dustbin.getPlasticContent().length == 0;
                assert dustbin.getHouseWasteContent().length == 1;
        }

        public void testDustbinOutUnsqueezedPaperGarbage() {
                PaperGarbage paperGarbage = new PaperGarbage("Paper garbage", false);
                Dustbin dustbin = new Dustbin("red");
                boolean threw = false;
                try {
                        dustbin.throwOutGarbage(paperGarbage);
                } catch (DustbinContentException ex) {
                        threw = true;
                }
                assert threw;
        }

        public void testDustbinOutUncleanedPlasticGarbage() {
                PlasticGarbage plasticGarbage = new PlasticGarbage("Plastic garbage", false);
                Dustbin dustbin = new Dustbin("red");
                boolean threw = false;
                try {
                        dustbin.throwOutGarbage(plasticGarbage);
                } catch (DustbinContentException ex) {
                        threw = true;
                }
                assert threw;
        }

        public void testEmptyContentsOnDustbin() throws DustbinContentException {
                Garbage[] garbageList = new Garbage[] {
                    new PlasticGarbage("Plastic garbage", true),
                    new PaperGarbage("Paper garbage", true),
                    new Garbage("House waste garbage")
                };

                Dustbin dustbin = new Dustbin("red");
                for (Garbage garbage : garbageList) {
                    dustbin.throwOutGarbage(garbage);
                }

                dustbin.emptyContents();

                assert dustbin.getPaperContent().length == 0;
                assert dustbin.getPlasticContent().length == 0;
                assert dustbin.getHouseWasteContent().length == 0;
        }

        // Uncomment this method. What happens when you try the tests?
        //public void testDustbinOutSomethingWhichIsNotAGarbage() {
        //        String myString = "This is NOT a garbage, right???";
        //        Dustbin dustbin = new Dustbin("red");
        //        boolean threw = false;
        //        try {
        //                dustbin.throwOutGarbage(myString);
        //        } catch (DustbinContentException ex) {
        //                threw = true;
        //        }
        //        assert threw;
        //}
}
