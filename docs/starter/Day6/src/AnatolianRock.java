import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import java.awt.*;

/**
 * A program that authors random song lyrics in the genre of Turkish/Anatolian Rock
 * The main idea comes from Cem Yilmaz: https://www.youtube.com/watch?v=oXZY1YTLAHI
 * Each line in the lyrics is created by concatenating randomly selected elements from
 * string arrays *_left, *_mid, *_right 
 */
public class AnatolianRock extends ConsoleProgram {
	RandomGenerator rgen=RandomGenerator.getInstance();
	private String[] A_left={"Yar","Ah","Bak","Of","Hey","Deliyim"};
	private String[] A_mid={"bu beden","yatagim","yuregim","bu yaz","dort yanim","ruyalar"};
	private String[] A_right={"buz kesti","ozler seni","alev alev","toz duman","kavruldu","delik desik"};

	private String[] B_left={"bittim","gittin","sensiz","simdi","yalniz","sonunda"};
	private String[] B_mid={"oldum","gonul","canim","dunyam","ruhum","aklim"};
	private String[] B_right={"divane","avare","virane","bicare","amade","pervane"};

	private String[] NAKARAT_left={"e hadi","kiz sen","bu gece","a canim","deli yar","sebebim"};
	private String[] NAKARAT_mid={"fikrimi","tenimi","askimi","kalbimi","omrumu","sevdami"};
	private String[] NAKARAT_right={"benden cal","surgune sal","yollara vur","dagit, savur","atese at","ruhuna kat"};
	
	public void run(){
		println("--------A-----------");
		printRandomSequence(A_left,A_mid,A_right,4);
		println("------NAKARAT-------");
		printRandomSequence(NAKARAT_left,NAKARAT_mid,NAKARAT_right,4);
		println("--------B-----------");
		printRandomSequence(B_left,B_mid,B_right,4);		
	}
	private void printRandomSequence(String[] left,String[] mid,String[] right,int numLines){
		for(int i=0;i<numLines;i++){
			print(left[rgen.nextInt(0,left.length-1)]+" ");
			print(mid[rgen.nextInt(0,mid.length-1)]+" ");
			println(right[rgen.nextInt(0,right.length-1)]);
		}
	}
}
