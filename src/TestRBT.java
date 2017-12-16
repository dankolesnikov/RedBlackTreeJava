public class TestRBT {

    public static void main(String[] args) {

        System.out.print("*** Red Black Tree (RBT) in Java ***\n");

        RedBlackTree waitingRoomRBT = new RedBlackTree();

        Patient alex = new Patient((int) (Math.random() * 100), "Alex");
        Patient danil = new Patient((int) (Math.random() * 100), "Danil");
        Patient minh = new Patient((int) (Math.random() * 100), "Minh");
        Patient laura = new Patient((int) (Math.random() * 100), "Laura");
        Patient alina = new Patient((int) (Math.random() * 100), "Alina");
        Patient pranav = new Patient((int) (Math.random() * 100), "Pranav");
        Patient ari = new Patient((int) (Math.random() * 100), "Ari");
        Patient heather = new Patient((int) (Math.random() * 100), "Heather");
        Patient casey = new Patient((int) (Math.random() * 100), "Casey");
        Patient katie = new Patient((int) (Math.random() * 100), "Katie");
        Patient jeff = new Patient((int) (Math.random() * 100), "Jeff");
        Patient andrew = new Patient((int) (Math.random() * 100), "Andrew");
        Patient kevin = new Patient((int) (Math.random() * 100), "Kevin");
        Patient isaac = new Patient((int) (Math.random() * 100), "Isaac");
        Patient vivian = new Patient((int) (Math.random() * 100), "Vivian");
        Patient ahmad = new Patient((int) (Math.random() * 100), "Ahmad");
        Patient vidya = new Patient((int) (Math.random() * 100), "Vidya");
        Patient mila = new Patient((int) (Math.random() * 100), "Mila");
        Patient dima = new Patient((int) (Math.random() * 100), "Dima");
        Patient mike = new Patient((int) (Math.random() * 100), "Dr. Mike");

        waitingRoomRBT.insert(alex);
        waitingRoomRBT.insert(danil);
        waitingRoomRBT.insert(minh);
        waitingRoomRBT.insert(laura);
        waitingRoomRBT.insert(alina);
        waitingRoomRBT.insert(pranav);
        waitingRoomRBT.insert(ari);
        waitingRoomRBT.insert(heather);
        waitingRoomRBT.insert(casey);
        waitingRoomRBT.insert(katie);
        waitingRoomRBT.insert(jeff);
        waitingRoomRBT.insert(kevin);
        waitingRoomRBT.insert(isaac);
        waitingRoomRBT.insert(vivian);
        waitingRoomRBT.insert(ahmad);
        waitingRoomRBT.insert(andrew);
        waitingRoomRBT.insert(vidya);
        waitingRoomRBT.insert(mila);
        waitingRoomRBT.insert(dima);
        waitingRoomRBT.insert(mike);

        System.out.print("\nTry to find Laura: ");
        waitingRoomRBT.searchPatient(laura.getPriority());
        System.out.print("Try to find Minh: ");
        waitingRoomRBT.searchPatient(minh.getPriority());

        System.out.print("Try to delete Pranav: ");
        waitingRoomRBT.deletePatient(pranav.getPriority());
        System.out.print("Try to delete Danil: ");
        waitingRoomRBT.deletePatient(danil.getPriority());

        System.out.print("Try to Sort Red Black Tree: ");
        waitingRoomRBT.sort();


    }
}
