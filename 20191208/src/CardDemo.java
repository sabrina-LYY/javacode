import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

class Card{
    public String suit;
    public int rank;
    public Card(String suit,int rank){
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]", suit, rank);
    }
}
public class CardDemo {
    public static final String[] suits = {"♥","♦","♣","♠" };
    //买一副牌
    private  static List<Card> buyDeck(){
        List<Card> deck = new ArrayList<>(52);
        //4个花色
        for(int i=0;i<4;i++){
            for(int j=1;j<=13;j++){
                String suit = suits[i];
                Card card = new Card(suit,j);
                //add表示尾插
                deck.add(card);//个人手里的牌数量增加
            }
        }
        return deck;
    }
    //洗牌
    private void swap(List<Card> deck,int start,int end){
        Card tmp = deck.get(start);//get表示获取相应位置的元素
        deck.set(start,deck.get(end));
        deck.set(end,tmp);//设置已有元素的下标位置的值，tmp的值给end
    }

    public void shuffle(List<Card> deck){
        Random random = new Random(20191208);
        for(int i = deck.size()-1;i>0;i--){
            int index = random.nextInt(i);//产生随机数的范围[0,i)
            swap(deck,i,index);//每次第i个数和前面随机的第index个数交换即完成洗牌
        }
    }

}
