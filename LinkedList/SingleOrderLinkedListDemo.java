package LinkedList;

public class SingleOrderLinkedListDemo {
    public static void main(String[] args) {
        SingleOrderLinkedList singleOrderLinkedList = new SingleOrderLinkedList();

        HeroNodeOrder headHeroNode1 = new HeroNodeOrder(1,"宋江1","及时雨1");
        HeroNodeOrder headHeroNode2 = new HeroNodeOrder(2,"宋江2","及时雨2");
        HeroNodeOrder headHeroNode4 = new HeroNodeOrder(4,"宋江4","及时雨4");
        HeroNodeOrder headHeroNode3 = new HeroNodeOrder(3,"宋江3","及时雨3");


        /*singleOrderLinkedList.addHero(headHeroNode1);
        singleOrderLinkedList.addHero(headHeroNode4);
        singleOrderLinkedList.addHero(headHeroNode3);
        singleOrderLinkedList.addHero(headHeroNode2);*/
        singleOrderLinkedList.addByOrder(headHeroNode3);
        singleOrderLinkedList.addByOrder(headHeroNode1);
        singleOrderLinkedList.addByOrder(headHeroNode2);
        singleOrderLinkedList.addByOrder(headHeroNode4);



        singleOrderLinkedList.display();

    }
}

class SingleOrderLinkedList{
    private HeroNodeOrder heroNodeOrder = new HeroNodeOrder(0,"","");
    private HeroNodeOrder saveNode = new HeroNodeOrder(0,"","");

    HeroNodeOrder demo = heroNodeOrder;//指针赋给demo demo为头节点
    HeroNodeOrder head = heroNodeOrder;//指针赋给demo demo为头节点
    HeroNodeOrder temp = heroNodeOrder;//指针赋给demo demo为头节点

    public void addHero(HeroNodeOrder hero){
        /*while (true){
            if (demo.next == null){
                //表示这是最后一个节点
                break;
            }
            demo = demo.next;
        }
        demo.next = hero;*/


        if (head.next == null){
            //则为第一个节点
            head.next = hero;
        }else {
            while (hero.no > head.next.no){
                head = head.next;
                if (head.next == null){
                    break;
                }
            }
            saveNode = head.next;//第n个Node给了saveNode
            head.next = hero;
            hero.next = saveNode;
        }
    }

    public void addByOrder(HeroNodeOrder hero){
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;//找到最后直接break
            }
            if (temp.next.no > hero.no){
                //temp的下一个点大于hero
                break;
            }else if (temp.next.no == hero.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            System.out.println("已经存在");
        }else {
            hero.next = temp.next;
            temp.next = hero;
        }
    }

    public void display(){
        /*if (demo.next == null){
            System.out.println("空");
            return;
        }*/

        HeroNodeOrder demo1 = heroNodeOrder;

        while (true){
            if (demo1.next == null){
                break;
            }
            demo1 = demo1.next;
            System.out.println(demo1);
        }
    }
}


class HeroNodeOrder{
    int no;
    String name;
    String nickName;
    HeroNodeOrder next;


    public HeroNodeOrder() {
    }

    public HeroNodeOrder(int no, String name, String nickName) {
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