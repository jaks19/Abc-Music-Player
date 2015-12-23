package abc.sound.ADTs;

import java.util.ArrayList;
import java.util.List;

import abc.sound.ClassCodeUsed.SequencePlayer;

/**
 * An immutable data type that implements the Bar interface
 * Represents a musical measure composed of Element instances
 */
public class Measure implements Bar {
    
    private final List<Element> listOfElements = new ArrayList<Element>();
    private final int duration;
    
    // Abstraction function:
    // - Represents a musical measure as an ordered collection of
    //   Element instances representing the order in which the music
    //   elements are played
    //
    // Representation invariant:
    // - listOfElements.size() >= 0
    // - duration >= 0
    //
    // Safety from representation exposure:
    // - all fields are private and final
    // - only immutable objects are ever returned

    /**
     * Constructor for Measure
     * @param listOfElements list of Element instances
     */
    public Measure(List<Element> listOfElements) {
        int durationTemp = 0;
        for (Element element : listOfElements) {
            this.listOfElements.add(element);
            durationTemp += element.duration();
        }
        this.duration = durationTemp;
        checkRep();
    }

    /**
     * Makes sure the representation invariant is obeyed
     */
    private void checkRep() {
        assert(this.listOfElements.size() >= 0);
        assert(this.duration >= 0);
    }

    @Override
    public int duration() {
        checkRep();
        return duration;
    }

    @Override
    public Bar transpose(int semitonesUp) {
        List<Element> transposedElements = new ArrayList<Element>();
        for (Element element : this.listOfElements) {
            transposedElements.add(element.transpose(semitonesUp));
        }
        checkRep();
        return new Measure(transposedElements);
    }

    @Override
    public void play(SequencePlayer player, int atTick) {
        for (Element element : this.listOfElements) {
            element.play(player, atTick);
        }
    }

    @Override
    public String toString(){
        String concatString = "";
        for (Element element : this.listOfElements) {
            concatString += element.toString() + " ";
        }
        if (concatString.length() > 0) {
            concatString.substring(0,concatString.length());
        }
        return concatString;
    }

    /**
     * Compares different Measure objects as containing all the
     * same Element objects within them
     * @param thatObject object to be compare to
     */
    @Override
    public boolean equals(Object thatObject){
        if (!(thatObject instanceof Measure)) { return false; }
        Measure thatMeasure = (Measure) thatObject;
        if (this.listOfElements.size() != thatMeasure.listOfElements.size()) {
            return false;
        }
        for (int i = 0 ; i < this.listOfElements.size() ; i++) {
            if (!thatMeasure.listOfElements.contains(this.listOfElements.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode(){
        int sum = 0;
        for (Element element : this.listOfElements) {
            sum += element.hashCode();
        }
        return sum + this.listOfElements.size();
    }
}