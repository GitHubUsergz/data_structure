package LinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode headHeroNode1 = new HeroNode(1,"宋江1","及时雨1");
        HeroNode headHeroNode2 = new HeroNode(2,"宋江2","及时雨2");
        HeroNode headHeroNode3 = new HeroNode(3,"宋江3","及时雨3");
        HeroNode headHeroNode4 = new HeroNode(4,"宋江4","及时雨4");

        singleLinkedList.addHero(headHeroNode1);
        singleLinkedList.addHero(headHeroNode2);
        singleLinkedList.addHero(headHeroNode3);
        singleLinkedList.addHero(headHeroNode4);
        singleLinkedList.display();
    }
}

class SingleLinkedList{
    private HeroNode heroNode = new HeroNode(0,"","");

    HeroNode demo = heroNode;//指针赋给demo

    public void addHero(HeroNode hero){
        while (true){
            if (demo.next == null){
                //表示这是最后一个节点
                break;
            }
            demo = demo.next;
        }
        demo.next = hero;
    }

    public void display(){
        /*if (demo.next == null){
            System.out.println("空");
            return;
        }*/

        HeroNode demo1 = heroNode;

        while (true){
            if (demo1.next == null){
                break;
            }
            demo1 = demo1.next;
            System.out.println(demo1);
        }
    }
}


class HeroNode{
    int no;
    String name;
    String nickName;
    HeroNode next;


    public HeroNode() {
    }

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}