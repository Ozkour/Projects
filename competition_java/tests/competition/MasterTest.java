package competition;

import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import competition.competitor.*;
import competition.selections.Selection;
import competition.selections.SelectionFirsts;

public class MasterTest extends CompetitionTest{

    protected Competitor competitor4;
    protected int nbGroups;
    protected int sizeGroups;
    protected SelectionFirsts select1;
    protected List<Selection> listSelection = new ArrayList<Selection>();;

    @BeforeEach
    public void BeforeM() {
        this.competitor4 = new Competitor("Lulu");
        this.select1 = new SelectionFirsts(1);
        this.listSelection.add(this.select1);

    }

    protected Competition createCompetition() {
    	this.nbGroups = 2;
        this.sizeGroups = 2;
        return new Master(this.competitors,listSelection,nbGroups,sizeGroups);
    }

    //le problème de rapport entre la taille des groupes, le nombre de groupe et le nombre de joueur est géré dans le MasterMain 

    @Test 
    public void aGroupIsWellCreatedWithTheNumberOfGroupsAndTheSizeOfAGroup(){
    	this.competitors.add(competitor4);
        List<List<Competitor>> res = ((Master) this.compet).createGroups(competitors);
        assertEquals(2,res.size());
        assertEquals(2,res.get(0).size());
        assertEquals(2,res.get(1).size());
    }

    //on selectionne bien des joueurs dans un cas sans probleme
    @Test 
    public void theSelectionIsWellDoneOnCompetitorsWithoutIsPowerOfTwoIssues(){
    	this.competitors.add(competitor4);
        List<List<Competitor>> groups = ((Master) this.compet).createGroups(competitors);
        this.competitor.addPoints(4); 
        this.competitor2.addPoints(3);
        this.competitor3.addPoints(4);
        this.competitor4.addPoints(3);
        
        List<Competitor> res = ((Master) this.compet).doTheSelection(groups);  // on doit avoir competitor et competitor3 qui gagnent 
        assertEquals(2,res.size());
        assertSame(competitor,res.get(0));
        assertSame(competitor3,res.get(1));

    }

    //on supprime bien un element lorsque cas a probleme 
    @Test 
    public void aCompetitorIsRemovedAfterASelectionWhenWeDontHaveAPowerOfTwo(){

        ((Master) compet).setNbGroups(3);
        ((Master) compet).setSizeGroups(1);

        List<List<Competitor>> groups = ((Master) compet).createGroups(competitors);

        // on fait la selection, nos 3 compétitors doivent nous être renvoyés
        List<Competitor> res = ((Master) compet).doTheSelection(groups);  // comme nous en avons 3, un competiteur aléatoire a dû être supprimé
        assertEquals(2,res.size());


    }

   
    

}
