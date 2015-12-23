package abc.sound.LinkingClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//This class holds information about header. It represents the header of a piece of music.
public class HeaderHolder {
    //Abstract data type
    //Abstraction function: Maps indexNumbers,titles,meter,tempo,beatsPerLength,composer, 
    // and length into the header of a piece of music.
    //Representation Invariant:
    //None (Other than implicit none null values).
    //Representation Exposure:
    //-All fields are private and final
    //-All non-primitive types, specifically the list types are made within the constructors and have no leaks 
    //in the constructor.
    //-Each method that returns, either returns a final primitive or uses defensive copying for lists. Hence no 
    //representation exposure.

    private final int indexNumber;
    private final String title;
    private final String key;

    private final List<Integer> meter;
    private final int tempo;
    private final List<Integer> beatsGivenLength;
    private final String composer;
    private final List<Integer> Length;
    private final List<String> voices;

    public HeaderHolder(String X,String T, String K ,Optional<String> C,Optional<String> L, Optional<String> M, Optional<String> Q, Optional<List<String>> V)
    {
        this.indexNumber=Integer.parseInt(X);
        this.title=T;

        this.key=K;
        if(C.isPresent()){
            this.composer=C.get();
        }
        else{
            this.composer="Unknown";
        }

        if(M.isPresent()){
            if(M.get().equals("C")){
                this.meter=Arrays.asList(4,4);
            }
            else{
                if(M.get().equals("C|")){
                    this.meter=Arrays.asList(2,2);
                }
                else{
                    String[] numAndDen;
                    numAndDen=M.get().split("/");
                    this.meter=Arrays.asList(Integer.parseInt(numAndDen[0]),Integer.parseInt(numAndDen[1])); 
                }
            }
        }
        else{
            this.meter=Arrays.asList(4,4);
        }

        if(L.isPresent()){
            String[] numAndDen;
            numAndDen=L.get().split("/");
            this.Length=Arrays.asList(Integer.parseInt(numAndDen[0]),Integer.parseInt(numAndDen[1]));
        }
        else{
            if (M.isPresent()){
                if (((1.0)*this.meter.get(0))/this.meter.get(1)<0.75){
                    this.Length=Arrays.asList(1,16);
                }
                else{
                    this.Length=Arrays.asList(1,8);
                }
            }
            else{
                this.Length=Arrays.asList(1,8);
            }

        }

        if (Q.isPresent()){
            String[] numAndDen;
            String[] twoAndAHalfMen;
            twoAndAHalfMen=Q.get().split("=");
            numAndDen=twoAndAHalfMen[0].split("/");
            this.tempo=Integer.parseInt(twoAndAHalfMen[1]);
            this.beatsGivenLength=Arrays.asList(Integer.parseInt(numAndDen[0]),Integer.parseInt(numAndDen[1]));
        }
        else{
            this.tempo=100;
            this.beatsGivenLength=this.Length;
        }
        if (V.isPresent()){
            List<String> voices= new ArrayList<String>();
            voices.addAll(V.get());
            this.voices=voices;
        }
        else{
            this.voices=new ArrayList<String>();
        }
    }

    /**
     * Returns the IndexNumber of the song
     * @return int the indexNumber
     */
    public int getIndexNumber(){
        return indexNumber;
    }

    /**
     * Returns the title of a song.
     * @return String title string that represents title.
     */
    public String getTitle(){
        return title;
    }

    /**
     * Gets the String representation of the Key that includes relavent modifications (e.g sharps)
     * @return String key without any modification (e.g sharp, flat).
     */
    public String getKey(){
        return key;
    }

    /**
     * Gets the meter from the header.
     * This rational number represents the meter of the music piece
     * When the field M is omitted, the default meter is 4/4
     * @return List of length 2, where the index 0:the numerator and index1:the denominator 
     */
    public List<Integer> getMeter(){
        List<Integer> finalMeter= new ArrayList<>();
        finalMeter.addAll(this.meter);
        return finalMeter;
    }

    /**
     * Gets the tempo of the header.
     * @return int the tempo as an integer representing number of beats to play per minute
     * When the field Q is omitted, the default tempo is 100 beats per minute, 
     * where a beat is the default note length given by field L
     */
    public int getTempo(){
        return this.tempo;
    }

    /**
     * Gets the BeatsPerLength
     * @return the given length of the tempo
     */
    public List<Integer> getBeatsGivenLength(){
        List<Integer> finalBeatsLength= new ArrayList<>();
        finalBeatsLength.addAll(this.beatsGivenLength);
        return finalBeatsLength;
    }

    /**
     * Gets the title of the composer of this piece of music.
     * @return String The composer name
     */
    public String getComposer(){
        return this.composer;
    }

    /**
     * Gets the length of the piece of music.
     * @return The length in terms of a rational number represented 
     *  a list of length 2 where index0:numerator and index1=denominator.
     */
    public List<Integer> getLength(){
        List<Integer> finalLengthList= new ArrayList<>();
        finalLengthList.addAll(this.Length);
        return finalLengthList;
    }

    /**
     * Gets voices of the header of the music piece.
     * @return List of voices of music. If no voices are given the length of the list is 0 (hence empty).
     */
    public List<String> getVoices(){
        List<String> finalVoices= new ArrayList<>();
        finalVoices.addAll(this.voices);
        return finalVoices;
    }
}
