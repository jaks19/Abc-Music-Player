package abc.sound.LinkingClassesTests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import abc.sound.LinkingClasses.HeaderHolder;


public class HeaderHolderTest {

    //Partitions for HeaderHolder 
    //getIndexNumber() (Done)
    //-1 digit long, 2 digits long, 3 digits long.
    //String getTitle() (Done)
    //-String made up of chars only, letters, char+letters+symbols
    //String getKey() (Done)
    //-Note without accidental nor minor, note with accidental, note with accidental and minor.
    //List<Integer> getMeter() (Done)
    //- 'C','C|',1/n, n>0 (and integer), and general rational number as a quotient.
    //int getTempo() (Done)
    //small beats, large number of beats
    //List<Integer> getBeatsGivenLength() (Done)
    //-small numerator,small denominator,
    //String getComposer() (Done)
    //-Composer optional is not null, is null.
    //List<Integer> getLength() (Done)
    //- length is a rational number, L is omitted but Meter is not, L and meter are both omitted.
    //List<String> getVoices()
    //-
    @Test
    public void testIndexNumberOneDigitLong(){
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","Sun","Am",hasNothing,hasNothing,hasNothing,hasNothing,hasNothingList);
        assertEquals(1,test.getIndexNumber());
    }
    @Test
    public void testIndexNumberTwoDigitLong(){
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("78","Sun","Am",hasNothing,hasNothing,hasNothing,hasNothing,hasNothingList);
        assertEquals(78,test.getIndexNumber());
    }
    @Test
    public void testIndexNumberThreeDigitsLong(){
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("506","Sun","Am",hasNothing,hasNothing,hasNothing,hasNothing,hasNothingList);
        assertEquals(506,test.getIndexNumber());
    }

    //----------------------------------------------------------------------------------------------------------------------------
    @Test
    public void testGetTitleCharsOnly(){
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","Am",hasNothing,hasNothing,hasNothing,hasNothing,hasNothingList);
        assertEquals("SunAlgomas",test.getTitle());
    }
    @Test
    public void testGetTitleMixOfCharsNumbersAndSymbols(){
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","Es Algo mas que la distancia !@ @34 443~~~~~.","Am",hasNothing,hasNothing,hasNothing,hasNothing,hasNothingList);
        assertEquals("Es Algo mas que la distancia !@ @34 443~~~~~.",test.getTitle());
    }
    //---------------------------------------------------------------------------------------------------------------------------------------
    @Test
    public void testGetKeysWithNothing(){
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasNothing,hasNothing,hasNothing,hasNothingList);
        assertEquals("C",test.getKey());
    }
    @Test   
    public void testGetKeysWithSharpandMinor(){
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","c#m",hasNothing,hasNothing,hasNothing,hasNothing,hasNothingList);
        assertEquals("c#m",test.getKey());
    }
    @Test
    public void testGetKeysMoreComplex(){
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","bbm",hasNothing,hasNothing,hasNothing,hasNothing,hasNothingList);
        assertEquals("bbm",test.getKey());
    }
    //----------------------------------------------------------------------------------------------------------------------------------------
    @Test
    public void testGetMeterCommonTime(){
        List<Integer> result= new ArrayList<Integer>();
        result.add(4);
        result.add(4);
        Optional<String> hasSomething=Optional.of("C");
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasNothing,hasSomething,hasNothing,hasNothingList);
        assertEquals(result,test.getMeter());
    }
    @Test
    public void testGetMeterCutCommonTime(){
        List<Integer> result= new ArrayList<Integer>();
        result.add(2);
        result.add(2);
        Optional<String> hasSomething=Optional.of("C|");
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasNothing,hasSomething,hasNothing,hasNothingList);
        assertEquals(result,test.getMeter());
    }
    @Test
    public void testGetMeterCrazyRationalNumber(){
        List<Integer> result= new ArrayList<Integer>();
        result.add(62289);
        result.add(65985612);
        Optional<String> hasSomething=Optional.of("62289/65985612");
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasNothing,hasSomething,hasNothing,hasNothingList);
        assertEquals(result,test.getMeter());
    }
    @Test
    public void testGetMeterEmptyField(){
        List<Integer> result= new ArrayList<Integer>();
        result.add(4);
        result.add(4);
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasNothing,hasNothing,hasNothing,hasNothingList);
        assertEquals(result,test.getMeter());
    }
    //=============================================================================================================================
    @Test
    public void testGetTempoLarge(){
        List<Integer> result=new ArrayList<Integer>();
        result.add(1);
        result.add(64);
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        Optional<String> hasSomething=Optional.of("1/64=6352");
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasNothing,hasNothing,hasSomething,hasNothingList);
        assertEquals(6352,test.getTempo());
        assertEquals(result,test.getBeatsGivenLength());

    }
    @Test
    public void testGetTempoSmall(){
        List<Integer> result= new ArrayList<Integer> ();
        result.add(7878);
        result.add(355757);
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        Optional<String> hasSomething=Optional.of("7878/355757=2");
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasNothing,hasNothing,hasSomething,hasNothingList);
        assertEquals(2,test.getTempo());
        assertEquals(result,test.getBeatsGivenLength());
    }
    //=================================================================================================================================
    @Test
    public void testGetComposer(){
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        Optional<String> hasSomething= Optional.of("Con quien se queda el perro?578!");
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasSomething,hasNothing,hasNothing,hasNothing,hasNothingList);
        assertEquals("Con quien se queda el perro?578!",test.getComposer());
    }
    @Test
    public void testGetEmptyComposer(){
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasNothing,hasNothing,hasNothing,hasNothingList);
        assertEquals("Unknown",test.getComposer());
    }
    //=====================================================================================================================================
    @Test
    public void testGetLengthPresent(){
        List<Integer> result= new ArrayList<Integer>();
        result.add(635);
        result.add(850);
        Optional<String> hasSomething=Optional.of("635/850");
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasSomething,hasNothing,hasNothing,hasNothingList);
        assertEquals(result,test.getLength());
    }
    @Test
    public void testGetLengthNotPresentMeterIsPresent(){
        List<Integer> result= new ArrayList<Integer>();
        result.add(1);
        result.add(16);
        Optional<String> hasSomething=Optional.of("1/20");
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasNothing,hasSomething,hasNothing,hasNothingList);
        assertEquals(result,test.getLength());
    }
    @Test
    public void testGetLengthNotPresentMeterIsPresentLargerThan(){
        List<Integer> result= new ArrayList<Integer>();
        result.add(1);
        result.add(8);
        Optional<String> hasSomething= Optional.of("6/7");
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasNothing,hasSomething,hasNothing,hasNothingList);
        assertEquals(result,test.getLength());
    }
    @Test
    public void testGetLengthBothMeterAndLengthMissing(){
        List<Integer> result= new ArrayList<Integer>();
        result.add(1);
        result.add(8);
        Optional<String> hasNothing=Optional.empty();
        Optional<List<String>> hasNothingList=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasNothing,hasNothing,hasNothing,hasNothingList);
        assertEquals(result,test.getLength());
    }
    //=============================================================================================================================================
    @Test
    public void testGetVoicesEmptyList(){
        List<String> result= new ArrayList<String>();
        Optional<List<String>> hasSomethingList=Optional.of(result);
        Optional<String> hasNothing=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasNothing,hasNothing,hasNothing,hasSomethingList);
        assertEquals(result,test.getVoices());
    }
    @Test
    public void testGetVoicesNotEmpty(){
        List<String> result= new ArrayList<String>();
        result.add("Alberto");
        result.add("deez");
        result.add("nuts");
        Optional<List<String>> hasSomethingList=Optional.of(result);
        Optional<String> hasNothing=Optional.empty();
        HeaderHolder test= new HeaderHolder("1","SunAlgomas","C",hasNothing,hasNothing,hasNothing,hasNothing,hasSomethingList);
        assertEquals(result,test.getVoices());
    }
}
