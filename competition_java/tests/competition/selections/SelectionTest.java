package competition.selections;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import competition.competitor.Competitor;

/**
 * This class exists only to create the list of competitors and give it to the subclasses
 */
public abstract class SelectionTest {
    protected List<List<Competitor>> pools;
    protected Competitor cpt;
    protected Competitor cpt2;
    protected Competitor cpt3;
    protected Competitor cpt4;
    protected Competitor cpt5;
    protected Competitor cpt6;
    protected Competitor cpt7;
    protected Competitor cpt8;

    @BeforeEach
    public void Before(){
        pools = new ArrayList<List<Competitor>>();
        List<Competitor> pool;
        for(int i = 0;i<2;i++){
        	pools.add(new ArrayList<Competitor>());
            pool = pools.get(i);
            
        }
        cpt = new Competitor("Player 1");
        cpt.addPoints(4);
        cpt2 = new Competitor("Player 2");
        cpt2.addPoints(3);
        cpt3 = new Competitor("Player 3");
        cpt3.addPoints(2);
        cpt4 = new Competitor("Player 4");
        cpt4.addPoints(1);
        cpt5 = new Competitor("Player 5");
        cpt5.addPoints(4);
        cpt6 = new Competitor("Player 6");
        cpt6.addPoints(3);
        cpt7 = new Competitor("Player 7");
        cpt7.addPoints(2);
        cpt8 = new Competitor("Player 8");
        cpt8.addPoints(1);

        pool = pools.get(0);
        pool.add(cpt);
        pool.add(cpt2);
        pool.add(cpt3);
        pool.add(cpt4);

        pool = pools.get(1);
        pool.add(cpt5);
        pool.add(cpt6);
        pool.add(cpt7);
        pool.add(cpt8);
        }
    }
