public class Main {
    public static void main(String[] args) {
        MyAraayList myAraayList = new MyAraayList();
        myAraayList.add("hay");
        myAraayList.add("I`am");
        myAraayList.add(13);
        myAraayList.add("ears OLD");
        Object[] c = {21, "Mike"};
        myAraayList.addAll(c);
        for (int i = 0; i < myAraayList.size(); i++) {
            Object object = myAraayList.get(i);
            System.out.print(object + " ");
        }
        System.out.println("\n");
        myAraayList.removed(3);
        myAraayList.add("Michelle");
        for (int i = 0; i < myAraayList.size(); i++) {
            Object object = myAraayList.get(i);
            System.out.print(object + " ");
        }


    }
}