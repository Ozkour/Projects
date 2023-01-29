package observer;

public class MockMatchObserver extends MatchObserver{

    public int applyCalled = 0;

    public MockMatchObserver(){
        super();
    }

    public void reaction(Competitor c1, Competitor c2){
        this.applyCalled = this.applyCalled + 1;
    }
    
}
